package com.enerjisa.enframeworktest.di;

import android.app.Application;

import com.enerjisa.enframework.di.ENBaseModule;
import com.enerjisa.enframeworktest.TestApplication;
import com.enerjisa.enframeworktest.di.binders.ActivityBinder;
import com.enerjisa.enframeworktest.di.binders.FragmenBinder;
import com.enerjisa.enframeworktest.di.binders.BroadcastReceiverBinder;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;


@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AndroidInjectionModule.class,
        AppModule.class,
        ENBaseModule.class,
        ActivityBinder.class,
        FragmenBinder.class,
        BroadcastReceiverBinder.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(TestApplication testApplication);
}

