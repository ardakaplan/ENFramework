package com.enerjisa.enframework.ui.screens;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.enerjisa.enframework.helpers.ENDeviceHelpers;
import com.enerjisa.enframework.helpers.ENStringHelpers;
import com.enerjisa.enframework.helpers.ENViewHelpers;
import com.enerjisa.enframework.ui.dialogs.ENProgressDialog;
import com.enerjisa.enframework.ui.screens.contracts.ActivityController;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by Arda Kaplan at 8.07.2021 - 11:27
 * <p>
 * ardakaplan101@gmail.com
 */
public abstract class ENActivity extends DaggerAppCompatActivity implements ActivityController {

    private ENProgressDialog enProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());

        ButterKnife.bind(this);

        enProgressDialog = getProgressDialogInstance();
    }

    @Override
    public void closeKeyboard() {

        ENDeviceHelpers.closeKeyboard(this);
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

        if (!isFinishing()) {

            runOnUiThread(new Runnable() {

                @Override
                public void run() {

                    if (enProgressDialog != null && !enProgressDialog.isShowing()) {

                        if (ENStringHelpers.isFilled(message)) {

                            enProgressDialog.setMessage(message);
                        }

                        enProgressDialog.show();
                    }
                }
            });
        }
    }

    /**
     * uygulamada kullanılacak olan progressler  {@link ENProgressDialog} den türemek zorundadır.
     * <p>
     * Activity lerde hangi progress dialog kullanılacaksa onun instance ı bu metot vasıtasıyla base sınıfa belirtilir.
     * <p>
     * Eğer uygulama bazlı başka bir progress kullanılacak kullanılan bu dialog yine{@link ENProgressDialog} sınıfından extend olup,
     * ilgili uygulamanın baseactivity sinde veya sınıfın instance olarak verilmelidir
     *
     * @return kullanılacak olan progress dialog instance döner
     */
    protected ENProgressDialog getProgressDialogInstance() {

        return new ENProgressDialog(this);
    }

    @Override
    public void closeProgress() {

        runOnUiThread(() -> {

            if (enProgressDialog != null && enProgressDialog.isShowing()) {

                enProgressDialog.dismiss();
            }
        });
    }
}
