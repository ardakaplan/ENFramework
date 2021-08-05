package com.enerjisa.enframeworktest.ui.screens.viewpager.innerfragments;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.enerjisa.enframeworktest.R;
import com.enerjisa.enframeworktest.constants.PassingDataKeyConstants;

import butterknife.BindView;

/**
 * Created by Arda Kaplan at 28.07.2021 - 16:47
 * <p>
 * ardakaplan101@gmail.com
 */
public class FragmentA extends ViewPagerBaseFragment {

    @BindView(R.id.viewPagerAFragment_textView_testValue)
    TextView testValueTextView;

    private String testValue = "initial Value";

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        showData();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

            testValue = getArguments().getString(PassingDataKeyConstants.TEST_VALUE, "default Value");
        }
    }

    private void showData() {

        testValueTextView.setText(testValue);
    }

    @Override
    public int getLayoutId() {
        return R.layout.view_pager_a_fragment;
    }

    public static FragmentA getInstance(String testValue) {

        FragmentA fragmentA = new FragmentA();
        {
            Bundle bundle = new Bundle();

            bundle.putString(PassingDataKeyConstants.TEST_VALUE, testValue);

            fragmentA.setArguments(bundle);
        }

        return fragmentA;
    }

    @Override
    public String getViewPagerTitle() {
        return "SAYFA A";
    }
}
