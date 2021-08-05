package com.enerjisa.enframeworktest.ui.screens.recyclerview.normal;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.ardakaplan.rdalogger.RDALogger;
import com.enerjisa.enframework.data.model.ENItemClickListener;
import com.enerjisa.enframework.ui.screens.ENActivity;
import com.enerjisa.enframeworktest.R;
import com.enerjisa.enframeworktest.data.models.TestData;
import com.enerjisa.enframeworktest.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Arda Kaplan at 26.07.2021 - 13:44
 * <p>
 * ardakaplan101@gmail.com
 */
public class NormalRecyclerViewListActivity extends BaseActivity {

    @BindView(R.id.recyclerViewListNormalActivity_recyclerView)
    RecyclerView recyclerView;

    @Inject
    NormalListRecyclerViewAdapter normalListRecyclerViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setList();

        showData();
    }

    private void setList() {

        normalListRecyclerViewAdapter.setEnItemClickListener(new ENItemClickListener<TestData>() {

            @Override
            public void onItemClick(TestData testData, int index) {

                RDALogger.info("CLICKED ITEM - index :" + index + "\n" + testData);
            }

            @Override
            public void onItemLongClick(TestData testData, int index) {

                RDALogger.info("LONG CLICKED ITEM -  index :" + index + "\n" + testData);
            }
        });

        recyclerView.setAdapter(normalListRecyclerViewAdapter);
    }

    private void showData() {

        normalListRecyclerViewAdapter.setData(TestData.getTestDataList(50));
    }

    @Override
    public int getLayoutId() {
        return R.layout.recycler_view_list_normal_activity;
    }

    public static void open(ENActivity activity) {

        activity.startActivity(new Intent(activity, NormalRecyclerViewListActivity.class));

    }
}
