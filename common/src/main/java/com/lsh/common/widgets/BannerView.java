package com.lsh.common.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public class BannerView extends FrameLayout {
    private RecyclerView.Adapter adapter;
    private  ViewPager2 viewPager2;

    public BannerView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public BannerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BannerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void show(RecyclerView.Adapter adapter) {
        this.adapter = adapter;
        if (adapter != null) {
            viewPager2.setAdapter(adapter);
        }
    }

    private void init(Context context) {
        removeAllViews();
        addView(viewPager2 = getBannerImg());
        addView(getBannerPoint());
    }

    private ViewPager2 getBannerImg() {
        return new ViewPager2(getContext());
    }

    private View getBannerPoint() {
        return new View(getContext());
    }

}
