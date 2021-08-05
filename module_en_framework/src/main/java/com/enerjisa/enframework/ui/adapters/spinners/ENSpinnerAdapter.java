package com.enerjisa.enframework.ui.adapters.spinners;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.enerjisa.enframework.ui.adapters.ENBaseAdapter;

import java.util.List;

/**
 * Created by ardakaplan on 18/11/15.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public abstract class ENSpinnerAdapter<W> extends ENBaseAdapter<W> {


    protected Integer spinnerViewLayoutId;
    protected Integer dropdownViewLayoutId;

    public ENSpinnerAdapter(Context context, List<W> list, Integer spinnerViewLayoutId, Integer dropdownViewLayoutId) {
        super(context, list);
        this.spinnerViewLayoutId = spinnerViewLayoutId;
        this.dropdownViewLayoutId = dropdownViewLayoutId;
    }


    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View spinnerView, ViewGroup parent) {
        return layoutInflater.inflate(spinnerViewLayoutId, parent, false);
    }

    @Override
    public View getDropDownView(int position, View dropdownItem, ViewGroup parent) {
        return layoutInflater.inflate(dropdownViewLayoutId, parent, false);
    }

}
