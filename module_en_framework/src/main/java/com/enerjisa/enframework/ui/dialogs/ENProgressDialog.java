package com.enerjisa.enframework.ui.dialogs;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.enerjisa.enframework.BuildConfig;
import com.enerjisa.enframework.R;
import com.enerjisa.enframework.helpers.ENStringHelpers;

public class ENProgressDialog extends ENDialog {

    public ENProgressDialog(@NonNull Activity activity) {

        super(activity);

        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        if (!BuildConfig.DEBUG) {

            setCancelable(false);
        }

        setCanceledOnTouchOutside(false);
    }

    @Override
    public int getLayoutId() {
        return R.layout.framework_progress_dialog;
    }

    public void setMessage(@Nullable String message) {

        if (ENStringHelpers.isFilled(message)) {

            ((TextView) findViewById(getMessageTextViewId())).setText(message);
        }
    }

    protected @IdRes
    int getMessageTextViewId() {
        return R.id.dialogProgress_textView_message;
    }
}
