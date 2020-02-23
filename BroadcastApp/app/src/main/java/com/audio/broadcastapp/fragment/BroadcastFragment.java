package com.audio.broadcastapp.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.audio.broadcastapp.R;
import com.audio.broadcastapp.base.BaseFragment;
import com.audio.broadcastapp.ui.audiobroadcast.AudioBroadcastActivity;
import com.audio.broadcastapp.ui.filebroadcast.FileBroadcastActivity;
import com.audio.broadcastapp.ui.textbroadcast.TextBroadcastActivity;
import com.audio.broadcastapp.utils.TitleBuilder;

import butterknife.BindView;


public class BroadcastFragment extends BaseFragment {

    @BindView(R.id.file_broadcast)
    TextView file_broadcast;
    @BindView(R.id.audio_broadcast)
    TextView audio_broadcast;
    @BindView(R.id.text_broadcast)
    TextView text_broadcast;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_broadcast;
    }

    @Override
    protected TitleBuilder initTitle(View view) {
        return new TitleBuilder(getActivity(), view).setMiddleTitleBg("广播", R.color.white, R.color.title_blue);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void onClickDoubleListener(View paramView) {
        switch (paramView.getId()) {
            case R.id.file_broadcast:
                FileBroadcastActivity.startActivity(getActivity());
                break;
            case R.id.audio_broadcast:
                AudioBroadcastActivity.startActivity(getActivity());
                break;
            case R.id.text_broadcast:
                TextBroadcastActivity.startActivity(getActivity());
                break;
        }
    }

    @Override
    protected void addListener() {
        file_broadcast.setOnClickListener(this);
        audio_broadcast.setOnClickListener(this);
        text_broadcast.setOnClickListener(this);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

}
