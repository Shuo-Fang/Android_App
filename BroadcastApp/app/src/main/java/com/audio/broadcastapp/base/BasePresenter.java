package com.audio.broadcastapp.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends BaseView> {

    private Reference<V> mViewReference;
    protected V iView;

    public BasePresenter(V view) {
        attachView(view);
    }

    /**
     * 建立关联(弱引用）
     * @param view 界面
     */
    public void attachView(V view){
        mViewReference=new WeakReference<V>(view);
    }

    /**
     * 获取view
     * @return 持有界面
     */
    protected V getView(){
        if (isViewAttached()){
            return mViewReference.get();
        }
        return null;
    }

    /**
     * 判断view是否添加
     */
    public boolean isViewAttached(){
        return mViewReference != null && mViewReference.get()!=null;
    }

    /**
     * 取消关联
     */
    public void detachView(){
        if(mViewReference != null){
            mViewReference.clear();
            mViewReference = null;
        }
    }

    /**
     * 初始化数据
     */
    public abstract void  start();

    /**
     * 释放presenter资源
     */
    public abstract void onDestroy();
}
