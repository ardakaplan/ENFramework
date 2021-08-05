package com.enerjisa.enframeworktest.ui.dialogs;

import android.app.Activity;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.enerjisa.enframework.helpers.ENToastHelpers;
import com.enerjisa.enframeworktest.R;
import com.enerjisa.enframeworktest.ui.base.BaseCustomDialog;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Arda Kaplan at 28.07.2021 - 13:29
 * <p>
 * ardakaplan101@gmail.com
 */
public class CustomDialog extends BaseCustomDialog {

    @BindView(R.id.customDialog_editText_input)
    EditText inputEditText;

    private final ENToastHelpers enToastHelpers;
    private final Listener listener;

    public CustomDialog(@NonNull Activity activity, ENToastHelpers enToastHelpers, Listener listener) {
        super(activity);
        //veya boyut vermek istiyorsak
//        super(activity, R.style.Theme_Dialog_min_max_width_90);

        this.enToastHelpers = enToastHelpers;
        this.listener = listener;
    }

    @OnClick(R.id.customDialog_button_ok)
    void clickedOK() {

        if (isTextViewFilled(inputEditText)) {

            listener.onClickedOk(this, getPureTextFromTextView(inputEditText));

        } else {

            enToastHelpers.errorShort("input alanına değer girilmeli");
        }
    }

    @OnClick(R.id.customDialog_button_cancel)
    void clickedCancel() {

        listener.onClickedCancel(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.dialog_custom_dialog;
    }

    public interface Listener {

        void onClickedOk(CustomDialog customDialog, String value);

        void onClickedCancel(CustomDialog customDialog);
    }
}
