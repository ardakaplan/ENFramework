package com.enerjisa.enframework.helpers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

import com.enerjisa.enframework.ui.screens.ENActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Arda Kaplan at 3.12.2020 - 17:04
 * <p>
 * ardakaplan101@gmail.com
 */
@Singleton
public class ENIntentHelpers {

    private final Context context;

    @Inject
    public ENIntentHelpers(Context context) {
        this.context = context;
    }

    public Intent getClearCacheIntent(Class<?> cls) {

        return getClearCacheIntent(context, cls);
    }

    public static Intent getClearCacheIntent(Context context, Class<?> cls) {

        Intent intent = new Intent(context, cls);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        return intent;
    }

    public static void openApplicationSettingsPage(ENActivity activity) {

        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + activity.getPackageName()));

        intent.addCategory(Intent.CATEGORY_DEFAULT);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        activity.startActivity(intent);
    }
}
