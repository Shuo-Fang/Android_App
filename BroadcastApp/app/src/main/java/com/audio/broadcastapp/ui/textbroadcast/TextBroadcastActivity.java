package com.audio.broadcastapp.ui.textbroadcast;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.audio.broadcastapp.R;
import com.audio.broadcastapp.base.BaseActivity;
import com.audio.broadcastapp.utils.TitleBuilder;

import java.util.Locale;

import butterknife.BindView;

public class TextBroadcastActivity extends BaseActivity<TextBroadcastPresenter>
        implements TextBroadcastContract.View {

    @BindView(R.id.audio_text)
    EditText audio_text;
    @BindView(R.id.listen)
    Button listen;
    @BindView(R.id.send)
    Button send;
    @BindView(R.id.send_file)
    Button send_file;

    TextToSpeech mSpeech = null;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context,TextBroadcastActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected TextBroadcastPresenter loadPresenter() {
        return new TextBroadcastPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.textbroadcast;
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
        mSpeech = new TextToSpeech(TextBroadcastActivity.this,new TTSListener());
    }

    @Override
    protected void addListener() {
        listen.setOnClickListener(this);
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
                int result = mSpeech.setLanguage(Locale.CHINA);
                // TextToSpeech.LANG_MISSING_DATA：表示语言的数据丢失
                // TextToSpeech.LANG_NOT_SUPPORTED：不支持
                if (result == TextToSpeech.LANG_MISSING_DATA
                        || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    showToast("数据丢失或不支持");
                }

            }
            else{

            }
        }
    }

    @Override
    public void onClick(View v) {
        showToast("开始播放");
        mSpeech.setSpeechRate(0.5f);
        mSpeech.setPitch(1.0f);
        mSpeech.speak(audio_text.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    protected void onDestroys() throws RuntimeException {

    }
}
