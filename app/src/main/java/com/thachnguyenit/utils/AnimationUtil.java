package com.thachnguyenit.utils;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class AnimationUtil {

    public static void scaleAll(View view, float toScale) {
        view.animate().scaleX(toScale).scaleY(toScale);
    }

}
