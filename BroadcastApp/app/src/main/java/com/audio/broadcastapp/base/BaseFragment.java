package com.audio.broadcastapp.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.audio.broadcastapp.R;
import com.audio.broadcastapp.utils.Constant;
import com.audio.broadcastapp.utils.StatusBarHeight;
import com.audio.broadcastapp.utils.TitleBuilder;
import com.gyf.barlibrary.ImmersionBar;

import java.util.Calendar;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    private Unbinder unbinder;
    private View view;
    protected ImmersionBar immersionBar;
    private long lastClickTime;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = initView(inflater, container, savedInstanceState);
        } else {
            container = (ViewGroup) view.getParent();
        }
        if (container != null) {
            container.removeView(view);
        }
        return view;

    }

    /**
     * 初始化布局
     */
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            View pView = inflater.inflate(getLayoutId(), container, false);
            unbinder = ButterKnife.bind(this, pView);
            initTitle(pView);
            initDatas(savedInstanceState, pView);
            addListener();
            return pView;
        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    /**
     * 加载布局
     * @return 布局文件
     */
    protected abstract int getLayoutId();

    /**
     * 初始化标题
     * @param view 布局View
     * @return Title 实例
     */
    protected abstract TitleBuilder initTitle(View view) throws RuntimeException;

    /**
     * 初始化数据
     *
     * @param savedInstanceState 初始化数据
     */
    protected abstract void initData(Bundle savedInstanceState) throws RuntimeException;

    /**
     * 处理点击事件
     * @param paramView 发生点击事件的组件
     */
    protected abstract void onClickDoubleListener(View paramView) throws RuntimeException;

    /**
     * 设置监听器
     */
    protected abstract void addListener() throws RuntimeException;


    @Override
    public void onClick(View v) {
        // 防止快速点击（1秒响应一次）
        long currentTime = Calendar.getInstance().getTimeInMillis();
        if (currentTime - lastClickTime > Constant.NO_CLICK) {
            lastClickTime = currentTime;
            onClickDoubleListener(v);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != immersionBar) {
            immersionBar.destroy();
        }
    }

    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        } else {
            return reference;
        }
    }

    /**
     * 初始化数据（沉浸式状态栏）
     *
     * @param savedInstanceState intent数据
     * @param pView              view视图
     */
    public void initDatas(Bundle savedInstanceState, View pView) {
        // 初始化沉浸式
        immersionBar = ImmersionBar.with(this);
        View view = pView.findViewById(R.id.act_title_bor);
        if (null != view) {
            view.setPadding(0, StatusBarHeight.getStatusBarHeight(), 0, 0);
        }
        initData(savedInstanceState);
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
    }

}
