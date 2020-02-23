package com.audio.broadcastapp.ui.login;

import android.content.Context;
import android.content.SharedPreferences;

import com.audio.broadcastapp.base.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginContract.View> implements
        LoginContract.Presenter {

    public LoginPresenter(LoginContract.View view) {
        super(view);
        iView = getView();
    }

    @Override
    public void login(String username, String password) {
        if(iView != null)
            iView.loginSuccess(username, password);
        else
            iView.loginFail(username, password);
    }

    //将数据存储进入共享参数
    @Override
    public boolean saveMsg(String fileName, String username, String password) {
        boolean flag = false;
        // 一般Mode都使用private,比较安全
        SharedPreferences preferences = iView.getCon().getSharedPreferences(fileName,
                Context.MODE_PRIVATE);

        flag = preferences.edit().putString(username,password).commit();

        return flag;
    }

    //将数据存储进入共享参数
    @Override
    public boolean removeMsg(String fileName, String key) {

        boolean flag = false;

        SharedPreferences preferences = iView.getCon().getSharedPreferences(fileName,
                Context.MODE_PRIVATE);

        flag  = preferences.edit().remove(key).commit();

        return flag;
    }

    @Override
    public void  start() {

    }

    @Override
    public void onDestroy() {

    }

}
