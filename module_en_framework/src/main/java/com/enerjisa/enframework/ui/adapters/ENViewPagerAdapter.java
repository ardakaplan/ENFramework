package com.enerjisa.enframeworktest.ui.screens.viewpager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.enerjisa.enframework.ui.screens.ENActivity;
import com.enerjisa.enframework.ui.screens.ENFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arda Kaplan at 3.08.2021 - 15:12
 * <p>
 * ardakaplan101@gmail.com
 * <p>
 * view pager larda kullanılacak base sınıf
 * <p>
 * - kendi listesine eklenen fragment ları ekrana getirir
 * - bu {@link ENFragment} ların {@link ENFragment#getViewPagerTitle()} metodunu çağırarak, tab layout alanını set eder
 */
public class ENViewPagerAdapter extends FragmentStateAdapter {

    //views
    protected final ViewPager2 viewPager2;
    protected final @Nullable
    TabLayout tabLayout;

    //fragment listesi
    protected final List<ENFragment> viewPagerFragmentList = new ArrayList<>();

    /**
     * @param activity   activity
     * @param viewPager2 viewpager
     * @param tabLayout  tablayout- null olabilir, bazı ekranlarda başlık göstermek istemeyebiliriz
     */
    public ENViewPagerAdapter(@NonNull ENActivity activity, ViewPager2 viewPager2, @Nullable TabLayout tabLayout) {
        super(activity);

        this.viewPager2 = viewPager2;
        this.tabLayout = tabLayout;
    }

    /**
     * setAdapter metodu çağrılınca çalışır böylece TabLayoutMediator set edilebilir hale gelir
     *
     * @param recyclerView recyclerView
     */
    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        setTabLayoutMediator();
    }

    /**
     * {@link #tabLayout a başlıkları set etmek için kullanılır}
     * <p>
     * eğer custom bir layout kullanılacaksa bu metot alt sınıflarda override edilebilir
     */
    protected void setTabLayoutMediator() {

        if (tabLayout != null) {

            new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {

                @Override
                public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                    tab.setText(viewPagerFragmentList.get(position).getViewPagerTitle());
                }
            }).attach();
        }
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return viewPagerFragmentList.get(position);
    }

    @Override
    public int getItemCount() {

        return viewPagerFragmentList.size();
    }

    /**
     * ekran açma olayları adapter trarafından yönetilsin istediğimiz için temel metot bu şekilde
     * <p>
     * alt sınıflarda, her bir ekran için yazılmış, bu metodu çağıran metotlar olması lazım
     *
     * @param position verilen posizyona göre viewpager daki ekranı açar
     */
    protected void openPage(int position) {

        viewPager2.setCurrentItem(position);
    }
}
