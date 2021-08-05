package com.enerjisa.enframeworktest.ui.screens.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.annotation.Nullable;

import com.ardakaplan.rdalogger.RDALogger;
import com.enerjisa.enframework.ui.adapters.spinners.ENNothingSelectedSpinnerAdapter;
import com.enerjisa.enframeworktest.R;
import com.enerjisa.enframeworktest.data.models.TestData;
import com.enerjisa.enframeworktest.ui.base.BaseActivity;
import com.enerjisa.enframeworktest.ui.base.GeneralSpinnerAdapter;

import butterknife.BindView;

/**
 * Created by Arda Kaplan at 28.07.2021 - 14:23
 * <p>
 * ardakaplan101@gmail.com
 */
public class SpinnerActivity extends BaseActivity {

    @BindView(R.id.spinnerActivity_spinner_defaultValue)
    Spinner defaultValueSpinner;
    @BindView(R.id.spinnerActivity_spinner_nothingSelected)
    Spinner nothingSelectedSpinner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setDefaultValueSpinner();

        setNothingSelectedSpinner();
    }

    private void setDefaultValueSpinner() {

        GeneralSpinnerAdapter<TestData> spinnerAdapterDemo = new GeneralSpinnerAdapter<>(this, TestData.getTestDataList(50));

        defaultValueSpinner.setAdapter(spinnerAdapterDemo);

        defaultValueSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                TestData testData = (TestData) parent.getAdapter().getItem(position);

                RDALogger.info("SELECTED TEST DATA ->\n" + testData);

                spinnerAdapterDemo.setSelectedItemIndex(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setNothingSelectedSpinner() {

        GeneralSpinnerAdapter<TestData> spinnerAdapterDemo = new GeneralSpinnerAdapter<>(this, TestData.getTestDataList(50));

        nothingSelectedSpinner.setAdapter(new ENNothingSelectedSpinnerAdapter(spinnerAdapterDemo, R.layout.view_general_spinner_item, this));

        nothingSelectedSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                TestData testData = (TestData) parent.getAdapter().getItem(position);

                if (testData != null) {

                    RDALogger.info("SELECTED TEST DATA ->\n" + testData);

                    spinnerAdapterDemo.setSelectedItemIndex(position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.spinner_activity;
    }

    public static void open(BaseActivity activity) {

        activity.startActivity(new Intent(activity, SpinnerActivity.class));
    }
}
