package com.enerjisa.enframework.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import dagger.android.AndroidInjection;

/**
 * Created by Arda Kaplan at 25.03.2021 - 15:16
 * <p>
 * ardakaplan101@gmail.com
 */
public abstract class ENBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        AndroidInjection.inject(this, context);
    }
}