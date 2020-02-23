package com.audio.broadcastapp.ui.splash;

import android.content.Context;
import android.content.SharedPreferences;

import com.audio.broadcastapp.base.BasePresenter;

import java.util.Iterator;
import java.util.Map;

public class SplashPresenter extends BasePresenter<SplashContract.View> implements SplashContract.Presenter {

    public SplashPresenter(SplashContract.View view) {
        super(view);
        iView = getView();
    }

    // 读取数据
    @Override
    public Map<String, String> getMsg(String fileName) {
        Map<String, ?> map = null;
        // 读取数据用不到edit
        SharedPreferences preferences = iView.getCon().getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        //Context.MODE_APPEND可以对已存在的值进行修改
        map = preferences.getAll();
        if(null == map || map.isEmpty()) {
            return null;
        } else {
            Map<String, String> mapStr = null;
            Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                mapStr.put((String) entry.getKey(), (String) entry.getValue());
            }
            return mapStr;
        }
    }

    @Override
    public void  start() {

    }

    @Override
    public void onDestroy() {

    }

}
