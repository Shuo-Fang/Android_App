package com.audio.broadcastapp.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.audio.broadcastapp.R;
import com.audio.broadcastapp.base.BaseActivity;
import com.audio.broadcastapp.ui.main.MainActivity;
import com.audio.broadcastapp.utils.Constant;
import com.audio.broadcastapp.utils.TitleBuilder;

import java.util.HashMap;

import butterknife.BindView;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View{

    private HashMap<String, Object> map;

    @BindView(R.id.img_bg)
    ImageView img_bg;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.auto_login)
    CheckBox auto_login;
    @BindView(R.id.sign_in)
    Button signInBtn;


    public static void startActivity(Context context) {
        Intent intent = new Intent(context,LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected LoginPresenter loadPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected TitleBuilder initBuilerTitle() {
        return null;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        immersionBar.transparentStatusBar().statusBarDarkFont(false).init();
    }

    @Override
    protected void addListener() {
        auto_login.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton checkBox, boolean checked) {
                if(checked) {
                    mPresenter.saveMsg(Constant.LOGIN,username.getText().toString(),
                            password.getText().toString());
                } else {
                    mPresenter.removeMsg(Constant.LOGIN,username.getText().toString());
                }
            }
        });
        signInBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mPresenter.login(username.getText().toString(),password.getText().toString());
    }

    @Override
    protected void onDestroys() throws RuntimeException {

    }

    @Override
    public void loginSuccess(String username,String password) {
        showToast(username + "" + password);
        MainActivity.startActivity(LoginActivity.this);
        finish();
    }

    @Override
    public void loginFail(String username,String password) {
        showToast(username + "" + password);
        MainActivity.startActivity(LoginActivity.this);
        finish();
    }

    @Override
    public Context getCon() {
        return this;
    }
}
