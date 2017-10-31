package com.can.mvp.mvp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.can.mvp.R;

/**
 * Created by wangjiafeng on 17-7-5.
 */

public class MVPActivity extends Activity implements IContract.IView {

    private EditText mUserName, mPassWord;
    private IContract.IPresenter mIPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        mIPresenter = new PresenterImpl(this);
        initView();
    }

    private void initView() {
        mUserName = (EditText) findViewById(R.id.et_username);
        mPassWord = (EditText) findViewById(R.id.et_password);
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUserName.getText().toString();
                String password = mPassWord.getText().toString();
                mIPresenter.login(username, password);
            }
        });
    }

    @Override
    public void updateLoginResult(boolean isSuccess) {
        if (isSuccess) {
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        } else {
            mPassWord.setError("密码错误");
        }
    }

    @Override
    public Context getContext() {
        return this;
    }
}
