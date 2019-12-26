package com.lsh.wanandroid;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lsh.wanandroid.base.BaseActivity;
import com.lsh.wanandroid.base.BaseFragmentPagerAdapter;
import com.lsh.wanandroid.ui.tab.TabHomeFragment;
import com.lsh.wanandroid.ui.tab.TabMineFragment;
import com.lsh.wanandroid.ui.tab.TabProjectFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.view_pager)
    ViewPager2 viewPager;
    @BindView(R.id.bottom_nav)
    BottomNavigationView bottomNav;

    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        viewPager.setAdapter(new BaseFragmentPagerAdapter(this, getTabFragment()));
        viewPager.setUserInputEnabled(false);
        setUpWithViewPager(viewPager);
    }

    private int[] mItemIdArray = {R.id.nav_bottom_home, R.id.nav_bottom_1, R.id.nav_bottom_mine};

    private void setUpWithViewPager(ViewPager2 viewPager) {
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                bottomNav.setSelectedItemId(mItemIdArray[position]);
            }
        });
        bottomNav.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.nav_bottom_home:
                    viewPager.setCurrentItem(0, false);
                    return true;
                case R.id.nav_bottom_1:
                    viewPager.setCurrentItem(1, false);
                    return true;
                case R.id.nav_bottom_mine:
                    viewPager.setCurrentItem(2, false);
                    return true;
            }
            return false;
        });
    }


    private List<Fragment> getTabFragment() {
        List<Fragment> list = new ArrayList<>();
        list.add(TabHomeFragment.newInstance());
        list.add(TabProjectFragment.newInstance());
        list.add(TabMineFragment.newInstance());
        return list;
    }
}
