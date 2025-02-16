package com.kodetr.transaksi.widgets;

import android.content.Context;
import android.graphics.Typeface;

import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatRadioButton;

/**
 * Created by rakawm on 3/15/17.
 */

public class WidgetsRadioButton extends AppCompatRadioButton {
    public static final String ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android";

    public WidgetsRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context, attrs);
    }

    public WidgetsRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context, attrs);
    }

    private void applyCustomFont(Context context, AttributeSet attrs) {
        int textStyle = attrs.getAttributeIntValue(ANDROID_SCHEMA, "textStyle", Typeface.NORMAL);

        Typeface customFont = selectTypeface(context, textStyle);
        setTypeface(customFont);
    }

    private Typeface selectTypeface(Context context, int textStyle) {
        /*
        * information about the TextView textStyle:
        * http://developer.android.com/reference/android/R.styleable.html#TextView_textStyle
        */
        switch (textStyle) {
            case Typeface.BOLD: // bold
                return FontCache.getTypeface("fonts/SourceSansPro-Bold.ttf", context);

            case Typeface.ITALIC: // italic
                return FontCache.getTypeface("fonts/SourceSansPro-Italic.ttf", context);

            case Typeface.BOLD_ITALIC: // bold italic
                return FontCache.getTypeface("fonts/SourceSansPro-BoldItalic.ttf", context);

            case Typeface.NORMAL: // regular
                return FontCache.getTypeface("fonts/SourceSansPro-Regular.ttf", context);
            default:
                return FontCache.getTypeface("fonts/SourceSansPro-Regular.ttf", context);
        }
    }
}
