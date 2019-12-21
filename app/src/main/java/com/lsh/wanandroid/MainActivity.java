package com.lsh.wanandroid;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lsh.wanandroid.base.BaseActivity;
import com.lsh.wanandroid.base.BaseFragmentPagerAdapter;
import com.lsh.wanandroid.ui.HomeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.bottom_nav)
    BottomNavigationView bottomNav;

    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        viewPager.setAdapter(new BaseFragmentPagerAdapter(getSupportFragmentManager(), getTabFragment()));
        setUpWithViewPager(viewPager);
    }

    private void setUpWithViewPager(ViewPager viewPager) {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                View view = bottomNav.getMenu();
//                bottomNav.setSelectedItemId(view.getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bottomNav.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.nav_bottom_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.nav_bottom_1:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.nav_bottom_mine:
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        });
    }


    private List<Fragment> getTabFragment() {
        List<Fragment> list = new ArrayList<>();
        list.add(HomeFragment.newInstance());
        list.add(HomeFragment.newInstance());
        list.add(HomeFragment.newInstance());
        return list;
    }
}
