package com.lsh.common.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class BannerView extends FrameLayout {
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

    private void init(Context context) {
        removeAllViews();
        addView(getBannerImg());
        addView(getBannerPoint());
    }

    private View getBannerImg() {
        return new RecyclerView(getContext());
    }

    private View getBannerPoint() {
        return new View(getContext());
    }
}
