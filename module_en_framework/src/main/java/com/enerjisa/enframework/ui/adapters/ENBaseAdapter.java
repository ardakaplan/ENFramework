package com.enerjisa.enframework.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by ardakaplan on 19/11/15.
 */
@SuppressWarnings("WeakerAccess")
public abstract class ENBaseAdapter<W> extends BaseAdapter {

    protected Context context;
    protected List<W> list;
    protected LayoutInflater layoutInflater;

    public ENBaseAdapter(Context context, List<W> list) {

        this.context = context;
        this.list = list;

        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {

        if (list == null) {

            return 0;
        }

        return list.size();
    }

    @Override
    public W getItem(int position) {

        if (list == null) {

            return null;
        }

        return list.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


}
