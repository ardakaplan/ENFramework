package com.enerjisa.enframeworktest.ui.screens.viewpager.innerfragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.enerjisa.enframeworktest.R;
import com.enerjisa.enframeworktest.constants.PassingDataKeyConstants;

/**
 * Created by Arda Kaplan at 28.07.2021 - 16:47
 * <p>
 * ardakaplan101@gmail.com
 */
public class FragmentC extends ViewPagerBaseFragment {

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.view_pager_c_fragment;
    }

    public static FragmentC getInstance() {

        return new FragmentC();
    }

    @Override
    public String getViewPagerTitle() {
        return "SAYFA C";
    }
}
