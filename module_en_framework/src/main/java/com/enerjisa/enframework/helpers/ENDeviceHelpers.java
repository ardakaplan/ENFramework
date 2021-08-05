package com.enerjisa.enframework.helpers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class ENDeviceHelpers {

    private final Context context;

    @Inject
    ENDeviceHelpers(Context context) {

        this.context = context;
    }

    public static void closeKeyboard(Activity activity) {

        if (activity != null) {

            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);

            if (inputMethodManager != null) {

                inputMethodManager.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
            }
        }
    }

    public static void closeKeyboard(Activity activity, EditText editText) {

        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);

        if (inputMethodManager != null) {

            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

    public boolean isAppInstalled(String packageName) {

        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);

        return intent != null;
    }
}
