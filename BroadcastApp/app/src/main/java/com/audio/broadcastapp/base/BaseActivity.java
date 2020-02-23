package com.audio.broadcastapp.base;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.audio.broadcastapp.R;
import com.audio.broadcastapp.utils.StatusBarHeight;
import com.audio.broadcastapp.utils.TitleBuilder;
import com.gyf.barlibrary.ImmersionBar;
import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity
        implements View.OnClickListener{

    public ImmersionBar immersionBar;
    public P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 初始化布局
        setContentView(getLayoutId());
        mPresenter = loadPresenter();
        // 初始化ButterKnife
        ButterKnife.bind(this);
        // 初始化标题
        initBuilerTitle();
        // 初始化数据
        initDatas(savedInstanceState);
        // 设置监听事件
        addListener();

    }

    /**
     * 初始化布局
     * @return 布局文件
     */
    protected abstract int getLayoutId() throws RuntimeException;

    protected abstract P loadPresenter();

    /**
     * 初始化标题
     * @return TitleBuilder 实例
     */
    protected abstract TitleBuilder initBuilerTitle() throws RuntimeException;

    /**
     * 初始化数据
     * @param savedInstanceState bundle属性
     */
    protected abstract void initData(Bundle savedInstanceState) throws RuntimeException;

    public void initDatas(Bundle savedInstanceState){
        // 初始化沉浸式
        immersionBar = ImmersionBar.with(this);
        immersionBar.statusBarColor(R.color.title_blue).statusBarDarkFont(false).init();
        View view = findViewById(R.id.act_title_bor);
        if (null != view){
            view.setPadding(0, StatusBarHeight.getStatusBarHeight(),0,0);
        }
        initData(savedInstanceState);
    }
    /**
     *
     * 添加监听事件
     * @throws RuntimeException
     */
    protected abstract void addListener() throws RuntimeException;

    /**
     * activity销毁
     */
    protected abstract void onDestroys() throws RuntimeException;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != immersionBar){
            immersionBar.destroy();
        }
        onDestroys();
    }

    /**
     * presenter 空指针异常捕获
     *
     * @param reference presenter
     * @param <T>       泛型类
     * @return presenter
     */
    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        } else {
            return reference;
        }
    }

    protected void showToast (String toastStr) {
        Toast.makeText(this, toastStr, Toast.LENGTH_SHORT).show();
    }

}
