package com.lsh.wanandroid.ui.tree;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.lsh.common.utils.StringUtils;
import com.lsh.wanandroid.R;
import com.lsh.wanandroid.entity.TreeEntity;
import com.lsh.wanandroid.utils.PageManager;

import java.util.List;

public class TreeListAdapter extends BaseQuickAdapter<TreeEntity.DataBean, BaseViewHolder> {
    public TreeListAdapter(@Nullable List<TreeEntity.DataBean> data) {
        super(R.layout.item_list_tree, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, TreeEntity.DataBean item) {
        helper.setText(R.id.tv_title, StringUtils.getSafeString(item.getName()));
        List<TreeEntity.DataBean.ChildrenBean> list = item.getChildren();
        RecyclerView recyclerView = helper.getView(R.id.recycler_view);
        if (list == null) {
            recyclerView.setVisibility(View.GONE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            recyclerView.setLayoutManager(new FlexboxLayoutManager(mContext));
            TreeFlexAdapter adapter = new TreeFlexAdapter(list);
            recyclerView.setAdapter(adapter);
            adapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    TreeEntity.DataBean.ChildrenBean childrenBean = (TreeEntity.DataBean.ChildrenBean) adapter.getItem(position);
                    if (childrenBean!=null) {
                        PageManager.openTreeDetailListActivity(mContext, childrenBean.getId());
                    }

                }
            });
        }

    }
}
