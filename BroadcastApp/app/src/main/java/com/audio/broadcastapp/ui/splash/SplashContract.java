package com.audio.broadcastapp.ui.splash;

import android.content.Context;

import com.audio.broadcastapp.base.BaseView;

import java.util.Map;

public interface SplashContract {

    interface View extends BaseView {
        Context getCon();
    }

    interface Presenter {

        Map<String, String> getMsg(String fileName);

    }
}
