package com.enerjisa.enframeworktest.ui.screens.recyclerview.normal;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.enerjisa.enframework.ui.adapters.ENRecyclerViewAdapter;
import com.enerjisa.enframework.ui.models.ENRecyclerViewHolder;
import com.enerjisa.enframeworktest.R;
import com.enerjisa.enframeworktest.data.models.TestData;

import javax.inject.Inject;

import butterknife.BindView;

public class NormalListRecyclerViewAdapter extends ENRecyclerViewAdapter<TestData, NormalListRecyclerViewAdapter.ViewHolder> {

    @Inject
    NormalListRecyclerViewAdapter() {
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        //click olaylarının base sınıfta otomatik halledilmesini istiyorsak "super"i çağırmamız lazım
        super.onBindViewHolder(viewHolder, position);

        TestData testData = getItem(position);

        viewHolder.nameTextView.setText(testData.getName());
    }

    @Override
    protected ViewHolder getViewHolderInstance(View view) {

        //view holder instance ını geri dönüyoruz, base sınıf gerisini hallediyor
        return new ViewHolder(view);
    }

    @Override
    protected int getItemLayout() {
        return R.layout.recycler_view_list_normal_item;
    }

    static class ViewHolder extends ENRecyclerViewHolder {

        @BindView(R.id.recyclerViewListNormalItem_name)
        TextView nameTextView;

        ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
