package com.enerjisa.enframeworktest;

import com.ardakaplan.rdalogger.RDALogFullData;
import com.enerjisa.enframework.ENApplication;
import com.enerjisa.enframeworktest.constants.SettingsForEnablesConstants;
import com.enerjisa.enframeworktest.di.AppComponent;
import com.enerjisa.enframeworktest.di.DaggerAppComponent;

/**
 * Created by Arda Kaplan at 8.07.2021 - 11:41
 * <p>
 * ardakaplan101@gmail.com
 */
public class TestApplication extends ENApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void initDagger() {//

        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();

        appComponent.inject(this);
    }

    @Override
    protected String getRDALoggerTag() {
        return getString(R.string.app_name);
    }

    @Override
    protected boolean doesRDALoggerWork() {
        return SettingsForEnablesConstants.ENABLE_LOGGING;
    }

    @Override
    public void onLogReceived(RDALogFullData RDALogFullData) {

        //RDALog ların hepsi buraya düşer, uygulama tarafında dosyaya burda yazılır
    }
}
