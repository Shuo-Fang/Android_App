package com.audio.broadcastapp.utils;

import android.content.res.Resources;

public class StatusBarHeight {

    /**
     * 获取状态栏高度
     * @return 状态栏高度
     */
    public static int getStatusBarHeight() {
        Resources resources = Resources.getSystem();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        return resources.getDimensionPixelSize(resourceId);
    }

}
