package com.enerjisa.enframeworktest.ui.base;

import android.content.pm.PackageManager;

import androidx.core.content.ContextCompat;

import com.enerjisa.enframework.helpers.ENIntentHelpers;
import com.enerjisa.enframework.ui.dialogs.ENProgressDialog;
import com.enerjisa.enframework.ui.screens.ENActivity;
import com.enerjisa.enframeworktest.helpers.DialogHelpers;

import javax.inject.Inject;

/**
 * Created by Arda Kaplan at 8.07.2021 - 12:01
 * <p>
 * ardakaplan101@gmail.com
 */
public abstract class BaseActivity extends ENActivity {

    @Inject
    protected DialogHelpers dialogHelpers;

    protected boolean checkPermission(String permission) {

        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {

            ENIntentHelpers.openApplicationSettingsPage(this);

            return false;

        } else {

            return true;
        }
    }

    @Override
    public ENProgressDialog getProgressDialogInstance() {
        return new ENProgressDialog(this);
    }
}
