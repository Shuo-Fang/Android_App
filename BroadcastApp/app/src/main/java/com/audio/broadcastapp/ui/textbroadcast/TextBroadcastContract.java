package com.audio.broadcastapp.ui.textbroadcast;

import com.audio.broadcastapp.base.BaseView;

public interface TextBroadcastContract {

    interface View extends BaseView {


    }

    interface Presenter {

        void playText(String str);

    }

}
