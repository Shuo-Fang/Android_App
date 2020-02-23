package com.audio.broadcastapp.ui.audiobroadcast;

import com.audio.broadcastapp.base.BasePresenter;

public class AudioBroadcastPresenter extends BasePresenter<AudioBroadcastContract.View>
        implements AudioBroadcastContract.Presenter {

    public AudioBroadcastPresenter(AudioBroadcastContract.View view) {
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
