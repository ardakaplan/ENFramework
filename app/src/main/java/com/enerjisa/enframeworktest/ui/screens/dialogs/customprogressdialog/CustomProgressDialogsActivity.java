package com.enerjisa.enframeworktest.ui.screens.dialogs.customprogressdialog;

import android.content.Intent;

import com.enerjisa.enframeworktest.R;
import com.enerjisa.enframeworktest.ui.base.BaseActivity;
import com.enerjisa.enframeworktest.ui.dialogs.CustomProgressDialog;

import butterknife.OnClick;

/**
 * Created by Arda Kaplan at 28.07.2021 - 11:01
 * <p>
 * ardakaplan101@gmail.com
 * <p>
 * custom progress dialog kullanımı gösteren örnek activity
 * <p>
 * genelde uygulama bazında tek bir progress dialog kullanılır
 * ancak bu test kütüphanesi olduğu için genel progress{@link com.enerjisa.enframework.ui.dialogs.ENProgressDialog}
 * olarak kullanıldı.
 * <p>
 * Uygulamalara entegre edilirken {@link #getProgressDialogInstance()} metodu base sınıfa implement edilerek kullanılabilir, böylece tüm uygulama boyunca geçerli olur.
 * <p>
 * Ya da farklı ekranlarda farklı progresler çıksın istiyorsanız, ilgili activity lerde bu işlemi farklı instance larla yapmanız gerekmektedir.
 */
public class CustomProgressDialogsActivity extends BaseActivity {

    @OnClick(R.id.customProgressDialogsActivity_button_showProgressDialog)
    void clickedShowProgressDialog() {

        showProgress("CUSTOM PROGRESS DIALOG\n\nDEBUG MODDA geri tuşuna basarak progress i kapatabilirsin");
    }

    public static void open(BaseActivity activity) {

        activity.startActivity(new Intent(activity, CustomProgressDialogsActivity.class));
    }

    /**
     * @return hangi progresi kullanmak istiyorsak override edilmiş metotta onu dönüyoruz.
     */
    @Override
    public CustomProgressDialog getProgressDialogInstance() {
        return new CustomProgressDialog(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.custom_progress_dialog_activity;
    }
}
