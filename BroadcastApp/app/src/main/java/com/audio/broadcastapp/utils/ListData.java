package com.audio.broadcastapp.utils;

import androidx.fragment.app.Fragment;

import com.audio.broadcastapp.fragment.BroadcastFragment;
import com.audio.broadcastapp.fragment.EmergencyBroadcastFragment;
import com.audio.broadcastapp.fragment.MainFragment;
import com.audio.broadcastapp.fragment.SettingFragment;

import java.util.ArrayList;
import java.util.List;

public class ListData {

    public static List<Fragment> getFragmentList() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList .add(new MainFragment());
        fragmentList .add(new BroadcastFragment());
        fragmentList .add(new EmergencyBroadcastFragment());
        fragmentList .add(new SettingFragment());
        return fragmentList;
    }

    public static String[] titleArray() {
        String[] strings = new String[]{"主界面","广播","紧急广播","设置"};
        return strings;
    }

}
