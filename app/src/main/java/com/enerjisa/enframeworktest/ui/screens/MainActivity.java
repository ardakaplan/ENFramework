package com.enerjisa.enframeworktest.ui.screens;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.enerjisa.enframeworktest.R;
import com.enerjisa.enframeworktest.ui.base.BaseActivity;
import com.enerjisa.enframeworktest.ui.screens.dialogs.DialogsActivity;
import com.enerjisa.enframeworktest.ui.screens.recyclerview.RecyclerViewMenuActivity;
import com.enerjisa.enframeworktest.ui.screens.spinner.SpinnerActivity;
import com.enerjisa.enframeworktest.ui.screens.viewpager.ViewPagerActivity;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.mainActicity_button_fileTest)
    void clickedFileTest() {

        FileTestActivity.open(this);
    }

    @OnClick(R.id.mainActicity_button_sharedTest)
    void clickedSharedTest() {

        SharedTestActivity.open(this);
    }

    @OnClick(R.id.mainActicity_button_recyclerTest)
    void clickedRecyclerViewTest() {

        RecyclerViewMenuActivity.open(this);
    }

    @OnClick(R.id.mainActicity_button_dialogs)
    void clickedDialogs() {

        DialogsActivity.open(this);
    }

    @OnClick(R.id.mainActicity_button_spinner)
    void clickedSpinner() {

        SpinnerActivity.open(this);
    }

    @OnClick(R.id.mainActicity_button_viewPager)
    void clickedViewPager() {

        ViewPagerActivity.open(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.main_activity;
    }
}