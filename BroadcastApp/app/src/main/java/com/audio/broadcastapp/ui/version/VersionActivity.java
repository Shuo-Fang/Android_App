package com.audio.broadcastapp.ui.version;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.audio.broadcastapp.R;
import com.audio.broadcastapp.base.BaseActivity;
import com.audio.broadcastapp.utils.TitleBuilder;

public class VersionActivity extends BaseActivity<VersionPresenter>
        implements VersionContract.View {

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, VersionActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected VersionPresenter loadPresenter() {
        return new VersionPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.version;
    }

    @Override
    protected TitleBuilder initBuilerTitle() {
        TitleBuilder titleBuilder = new TitleBuilder(this);
        titleBuilder.setMiddleTitleBg("文本广播", R.color.white, R.color.title_blue);
        titleBuilder.setLeftText("返回");
        titleBuilder.setLeftRelativeLayoutListener(this);
        return titleBuilder;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {
        finish();
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected void onDestroys() throws RuntimeException {

    }
}
