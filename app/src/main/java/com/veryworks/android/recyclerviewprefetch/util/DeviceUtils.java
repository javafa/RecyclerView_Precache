package com.veryworks.android.recyclerviewprefetch.util;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by pc on 4/17/2017.
 */

public class DeviceUtils {
    public static int getScreenHeight(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        return displayMetrics.heightPixels;
    }
}
