package example.com.myproject.utils;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

import java.util.Random;

public class BackgroundUtil {

    public static GradientDrawable createBackgroundRandom() {
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(color);
        gd.setCornerRadius(5);
        gd.setAlpha(90);
        return gd;
    }

}
