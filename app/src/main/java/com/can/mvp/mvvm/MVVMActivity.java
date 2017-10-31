package com.can.mvp.mvvm;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.can.mvp.R;
import com.can.mvp.api.API;
import com.can.mvp.databinding.ActivityMvvmBinding;

/**
 * Created by wangjiafeng on 17-7-5.
 */

public class MVVMActivity extends Activity {

    private ActivityMvvmBinding binding;
    private User user = new User();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        binding.setUser(user);
        binding.setActivity(this);
        user.username.set("test");
        user.password.set("12345");
    }

    public void login(View view) {
        boolean isSuccess = API.login(user.username.get(), user.password.get());
        if (isSuccess) {
            SharedPreferences.Editor editor = getSharedPreferences(getPackageName(),
                                                                   Context.MODE_PRIVATE).edit();
            editor.putString("username", user.username.get());
            editor.apply();
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
        }
    }
}
