package com.example.tsnt.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import com.example.tsnt.TsntApplication;

/**
 * @Author: tingshuonitiao
 * @Date: 2016/9/5 09:48
 * @Description: UI单位转化的工具类
 */

public class DisplayUtil {
    // dp转px
    public static int dp2px(Context context, float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }

    public static int dp2px(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                TsntApplication.getTsntContext().getResources().getDisplayMetrics());
    }

    // sp转px
    public static int sp2px(Context context, float sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp,
                context.getResources().getDisplayMetrics());
    }

    // px转dp
    public static int px2dp(Context context, float px) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int dp = Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return dp;
    }
}
