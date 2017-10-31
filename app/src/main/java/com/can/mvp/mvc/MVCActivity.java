package com.can.mvp.mvc;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.can.mvp.R;
import com.can.mvp.api.API;

/**
 * Created by wangjiafeng on 17-7-5.
 */

public class MVCActivity extends Activity {

    private EditText mUserName, mPassWord;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
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
                login(username, password);
            }
        });
    }

    private void login(String username, String password) {
        boolean isSuccess = API.login(username, password);
        if (isSuccess) {
            SharedPreferences.Editor editor = getSharedPreferences(getPackageName(),
                                                                   Context.MODE_PRIVATE).edit();
            editor.putString("username", username);
            editor.apply();
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        } else {
            mPassWord.setError("密码错误");
        }
    }

}
