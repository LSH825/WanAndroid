package com.lsh.wanandroid.ui.tab;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lsh.common.http.ApiCallBack;
import com.lsh.common.http.HttpManager;
import com.lsh.wanandroid.R;
import com.lsh.wanandroid.base.BaseFragment;
import com.lsh.wanandroid.entity.TreeEntity;
import com.lsh.wanandroid.ui.tree.TreeListAdapter;

import butterknife.BindView;

/**
 * 体系
 */
public class TabTreeFragment extends BaseFragment {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private TabTreeFragment() {

    }

    public static TabTreeFragment newInstance() {
        return new TabTreeFragment();
    }


    @Override
    public int getContentLayout() {
        return R.layout.fragment_tab_tree;
    }

    @Override
    public void initView() {
        getDataList();
    }

    private void getDataList() {
        HttpManager.getTree(new ApiCallBack<TreeEntity>() {
            @Override
            public void onSuccess(TreeEntity resultEntity) {
                super.onSuccess(resultEntity);
                recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                if (resultEntity.getData() != null) {
                    recyclerView.setAdapter(new TreeListAdapter(resultEntity.getData()));
                }

            }

            @Override
            public void onFailure(int code, String msg, TreeEntity resultEntity) {
                super.onFailure(code, msg, resultEntity);
            }
        });
    }
}
