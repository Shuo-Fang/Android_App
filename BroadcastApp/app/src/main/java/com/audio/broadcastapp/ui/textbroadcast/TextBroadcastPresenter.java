package com.audio.broadcastapp.ui.textbroadcast;

import android.speech.tts.TextToSpeech;

import com.audio.broadcastapp.base.BasePresenter;

public class TextBroadcastPresenter extends BasePresenter<TextBroadcastContract.View>
        implements TextBroadcastContract.Presenter {

    private TextToSpeech mSpeech = null;

    public TextBroadcastPresenter(TextBroadcastContract.View view) {
        super(view);
        iView = getView();
    }

    @Override
    public void playText(String str) {

    }

    private class TTSListener implements TextToSpeech.OnInitListener {
        @Override
        public void onInit(int status) {
            // TODO Auto-generated method stub
            if (status == TextToSpeech.SUCCESS) {
//                int supported = mSpeech.setLanguage(Locale.US);
//                if ((supported != TextToSpeech.LANG_AVAILABLE) && (supported != TextToSpeech.LANG_COUNTRY_AVAILABLE)) {
//                    Toast.makeText(MainActivity.this, "不支持当前语言！", Toast.LENGTH_SHORT).show();
//                    Log.i(TAG, "onInit: 支持当前选择语言");
//                }else{
//
//                }

            }
            else{

            }
        }
    }


    @Override
    public void  start() {

    }

    @Override
    public void onDestroy() {

    }
}
