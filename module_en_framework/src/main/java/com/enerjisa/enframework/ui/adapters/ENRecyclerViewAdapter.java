package com.enerjisa.enframework.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.enerjisa.enframework.data.model.ENItemClickListener;
import com.enerjisa.enframework.ui.models.ENRecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arda Kaplan
 * <p>
 * arda.kaplan09@gmail.com
 * <p>
 * www.ardakaplan.com
 */

//    ItemObject for object
//    VH for view holder
@SuppressWarnings({"WeakerAccess", "unused"})
public abstract class ENRecyclerViewAdapter<W, VH extends ENRecyclerViewHolder> extends RecyclerView.Adapter<VH> {

    //click listener, kullanılması için adapter oluşturulurken veya sonra sonrasından set edilmesi gerekiyor
    protected ENItemClickListener<W> enItemClickListener;

    //listeyi tutan obje
    protected List<W> dataList = new ArrayList<>();

    public ENRecyclerViewAdapter() {
    }

    public ENRecyclerViewAdapter(List<W> dataList) {

        this(dataList, null);
    }

    public ENRecyclerViewAdapter(ENItemClickListener<W> enItemClickListener) {

        this(new ArrayList<>(), enItemClickListener);
    }

    public ENRecyclerViewAdapter(List<W> dataList, ENItemClickListener<W> enItemClickListener) {
        this.dataList = dataList;
        this.enItemClickListener = enItemClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int index) {

        setItemClick(holder, index);
    }

    public void removeItem(int index) {

        dataList.remove(index);

        notifyItemRemoved(index);

        notifyItemRangeChanged(index, getItemCount());
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return getViewHolderInstance(LayoutInflater.from(parent.getContext()).inflate(getItemLayout(), parent, false));
    }

    /**
     * click leri set eder
     *
     * @param vh    viewholder
     * @param index index
     */
    protected void setItemClick(VH vh, int index) {

        vh.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (enItemClickListener != null) {

                    enItemClickListener.onItemClick(getItem(index), index);

                    itemClicked(vh, index);
                }
            }
        });

        vh.itemView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                if (enItemClickListener != null) {

                    enItemClickListener.onItemLongClick(getItem(index), index);

                    itemLongClicked(vh, index);
                }

                return true;
            }
        });
    }

    /**
     * adapter içerisinde, tıklama sonrasında birşeyler yapılması isteniyorsa bu metot override edilerek kullanılabilir
     *
     * @param vh    viewholder
     * @param index index
     */
    protected void itemClicked(VH vh, int index) {

    }

    /**
     * adapter içerisinde, uzun tıklama sonrasında birşeyler yapılması isteniyorsa bu metot override edilerek kullanılabilir
     *
     * @param vh    viewholder
     * @param index index
     */
    protected void itemLongClicked(VH vh, int index) {

    }

    public List<W> getDataList() {
        return dataList;
    }


    /**
     * @param view inflated view
     * @return object that used in every row view
     */
    protected abstract VH getViewHolderInstance(View view);

    /**
     * @return item layout
     */
    protected abstract @LayoutRes
    int getItemLayout();

    public W getItem(int index) {

        return dataList.get(index);
    }

    public void addItem(int index, W w) {

        dataList.add(index, w);

        notifyItemInserted(index);

        notifyItemRangeChanged(index, getItemCount());
    }

    public void changeItem(int index, W w) {

        dataList.set(index, w);

        notifyItemChanged(index);
    }

    public void setData(List<W> dataList) {

        this.dataList = dataList;

        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public ENItemClickListener<W> getEnItemClickListener() {
        return enItemClickListener;
    }

    public void setEnItemClickListener(ENItemClickListener<W> enItemClickListener) {
        this.enItemClickListener = enItemClickListener;
    }
}
