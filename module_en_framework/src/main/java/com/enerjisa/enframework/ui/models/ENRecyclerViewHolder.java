package com.enerjisa.enframework.ui.models;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.ButterKnife;

/**
 * Created by Arda Kaplan at 23-Jul-19
 * <p>
 * arda.kaplan09@gmail.com
 */
public abstract class ENRecyclerViewHolder extends RecyclerView.ViewHolder {

    public ENRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }
}
