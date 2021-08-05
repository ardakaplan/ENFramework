package com.enerjisa.enframework.ui.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;

import com.enerjisa.enframework.helpers.ENDeviceHelpers;
import com.enerjisa.enframework.helpers.ENStringHelpers;
import com.enerjisa.enframework.helpers.ENViewHelpers;
import com.enerjisa.enframework.ui.screens.ENActivity;
import com.enerjisa.enframework.ui.screens.contracts.UIController;

import butterknife.ButterKnife;

/**
 * Created by Arda Kaplan at 31-May-20 - 13:13
 * <p>
 * ardakaplan101@gmail.com
 */
public abstract class ENDialog extends Dialog implements UIController {

    public ENDialog(@NonNull Activity activity) {
        super(activity);

        init(activity);
    }

    public ENDialog(@NonNull Activity activity, @StyleRes int dialogStyle) {
        super(activity, dialogStyle);

        init(activity);
    }

    private void init(Activity activity) {

        setOwnerActivity(activity);

        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(getLayoutId());

        ButterKnife.bind(this, this);
    }

    @Override
    public void closeKeyboard() {

        ENDeviceHelpers.closeKeyboard(getOwnerActivity());
    }

    @Override
    public boolean isTextViewFilled(EditText editText) {
        return ENStringHelpers.isFilled(getPureTextFromTextView(editText));
    }

    @Override
    public boolean isTextViewEmpty(EditText editText) {
        return ENStringHelpers.isEmpty(getPureTextFromTextView(editText));
    }

    @Override
    public String getPureTextFromTextView(TextView textView) {
        return ENViewHelpers.getPureText(textView);
    }


    @Override
    public void showProgress(@Nullable String message) {

        ((ENActivity) getOwnerActivity()).showProgress(message);
    }

    @Override
    public void closeProgress() {

        ((ENActivity) getOwnerActivity()).closeProgress();
    }
}
