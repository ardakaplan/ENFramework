package com.enerjisa.enframework.ui.screens.contracts;

import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

/**
 * Created by Arda Kaplan at 27.01.2021 - 12:24
 * <p>
 * ardakaplan101@gmail.com
 * <p>
 * ekranlara özgü metotları barındırak "şartname" burada olan tüm metotlar
 * <p>
 * activity - fragment - dialog sınıfları tarafından kullanılması gerekmektedir
 */
public interface UIController {

    void closeKeyboard();

    boolean isTextViewFilled(EditText editText);

    boolean isTextViewEmpty(EditText editText);

    String getPureTextFromTextView(TextView textView);

    /**
     * @return screen layout
     */
    @LayoutRes
    int getLayoutId();

    void showProgress(@Nullable String message);

    void closeProgress();


}
