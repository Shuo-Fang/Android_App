package com.audio.broadcastapp.ui.audiobroadcast;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.audio.broadcastapp.R;
import com.audio.broadcastapp.base.BaseActivity;
import com.audio.broadcastapp.utils.TitleBuilder;

public class AudioBroadcastActivity extends BaseActivity<AudioBroadcastPresenter>
        implements AudioBroadcastContract.View{

    public static void startActivity(Context context) {
        Intent intent = new Intent(context,AudioBroadcastActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected AudioBroadcastPresenter loadPresenter() {
        return new AudioBroadcastPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.audiobroadcast;
    }

    @Override
    protected TitleBuilder initBuilerTitle() {
        TitleBuilder titleBuilder = new TitleBuilder(this);
        titleBuilder.setMiddleTitleBg("文本广播", R.color.white, R.color.title_blue);
        titleBuilder.setLeftText("返回");
        titleBuilder.setRightText("完成");
        titleBuilder.setRightRelativeLayoutListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        return titleBuilder;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void addListener() {

    }

    @Override
    protected void onDestroys() throws RuntimeException {

    }

}
