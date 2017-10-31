package com.can.mvp.mvp;

import android.content.Context;

/**
 * Created by wangjiafeng on 17-7-10.
 */

public interface IContract {

    interface IView {

        void updateLoginResult(boolean isSuccess);

        Context getContext();
    }

    interface IPresenter {

        void login(String username, String password);
    }

}
