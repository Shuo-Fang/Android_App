package com.audio.broadcastapp.ui.login;

import android.content.Context;

import com.audio.broadcastapp.base.BaseView;

public interface LoginContract {

    interface  View extends BaseView {

        void loginSuccess(String username,String password);
        void loginFail(String username,String password);
        Context getCon();

    }

    interface Presenter {

        void login(String username, String password);
        boolean saveMsg(String fileName, String username, String password);
        boolean removeMsg(String fileName, String key);

    }
}
