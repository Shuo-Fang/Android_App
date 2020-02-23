package com.audio.broadcastapp.ui.help;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.audio.broadcastapp.R;
import com.audio.broadcastapp.base.BaseActivity;
import com.audio.broadcastapp.utils.TitleBuilder;

public class HelpActivity extends BaseActivity<HelpPresenter>
        implements HelpContract.View {

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, HelpActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected HelpPresenter loadPresenter() {
        return new HelpPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.help;
    }

    @Override
    protected TitleBuilder initBuilerTitle() {
        TitleBuilder titleBuilder = new TitleBuilder(this);
        titleBuilder.setMiddleTitleBg("帮助", R.color.white, R.color.title_blue);
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
