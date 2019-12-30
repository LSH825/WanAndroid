package com.lsh.wanandroid.ui.tab;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lsh.common.http.ApiCallBack;
import com.lsh.common.http.HttpManager;
import com.lsh.common.http.ResultEntity;
import com.lsh.common.widgets.BannerView;
import com.lsh.common.widgets.RecyclerViewHelper;
import com.lsh.wanandroid.R;
import com.lsh.wanandroid.base.BaseFragment;
import com.lsh.wanandroid.entity.ArticleDetailBean;
import com.lsh.wanandroid.entity.BannerEntity;
import com.lsh.wanandroid.entity.HomeEntity;
import com.lsh.wanandroid.entity.TopArticleEntity;
import com.lsh.wanandroid.ui.home.BannerAdapter;
import com.lsh.wanandroid.ui.home.HomeListAdapter;
import com.lsh.wanandroid.utils.PageManager;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 *
 */
public class TabHomeFragment extends BaseFragment {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout refreshLayout;
    private BannerView bannerView;
    private RecyclerViewHelper<ArticleDetailBean> helper;

    private TabHomeFragment() {
    }

    public static TabHomeFragment newInstance() {
        return new TabHomeFragment();
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        helper = new RecyclerViewHelper<ArticleDetailBean>(refreshLayout) {
            @Override
            protected View getHeaderView() {
                View headView = getViewByLayId(R.layout.include_head_banner_view);
                initHeadView(headView);
                return headView;
            }

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

    private void initHeadView(View headView) {
        bannerView = headView.findViewById(R.id.banner_view);
        getBanner();
    }

    private void getBanner() {
        HttpManager.getBanner(new ApiCallBack<BannerEntity>() {
            @Override
            public void onSuccess(BannerEntity resultEntity) {
                bannerView.show(new BannerAdapter(resultEntity.getData()));
            }
        });
    }

    private TopArticleEntity topArticleEntity;
    private HomeEntity homeEntity;

    private void getDataList(int page) {
        if (page == 1) {
            HttpManager.getTopArticle(new ApiCallBack<TopArticleEntity>() {
                @Override
                public void onSuccess(TopArticleEntity resultEntity) {
                    super.onSuccess(resultEntity);
                    topArticleEntity = resultEntity;
                    showFirst();
                }

                @Override
                public void onFailure(int code, String msg, TopArticleEntity resultEntity) {
                    super.onFailure(code, msg, resultEntity);
                    topArticleEntity = new TopArticleEntity();
                    showFirst();
                }
            });
            HttpManager.getArticle(page, new ApiCallBack<HomeEntity>() {
                @Override
                public void onSuccess(HomeEntity resultEntity) {
                    homeEntity = resultEntity;
                    showFirst();
                }

                @Override
                public void onFailure(int code, String msg, HomeEntity resultEntity) {
                    homeEntity = new HomeEntity();
                    showFirst();
                }
            });
        } else {
            HttpManager.getArticle(page, new ApiCallBack<HomeEntity>() {
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

    private void showFirst() {
        if (topArticleEntity != null && homeEntity != null) {
            List<ArticleDetailBean> articleList = new ArrayList<>();
            articleList.addAll(topArticleEntity.getData());
            if (homeEntity.getData() != null) {
                articleList.addAll(homeEntity.getData().getDatas());
            }
            helper.setData(articleList);
        }

    }

}
