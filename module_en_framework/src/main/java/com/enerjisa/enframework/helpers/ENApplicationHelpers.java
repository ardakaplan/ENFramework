package com.enerjisa.enframework.helpers;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Base64;

import com.ardakaplan.rdalogger.RDALogger;

import java.security.MessageDigest;
import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * cihazda yüklü uygulamalar hakkında bilgileri dönecek olan yardımcı sınıf
 * Created by ardakaplan on 12/10/15.
 */
@Singleton
public class ENApplicationHelpers {

    private final Context context;

    @Inject
    ENApplicationHelpers(Context context) {
        this.context = context;
    }


    public boolean isApplicationInstalled(String packageName) {

        boolean found = true;

        try {

            context.getPackageManager().getPackageInfo(packageName, 0);

        } catch (PackageManager.NameNotFoundException e) {

            found = false;
        }

        return found;
    }

    public void writeHashKey() {

        try {
            //PackageManager.GET_SIGNATURES gives error, use PackageManager.GET_SIGNING_CERTIFICATES
            PackageInfo packageInfo = context.getPackageManager().
                    getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNING_CERTIFICATES);

            for (Signature signature : packageInfo.signatures) {

                MessageDigest messageDigest = MessageDigest.getInstance("SHA");

                messageDigest.update(signature.toByteArray());

                RDALogger.info("Key Hash : " + Base64.encodeToString(messageDigest.digest(), Base64.DEFAULT));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void changeLanguage(String localeShortName) {

        Locale locale = new Locale(localeShortName);

        Locale.setDefault(locale);

        Resources resources = context.getResources();

        Configuration configuration = new Configuration(resources.getConfiguration());

        configuration.locale = locale;

        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}
