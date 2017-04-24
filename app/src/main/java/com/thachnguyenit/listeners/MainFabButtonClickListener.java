package com.thachnguyenit.listeners;

import android.view.View;

import com.thachnguyenit.utils.AnimationUtil;

public class MainFabButtonClickListener implements View.OnClickListener {

    View[] views;

    public static final float MAX_SCALE = 1.2f;

    public static final float NORMAL_SCALE = 1f;

    public MainFabButtonClickListener(View... views) {
        this.views = views;
    }

    @Override
    public void onClick(View v) {
        if (views.length == 0) {
            return;
        }
        AnimationUtil.scaleAll(views[0], MAX_SCALE);
        if (views.length == 1) {
            return;
        }
        for (int i = 1; i < views.length; i++) {
            AnimationUtil.scaleAll(views[i], NORMAL_SCALE);
        }
    }
}
