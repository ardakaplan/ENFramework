package com.enerjisa.enframeworktest.ui.screens.viewpager;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;

import com.enerjisa.enframeworktest.R;
import com.enerjisa.enframeworktest.ui.base.BaseActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Arda Kaplan at 28.07.2021 - 10:58
 * <p>
 * ardakaplan101@gmail.com
 * <p>
 * viewpager kullanımı için örnek
 * <p>
 * viewpager içerisinde 3 tane ekran var. Bu ekranlar kendi base sınıflarından türüyor, ortak ayarlar varsa burada yapılmalı
 */
public class ViewPagerActivity extends BaseActivity {

    @BindView(R.id.viewPagerActivity_viewPager2)
    ViewPager2 viewPager2;
    @BindView(R.id.viewPagerActivity_tabLayout)
    TabLayout tabLayout;

    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setViewPager();
    }

    private void setViewPager() {

        viewPagerAdapter = new ViewPagerAdapter(this, viewPager2, tabLayout, "string test data");

        viewPager2.setAdapter(viewPagerAdapter);
    }

    @OnClick(R.id.viewPagerActivity_button_pageA)
    void clickedPageA() {

        viewPagerAdapter.openPageA();
    }

    @OnClick(R.id.viewPagerActivity_button_pageB)
    void clickedPageB() {

        viewPagerAdapter.openPageB();
    }

    @OnClick(R.id.viewPagerActivity_button_pageC)
    void clickedPageC() {

        viewPagerAdapter.openPageC();
    }

    public static void open(BaseActivity activity) {

        activity.startActivity(new Intent(activity, ViewPagerActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.view_pager_activity;
    }
}
