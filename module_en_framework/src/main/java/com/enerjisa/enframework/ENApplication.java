package com.enerjisa.enframework;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;

import androidx.fragment.app.Fragment;

import com.ardakaplan.rdalogger.RDALoggerConfig;
import com.enerjisa.enframework.di.CustomDispatchingAndroidInjector;
import com.enerjisa.enframework.di.HasCustomActivityInjector;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasBroadcastReceiverInjector;
import dagger.android.HasServiceInjector;
import dagger.android.support.HasSupportFragmentInjector;


/**
 * Created by Arda Kaplan at 8.07.2021 - 11:42
 * <p>
 * ardakaplan101@gmail.com
 */
public abstract class ENApplication extends Application implements HasCustomActivityInjector, HasSupportFragmentInjector, HasBroadcastReceiverInjector, HasServiceInjector, RDALoggerConfig.RDALogListener {

    @Inject
    CustomDispatchingAndroidInjector<Activity> activityInjector;
    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentInjector;
    @Inject
    DispatchingAndroidInjector<BroadcastReceiver> broadcastReceiverInjector;
    @Inject
    DispatchingAndroidInjector<Service> serviceDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        initDagger();

        RDALoggerConfig.setup(getRDALoggerTag()).enableLogging(doesRDALoggerWork()).setListener(this);
    }

    protected abstract void initDagger();

    @Override
    public CustomDispatchingAndroidInjector<Activity> activityInjector() {

        return activityInjector;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {

        return mFragmentInjector;
    }

    @Override
    public AndroidInjector<BroadcastReceiver> broadcastReceiverInjector() {

        return broadcastReceiverInjector;
    }

    @Override
    public AndroidInjector<Service> serviceInjector() {

        return serviceDispatchingAndroidInjector;
    }

    protected abstract String getRDALoggerTag();

    protected abstract boolean doesRDALoggerWork();
}
