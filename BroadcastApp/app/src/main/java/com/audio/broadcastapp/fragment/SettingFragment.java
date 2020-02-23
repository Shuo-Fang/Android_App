package com.audio.broadcastapp.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.audio.broadcastapp.R;
import com.audio.broadcastapp.base.BaseFragment;
import com.audio.broadcastapp.ui.help.HelpActivity;
import com.audio.broadcastapp.ui.login.LoginActivity;
import com.audio.broadcastapp.ui.version.VersionActivity;
import com.audio.broadcastapp.utils.Constant;
import com.audio.broadcastapp.utils.TitleBuilder;

import butterknife.BindView;

public class SettingFragment extends BaseFragment {

    @BindView(R.id.version)
    TextView version;
    @BindView(R.id.help)
    TextView help;
    @BindView(R.id.change_user)
    TextView change_user;
    @BindView(R.id.sign_out)
    TextView sign_out;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_setting;
    }

    @Override
    protected TitleBuilder initTitle(View view) {
        return new TitleBuilder(getActivity(), view).setMiddleTitleBg("设置", R.color.white, R.color.title_blue);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void onClickDoubleListener(View paramView) {
        Activity activity = getActivity();
        switch (paramView.getId()) {
            case R.id.version:
                VersionActivity.startActivity(activity);
                break;
            case R.id.help:
                HelpActivity.startActivity(activity);
                break;
            case R.id.change_user:
                LoginActivity.startActivity(activity);
                activity.getSharedPreferences(Constant.LOGIN,
                        Context.MODE_PRIVATE).edit().clear().commit();
                activity.finish();
                break;
            case R.id.sign_out:
                activity.finish();
                break;
        }
    }

    @Override
    protected void addListener() {
        version.setOnClickListener(this);
        help.setOnClickListener(this);
        change_user.setOnClickListener(this);
        sign_out.setOnClickListener(this);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

}