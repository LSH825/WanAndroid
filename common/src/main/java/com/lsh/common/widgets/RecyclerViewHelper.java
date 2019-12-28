package com.lsh.common.widgets;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import com.lsh.common.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

public abstract class RecyclerViewHelper<T> {
    protected SmartRefreshLayout refreshLayout;
    protected RecyclerView recyclerView;
    private Context mContext;
    protected BaseQuickAdapter mAdapter;
    private int page = 1;
    protected ArrayList<T> mDataList = new ArrayList<>();
    private boolean hasHead;
    private int pageLimit = 10;

    protected RecyclerViewHelper(View rootView) {
        this(rootView, R.id.refresh_layout, R.id.recycler_view);
    }

    private RecyclerViewHelper(View rootView, int refreshLayoutId, int recyclerViewId) {
        mContext = rootView.getContext();
        refreshLayout = rootView.findViewById(refreshLayoutId);
        recyclerView = rootView.findViewById(recyclerViewId);
        init();
    }

    private void init() {
        beforeInit();
        refreshLayout.setEnableLoadMore(false);
        refreshLayout.setEnableRefresh(false);
        recyclerView.setLayoutManager(getLayoutManager());
        mAdapter = getAdapter();
        View headView = getHeaderView();
        if (headView != null) {
            hasHead = true;
            mAdapter.addHeaderView(headView);
        }
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                onAdapterItemClick(adapter, view, position);
            }
        });
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                RecyclerViewHelper.this.onItemChildClick(adapter, view, position);
            }
        });
        recyclerView.setAdapter(mAdapter);
        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                page++;
                getData();
            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                page = 1;
                getData();
            }
        });
        setEmptyView();
        onLoading();
        if (isFirstGetData()) {
            getData();
        }
        afterInit();
    }

    /**
     * 是否首次进入获取数据
     */
    protected boolean isFirstGetData() {
        return true;
    }

    protected void beforeInit() {

    }

    protected void afterInit() {

    }

    protected void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(mContext);
    }

    protected abstract BaseQuickAdapter getAdapter();

    public BaseQuickAdapter getBaseAdapter() {
        return mAdapter;
    }

    protected View getHeaderView() {
        return null;
    }

    protected View getViewByLayId(int layId) {
        return LayoutInflater.from(mContext).inflate(layId, recyclerView, false);
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void refreshItem(int index) {
        if (mAdapter != null) {
            mAdapter.refreshNotifyItemChanged(index);
        }
    }

    protected abstract void getData();

    public void setNewData(List<T> list) {
        mDataList.clear();
        mDataList.addAll(list);
        mAdapter.setNewData(list);
    }

    public void setData(List<T> list) {
        handlerRefreshResult();
        if (page == 1) {
            mDataList.clear();
            if (list == null || list.size() == 0) {
                refreshLayout.setEnableLoadMore(false);
                EmptyDataBean bean = getEmptyStyleBean();
                setEmptyStyle(bean.errorCode, bean.msg, bean.bgColor);
            } else {
                refreshLayout.setEnableLoadMore(true);
                mDataList.addAll(list);
            }
            mAdapter.removeAllFooterView();
            mAdapter.setNewData(list);
        } else {
            if (list == null || list.size() == 0) {
                mAdapter.addFooterView(getViewByLayId(R.layout.foot_list_no_more_data));
                refreshLayout.setEnableLoadMore(false);
            } else {
                mAdapter.removeAllFooterView();
                mDataList.addAll(list);
                mAdapter.addData(list);
            }

        }
        //数据不足禁止加载更多
        if (!hasMore) {
            if (list != null && list.size() < pageLimit && list.size() > 0) {
                mAdapter.addFooterView(getViewByLayId(R.layout.foot_list_no_more_data));
                refreshLayout.setEnableLoadMore(false);
            }
        }
    }


    public void setError(int errorCode, String msg) {
        handlerRefreshResult();
        if (page == 1) {
            mDataList.clear();
            mAdapter.setNewData(null);
            refreshLayout.setEnableLoadMore(false);
            if (errorCode == 0) {//空白页
                EmptyDataBean bean = getEmptyStyleBean();
                setEmptyStyle(bean.errorCode, bean.msg, bean.getBgColor());
            } else {//其他错误页
                EmptyDataBean bean = getEmptyStyleBean();
                setEmptyStyle(errorCode, msg, bean.bgColor);
            }
        } else {
            if (errorCode == 0) {//没有更多数据
                View view = getViewByLayId(R.layout.foot_list_no_more_data);
                TextView tv_foot_no_more = view.findViewById(R.id.tv_foot_no_more);
                tv_foot_no_more.setTextColor(getFootTextColor());
                mAdapter.addFooterView(view);
            } else {//错误提示
//                Toast.makeText().showToast(mContext, msg);
            }
            refreshLayout.setEnableLoadMore(false);
        }
    }

    public void handlerRefreshResult() {
        hideSkeleton();
        refreshLayout.setEnableRefresh(true);
        finishRefresh();
    }

    private boolean hasMore = false;

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    protected int getFootTextColor() {
        return Color.parseColor("#999999");
    }

    private void finishRefresh() {
        refreshLayout.finishRefresh();
        refreshLayout.finishLoadMore(0);
    }

    protected void onAdapterItemClick(BaseQuickAdapter adapter, View view, int position) {
    }


    public int getTotalDataSize() {
        return mDataList.size();
    }

    public T getLastItemData() {
        if (mDataList.size() > 0) {
            return mDataList.get(mDataList.size() - 1);
        }
        return null;
    }

    /*---------------------loading----------------------------*/
//    private SkeletonScreen skeletonScreen;
//
//    private void showSkeleton() {
//        recyclerView.setLayoutManager(getLayoutManager());
//        skeletonScreen = Skeleton.bind(recyclerView)
//                .adapter(mAdapter)
//                .color(R.color.skeleton_shimmer_color)
//                .load(getSkeletonItemLayout())
//                .show();
//    }
//
    private void hideSkeleton() {
//        if (skeletonScreen != null) {
//            if (page == 1) {
//                skeletonScreen.hide();
//            }
//        }
    }

    protected int getSkeletonItemLayout() {
        return 0;
    }

    /*--------------------------------------------------------------*/
    private void setEmptyView() {
        mAdapter.setHeaderAndEmpty(true);
        View view = getEmptyView();
        if (view != null) {
            mAdapter.setEmptyView(view);
        }
    }

    protected boolean getShowFullEmpty() {
        return true;
    }

    protected View getEmptyView() {
        int emptyLayout;
        if (hasHead || !getShowFullEmpty()) {//不显示居中布局（某些情况显示不合理）
            emptyLayout = R.layout.status_empty_head;
        } else {
            emptyLayout = R.layout.status_list_empty_base;
        }
        View view = LayoutInflater.from(mContext).inflate(emptyLayout, recyclerView, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });
        return view;
    }

    protected EmptyDataBean getEmptyStyleBean() {
        return new EmptyDataBean(404, "没有数据");
    }

    private void setEmptyStyle(int errorCode, String msg, String bgColor) {
//        if (emptyView != null) {
//            emptyView.setErrorCode(errorCode, msg, bgColor);
//        }
    }

    protected void onLoading() {
//        if (getSkeletonItemLayout() == 0) {
//            EmptyDataBean dataBean = getEmptyStyleBean();
//            if (emptyView != null) {
//                emptyView.setBg(dataBean.bgColor);
//            }
//            if (emptyView != null) {
//                emptyView.onLoading();
//            }
//        } else {
//            showSkeleton();
//        }


    }

    public static class EmptyDataBean {
        private int errorCode;
        private String msg;
        private String bgColor;

        public EmptyDataBean(int errorCode, String msg) {
            this.errorCode = errorCode;
            this.msg = msg;
        }

        public EmptyDataBean(int errorCode, String msg, String bgColor) {
            this.errorCode = errorCode;
            this.msg = msg;
            this.bgColor = bgColor;
        }

        public String getBgColor() {
            return bgColor;
        }

        public void setBgColor(String bgColor) {
            this.bgColor = bgColor;
        }

        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
