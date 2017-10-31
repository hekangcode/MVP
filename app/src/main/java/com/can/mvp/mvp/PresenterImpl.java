package com.can.mvp.mvp;

import android.content.Context;
import android.content.SharedPreferences;

import com.can.mvp.api.API;

/**
 * Created by wangjiafeng on 17-7-10.
 */

public class PresenterImpl implements IContract.IPresenter {

    private IContract.IView mIView;

    PresenterImpl(IContract.IView mIView) {
        this.mIView = mIView;
    }

    @Override
    public void login(String username, String password) {
        boolean isSuccess = API.login(username, password);
        if (isSuccess) {
            SharedPreferences.Editor editor = mIView.getContext().getSharedPreferences
                (mIView.getContext().getPackageName(),
                 Context.MODE_PRIVATE).edit();
            editor.putString("username", username);
            editor.apply();
        }
        mIView.updateLoginResult(isSuccess);
    }
}
