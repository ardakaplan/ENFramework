package com.enerjisa.enframeworktest.di.binders;

import com.enerjisa.enframeworktest.receivers.BootCompletedReceiver;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BroadcastReceiverBinder {

    @ContributesAndroidInjector
    abstract BootCompletedReceiver bindBootCompletedReceiver();
}
