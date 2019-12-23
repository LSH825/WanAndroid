package com.lsh.wanandroid.base;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class BaseFragmentPagerAdapter extends FragmentStateAdapter {
    private List<Fragment> fragmentList;

    public BaseFragmentPagerAdapter(@NonNull FragmentActivity fragmentActivity, @NonNull List<Fragment> list) {
        super(fragmentActivity);
        this.fragmentList = list;
    }

    public BaseFragmentPagerAdapter(@NonNull Fragment fragment, @NonNull List<Fragment> list) {
        super(fragment);
        this.fragmentList = list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }
}
