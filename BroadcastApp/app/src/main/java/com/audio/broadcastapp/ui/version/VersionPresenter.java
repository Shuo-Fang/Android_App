package com.audio.broadcastapp.ui.version;

import com.audio.broadcastapp.base.BasePresenter;

public class VersionPresenter extends BasePresenter<VersionContract.View>
        implements VersionContract.Presenter {

    public VersionPresenter(VersionContract.View view) {
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
