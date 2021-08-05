package com.enerjisa.enframeworktest.ui.dialogs;

import android.app.Activity;

import com.enerjisa.enframework.ui.dialogs.ENProgressDialog;
import com.enerjisa.enframeworktest.R;

/**
 * Created by Arda Kaplan at 28.07.2021 - 11:49
 * <p>
 * ardakaplan101@gmail.com
 */
public class CustomProgressDialog extends ENProgressDialog {

    public CustomProgressDialog(Activity activity) {
        super(activity);
    }

    @Override
    public int getLayoutId() {
        return R.layout.dialog_custom_progress;
    }

    @Override
    protected int getMessageTextViewId() {
        return R.id.customProgressDialog_textView_message;
    }
}
