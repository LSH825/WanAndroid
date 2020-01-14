package com.lsh.wanandroid.ui.tree;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lsh.common.http.ApiCallBack;
import com.lsh.common.http.HttpManager;
import com.lsh.common.widgets.RecyclerViewHelper;
import com.lsh.wanandroid.R;
import com.lsh.wanandroid.base.BaseActivity;
import com.lsh.wanandroid.entity.ArticleDetailBean;
import com.lsh.wanandroid.entity.HomeEntity;
import com.lsh.wanandroid.ui.home.HomeListAdapter;
import com.lsh.wanandroid.utils.PageManager;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;

public class TreeDetailListActivity extends BaseActivity {
    public static final String KEY_INTENT_CID = "INTENT_CID";
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout refreshLayout;
    RecyclerViewHelper helper;
    private String cid;

    @Override
    public int getContentLayout() {
        return R.layout.activity_tree_detail_list;
    }

    @Override
    public void initView() {
        cid = getIntent().getStringExtra(KEY_INTENT_CID);
        helper = new RecyclerViewHelper<ArticleDetailBean>(refreshLayout) {

            @Override
            protected BaseQuickAdapter getAdapter() {
                return new HomeListAdapter(mDataList);
            }

            @Override
            protected void onAdapterItemClick(BaseQuickAdapter adapter, View view, int position) {
                ArticleDetailBean bean = (ArticleDetailBean) adapter.getItem(position);
                if (bean != null) {
                    PageManager.openWebViewActivity(mContext, bean.getLink());
                }

            }

            @Override
            protected void getData() {
                getDataList(getPage());
            }
        };
    }

    private void getDataList(int page) {
        HttpManager.getTreeArticle(page, cid, new ApiCallBack<HomeEntity>() {
            @Override
            public void onSuccess(HomeEntity resultEntity) {
                helper.setData(resultEntity.getData().getDatas());
            }

            @Override
            public void onFailure(int code, String msg, HomeEntity resultEntity) {

            }
        });


    }
}
