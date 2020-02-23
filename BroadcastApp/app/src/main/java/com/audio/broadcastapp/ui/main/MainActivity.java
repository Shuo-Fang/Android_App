package com.audio.broadcastapp.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.audio.broadcastapp.R;
import com.audio.broadcastapp.adapter.FragmentAdapter;
import com.audio.broadcastapp.base.BaseActivity;
import com.audio.broadcastapp.utils.ListData;
import com.audio.broadcastapp.utils.TabLayoutMediator;
import com.audio.broadcastapp.utils.TitleBuilder;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.activity_main_vp)
    ViewPager2 activity_main_vp;
    @BindView(R.id.activity_main_tab)
    TabLayout activity_main_tab;

    private List<Fragment> fragmentList = ListData.getFragmentList();
    private String[] titleArray = ListData.titleArray();

    public static void startActivity(Context context) {
        Intent intent = new Intent(context,MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected MainPresenter loadPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected TitleBuilder initBuilerTitle() {
        return null;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        immersionBar.transparentStatusBar().statusBarDarkFont(false).init();
        FragmentAdapter mAdapter = new FragmentAdapter(this, fragmentList);
        activity_main_vp.setAdapter(mAdapter);
        activity_main_vp.setOffscreenPageLimit(fragmentList.size());

        new TabLayoutMediator(activity_main_tab, activity_main_vp, true,new TabLayoutMediator.OnConfigureTabCallback() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                //这里需要根据position修改tab的样式和文字等
                tab.setText(titleArray[position]);
            }
        }).attach();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void addListener() {

    }

    @Override
    protected void onDestroys() throws RuntimeException {

    }

}
