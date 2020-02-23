package com.audio.broadcastapp.ui.splash;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;

import com.audio.broadcastapp.R;
import com.audio.broadcastapp.base.BaseActivity;
import com.audio.broadcastapp.ui.login.LoginActivity;
import com.audio.broadcastapp.ui.main.MainActivity;
import com.audio.broadcastapp.utils.Constant;
import com.audio.broadcastapp.utils.TitleBuilder;

import butterknife.BindView;

public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.View{

    private static final int GO_HOME = 0;//去主页
    private static final int GO_LOGIN = 1;//去登录页

    @BindView(R.id.activity_splash_img)
    ImageView activitySplashImg;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_HOME://去主页
                    MainActivity.startActivity(SplashActivity.this);
                    finish();
                    break;
                case GO_LOGIN://去登录页
                    LoginActivity.startActivity(SplashActivity.this);
                    finish();
                    break;
            }
        }
    };

    @Override
    protected SplashPresenter loadPresenter() {
        return new SplashPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected TitleBuilder initBuilerTitle() {
        return null;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        immersionBar.transparentStatusBar().statusBarDarkFont(false).init();
        if (this.getSharedPreferences(Constant.LOGIN,
                Context.MODE_PRIVATE).getAll() != null && !(this.getSharedPreferences(Constant.LOGIN,
                Context.MODE_PRIVATE).getAll().isEmpty()))//自动登录判断，SharePrefences中有数据，则跳转到主页，没数据则跳转到登录页
        {
            showToast(this.getSharedPreferences(Constant.LOGIN,
                    Context.MODE_PRIVATE).getAll().toString());
            mHandler.sendEmptyMessageDelayed(GO_HOME, 2000);
        } else {
            mHandler.sendEmptyMessageAtTime(GO_LOGIN, 2000);
        }
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public Context getCon() {
        return this;
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected void onDestroys() throws RuntimeException {

    }
}
