package com.audio.broadcastapp.ui.main;

import com.audio.broadcastapp.base.BasePresenter;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    public MainPresenter(MainContract.View view) {
        super(view);
        iView = getView();
    }

    @Override
    public void  start() {

    }

    @Override
    public void onDestroy() {

    }

}
