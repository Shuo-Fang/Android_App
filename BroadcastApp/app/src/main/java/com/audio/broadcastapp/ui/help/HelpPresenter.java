package com.audio.broadcastapp.ui.help;

import com.audio.broadcastapp.base.BasePresenter;

public class HelpPresenter extends BasePresenter<HelpContract.View>
        implements HelpContract.Presenter {

    public HelpPresenter(HelpContract.View view) {
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

