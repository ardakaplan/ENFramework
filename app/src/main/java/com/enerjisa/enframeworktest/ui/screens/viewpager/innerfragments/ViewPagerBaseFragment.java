package com.enerjisa.enframeworktest.ui.screens.viewpager.innerfragments;

import com.enerjisa.enframeworktest.ui.base.BaseFragment;
import com.enerjisa.enframeworktest.ui.screens.viewpager.ViewPagerActivity;

/**
 * Created by Arda Kaplan at 28.07.2021 - 16:54
 * <p>
 * ardakaplan101@gmail.com
 * <p>
 * viewpager içerisindeki fragment lerin ortak atası. Böylece ortak metotları bir yerde tutabilir.
 */
public abstract class ViewPagerBaseFragment extends BaseFragment {

    @Override
    public ViewPagerActivity getContainerActivity() {
        return ((ViewPagerActivity) super.getContainerActivity());
    }
}
