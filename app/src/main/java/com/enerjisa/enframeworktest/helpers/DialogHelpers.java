package com.enerjisa.enframeworktest.helpers;

import com.enerjisa.enframework.helpers.ENToastHelpers;
import com.enerjisa.enframework.ui.screens.ENActivity;
import com.enerjisa.enframeworktest.ui.dialogs.CustomDialog;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Arda Kaplan at 28.07.2021 - 13:40
 * <p>
 * ardakaplan101@gmail.com
 * <p>
 * injection edilen sınıfların dialoglar içerisinden kullanılması kodsal olarak uzun olduğu için tüm
 * custom dialoglar tarafından kullanılması için böyle bir helper sınıfı yazıldı
 * <p>
 * Dialog kullanılmak istenildiği zaman bu sınıf "inject" edilerek ilgili method çağırılır.
 * <p>
 * Bu sınıfı da base sınıfta inject etmekte fayda var böylece alt sınıflarda tekrar tekrar yazma derdinden kurtulmuş oluruz
 */
@Singleton
public class DialogHelpers {

    private final ENToastHelpers toastHelpers;

    @Inject
    DialogHelpers(ENToastHelpers toastHelpers) {
        this.toastHelpers = toastHelpers;
    }

    public void showVehicleCardPlateNoDialog(ENActivity activity, CustomDialog.Listener listener) {

        new CustomDialog(activity, toastHelpers, listener).show();
    }


}
