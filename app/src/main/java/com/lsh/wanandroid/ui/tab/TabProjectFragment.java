package com.lsh.wanandroid.ui.tab;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.lsh.wanandroid.R;
import com.lsh.wanandroid.base.BaseFragment;
import com.lsh.wanandroid.base.BaseFragmentPagerAdapter;
import com.lsh.wanandroid.ui.ProjectFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TabProjectFragment extends BaseFragment {
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager2 viewPager;

    private TabProjectFragment() {
    }

    public static TabProjectFragment newInstance() {
        return new TabProjectFragment();
    }


    @Override
    public int getContentLayout() {
        return R.layout.fragment_tab_project;
    }

    @Override
    public void initView() {
        List<Fragment> fragmentList = new ArrayList<>();
        List<String> titleList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            titleList.add("item" + i);
            fragmentList.add(ProjectFragment.newInstance(""));
        }
        viewPager.setAdapter(new BaseFragmentPagerAdapter(this, fragmentList));
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.OnConfigureTabCallback() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(titleList.get(position));
            }
        }).attach();

    }
}
