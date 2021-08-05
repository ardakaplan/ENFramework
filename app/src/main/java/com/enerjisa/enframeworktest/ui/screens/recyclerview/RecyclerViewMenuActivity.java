package com.enerjisa.enframeworktest.ui.screens.recyclerview;

import android.content.Intent;

import com.enerjisa.enframework.ui.screens.ENActivity;
import com.enerjisa.enframeworktest.R;
import com.enerjisa.enframeworktest.ui.base.BaseActivity;
import com.enerjisa.enframeworktest.ui.screens.recyclerview.normal.NormalRecyclerViewListActivity;

import butterknife.OnClick;

/**
 * Created by Arda Kaplan at 26.07.2021 - 13:41
 * <p>
 * ardakaplan101@gmail.com
 */
public class RecyclerViewMenuActivity extends BaseActivity {

    @OnClick(R.id.recyclerViewTest_button_normalList)
    void clickedNormalList() {

        NormalRecyclerViewListActivity.open(this);
    }

    @OnClick(R.id.recyclerViewTest_button_swipeList)
    void clickedSwipeList() {

    }

    public static void open(ENActivity activity) {

        activity.startActivity(new Intent(activity, RecyclerViewMenuActivity.class));

    }

    @Override
    public int getLayoutId() {
        return R.layout.recycler_view_menu_activity;
    }
}
