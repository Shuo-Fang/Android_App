package com.audio.broadcastapp.fragment;

import android.os.Bundle;
import android.view.View;

import com.audio.broadcastapp.R;
import com.audio.broadcastapp.base.BaseFragment;
import com.audio.broadcastapp.utils.TitleBuilder;

public class MainFragment extends BaseFragment {


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected TitleBuilder initTitle(View view) {
        return new TitleBuilder(getActivity(), view).setMiddleTitleBg("主界面", R.color.white, R.color.title_blue);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void onClickDoubleListener(View paramView) {

    }

    @Override
    protected void addListener() {

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

}