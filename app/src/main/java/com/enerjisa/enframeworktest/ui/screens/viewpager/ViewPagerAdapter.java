package com.enerjisa.enframeworktest.ui.screens.viewpager;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

import com.enerjisa.enframework.ui.screens.ENActivity;
import com.enerjisa.enframeworktest.ui.screens.viewpager.innerfragments.FragmentA;
import com.enerjisa.enframeworktest.ui.screens.viewpager.innerfragments.FragmentB;
import com.enerjisa.enframeworktest.ui.screens.viewpager.innerfragments.FragmentC;
import com.google.android.material.tabs.TabLayout;


/**
 * her bir viewpager adapter {@link com.enerjisa.enframeworktest.ui.screens.viewpager.ENViewPagerAdapter} sınıfından türemek zorunda
 */
public class ViewPagerAdapter extends com.enerjisa.enframeworktest.ui.screens.viewpager.ENViewPagerAdapter {


    /**
     * sayfalarının pozisyonlarını tutan değişkenler, daha jenerik bir yapı için böyle kullanıldı,
     * burdan index değiştirildiğinde heryerden değişir,
     * <p>
     * yeni bir index yazıldığından buna uygun fragment ın {@link #viewPagerFragmentList} listesine eklenmesi gereki
     */

    private final int FRAGMENT_A_POSITION = 0;
    private final int FRAGMENT_B_POSITION = 1;
    private final int FRAGMENT_C_POSITION = 2;

    private final String testValue;

    public ViewPagerAdapter(@NonNull ENActivity activity, ViewPager2 viewPager2, TabLayout tabLayout, String testValue) {
        super(activity, viewPager2, tabLayout);

        //kendi ile ilgili alanlar varsa burda alınır, fragmentlara veye kendi içinde işlem yapılır
        this.testValue = testValue;

        viewPagerFragmentList.add(FRAGMENT_A_POSITION, FragmentA.getInstance(testValue));
        viewPagerFragmentList.add(FRAGMENT_B_POSITION, FragmentB.getInstance());
        viewPagerFragmentList.add(FRAGMENT_C_POSITION, FragmentC.getInstance());
    }

    /**
     * sayfalarının açılma olaylarını sadece adapter kontrol etsin istediğimiz için bu metotlar adapter içerisine taşındı,
     * kod yardımıyla açılması istenilen herbir ekran için böyle bir metot yazılması gerekiyor
     */
    public void openPageA() {

        openPage(FRAGMENT_A_POSITION);
    }

    public void openPageB() {

        openPage(FRAGMENT_B_POSITION);
    }

    public void openPageC() {

        openPage(FRAGMENT_C_POSITION);
    }
}

