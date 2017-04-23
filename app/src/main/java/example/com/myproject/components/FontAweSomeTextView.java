package example.com.myproject.components;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class FontAweSomeTextView extends TextView {

    public FontAweSomeTextView(Context context) {
        super(context);
        if (isInEditMode()) return;
        parseAttributes(null);
    }
    public FontAweSomeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (isInEditMode()) return;
        parseAttributes(attrs);
    }
    public FontAweSomeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (isInEditMode()) return;
        parseAttributes(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FontAweSomeTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void parseAttributes(AttributeSet attrs) {
        Typeface typeface = Typeface.createFromAsset(this.getContext().getAssets(), "fonts/fontawesome-webfont.ttf");
        setTypeface(typeface);
    }
}
