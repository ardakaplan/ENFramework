package com.enerjisa.enframeworktest.di.binders;

import com.enerjisa.enframeworktest.ui.screens.viewpager.innerfragments.FragmentA;
import com.enerjisa.enframeworktest.ui.screens.viewpager.innerfragments.FragmentB;
import com.enerjisa.enframeworktest.ui.screens.viewpager.innerfragments.FragmentC;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@SuppressWarnings("unused")
@Module
public abstract class FragmenBinder {

    @ContributesAndroidInjector
    abstract FragmentA bindFragmentA();

    @ContributesAndroidInjector
    abstract FragmentB bindFragmentB();

    @ContributesAndroidInjector
    abstract FragmentC bindFragmentC();
}
