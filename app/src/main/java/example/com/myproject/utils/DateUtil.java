package example.com.myproject.utils;


import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static final String formatDate(Date date, String pattern) {
        if (date == null)
            return null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            return dateFormat.format(date);
        }catch (IllegalArgumentException e) {
            Log.e("DateUtil", e.getMessage());
        }
        return null;
    }

}
