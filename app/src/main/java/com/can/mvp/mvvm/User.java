package com.can.mvp.mvvm;

import android.databinding.ObservableField;

/**
 * Created by wangjiafeng on 17-7-11.
 */

public class User {
    public final ObservableField<String> username = new ObservableField<>();
    public final ObservableField<String> password = new ObservableField<>();
}
