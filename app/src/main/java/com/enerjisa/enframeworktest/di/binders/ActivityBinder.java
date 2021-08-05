package com.enerjisa.enframeworktest.di.binders;

import com.enerjisa.enframeworktest.ui.screens.FileTestActivity;
import com.enerjisa.enframeworktest.ui.screens.MainActivity;
import com.enerjisa.enframeworktest.ui.screens.SharedTestActivity;
import com.enerjisa.enframeworktest.ui.screens.dialogs.DialogsActivity;
import com.enerjisa.enframeworktest.ui.screens.dialogs.customprogressdialog.CustomProgressDialogsActivity;
import com.enerjisa.enframeworktest.ui.screens.recyclerview.RecyclerViewMenuActivity;
import com.enerjisa.enframeworktest.ui.screens.recyclerview.normal.NormalRecyclerViewListActivity;
import com.enerjisa.enframeworktest.ui.screens.spinner.SpinnerActivity;
import com.enerjisa.enframeworktest.ui.screens.viewpager.ViewPagerActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@SuppressWarnings("unused")
@Module
public abstract class ActivityBinder {

//    @ContributesAndroidInjector(modules = {SplashModule.class})
//    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector
    abstract FileTestActivity bindFileTestActivity();

    @ContributesAndroidInjector
    abstract SharedTestActivity bindSharedTestActivity();

    @ContributesAndroidInjector
    abstract RecyclerViewMenuActivity bindRecyclerViewMenuActivity();

    @ContributesAndroidInjector
    abstract NormalRecyclerViewListActivity bindNormalRecyclerViewListActivity();

    @ContributesAndroidInjector
    abstract DialogsActivity bindDialogsActivity();

    @ContributesAndroidInjector
    abstract ViewPagerActivity bindViewPagerActivity();

    @ContributesAndroidInjector
    abstract CustomProgressDialogsActivity bindCustomProgressDialogsActivity();

    @ContributesAndroidInjector
    abstract SpinnerActivity bindSpinnerActivity();
}
