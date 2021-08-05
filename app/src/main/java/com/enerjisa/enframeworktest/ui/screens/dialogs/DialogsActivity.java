package com.enerjisa.enframeworktest.ui.screens.dialogs;

import android.content.Intent;

import com.ardakaplan.rdalogger.RDALogger;
import com.enerjisa.enframeworktest.R;
import com.enerjisa.enframeworktest.ui.base.BaseActivity;
import com.enerjisa.enframeworktest.ui.dialogs.CustomDialog;
import com.enerjisa.enframeworktest.ui.screens.dialogs.customprogressdialog.CustomProgressDialogsActivity;

import butterknife.OnClick;

/**
 * Created by Arda Kaplan at 28.07.2021 - 11:01
 * <p>
 * ardakaplan101@gmail.com
 */
public class DialogsActivity extends BaseActivity {


    @OnClick(R.id.dialogsActivity_button_showProgressDialog)
    void clickedShowProgressDialog() {

        showProgress("DEBUG MODDA geri tuşuna basarak progress i kapatabilirsin");
    }

    @OnClick(R.id.dialogsActivity_button_showCustomProgressDialog)
    void clickedCustomProgressDialog() {

        CustomProgressDialogsActivity.open(this);
    }

    @OnClick(R.id.dialogsActivity_button_showCustomDialog)
    void clickedShowCustomDialog() {

        dialogHelpers.showVehicleCardPlateNoDialog(this, new CustomDialog.Listener() {

            @Override
            public void onClickedOk(CustomDialog customDialog, String value) {

                customDialog.dismiss();

                RDALogger.info("CLICKED OK BUTTON AND VALUE IS ->" + value);
            }

            @Override
            public void onClickedCancel(CustomDialog customDialog) {

                customDialog.dismiss();

                RDALogger.info("CLICKED CANCEL BUTTON");
            }
        });

    }

    public static void open(BaseActivity activity) {

        activity.startActivity(new Intent(activity, DialogsActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.dialogs_activity;
    }
}
