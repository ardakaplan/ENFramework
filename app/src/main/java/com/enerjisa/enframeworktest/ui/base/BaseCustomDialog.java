package com.enerjisa.enframeworktest.ui.base;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.enerjisa.enframework.ui.dialogs.ENDialog;

/**
 * Created by Arda Kaplan at 22.12.2020 - 14:28
 * <p>
 * ardakaplan101@gmail.com
 */
public abstract class BaseCustomDialog extends ENDialog {

    public BaseCustomDialog(@NonNull Activity activity) {
        super(activity);
    }

    public BaseCustomDialog(@NonNull Activity activity, int dialogStyle) {
        super(activity, dialogStyle);
    }
}
