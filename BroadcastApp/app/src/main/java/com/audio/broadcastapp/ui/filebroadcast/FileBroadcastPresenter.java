package com.audio.broadcastapp.ui.filebroadcast;

import com.audio.broadcastapp.base.BasePresenter;

public class FileBroadcastPresenter extends BasePresenter<FileBroadcastContract.View>
        implements FileBroadcastContract.Presenter {

    public FileBroadcastPresenter(FileBroadcastContract.View view) {
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
