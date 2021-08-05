package com.enerjisa.enframeworktest.ui.base;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.IdRes;
import androidx.core.content.ContextCompat;

import com.enerjisa.enframework.data.model.ENSpinnerItem;
import com.enerjisa.enframework.ui.adapters.spinners.ENSpinnerAdapter;
import com.enerjisa.enframeworktest.R;

import java.util.List;


/**
 * Created by Arda Kaplan at 05-Jun-20 - 00:49
 * <p>
 * ardakaplan101@gmail.com
 * <p>
 * uygulama genelinde tüm spinnerlar bu sınıfı kullanmalı (tüm spinnerlar aynı özellikte, renkte olması isteniyorsa), eğer viewla alakalı değişiklik yapılmak isteniyorsa,
 * <p>
 * ilgili metotlar override edilerek kullanılabilir
 * <p>
 * extend yapılıp, metotlar override edilebilir
 */
public class GeneralSpinnerAdapter<W extends ENSpinnerItem> extends ENSpinnerAdapter<W> {

    private int selectedItemIndex = -1;

    public GeneralSpinnerAdapter(Context context, List<W> list) {
        super(context, list, R.layout.view_general_spinner_item, R.layout.view_general_spinner_item);
    }

    public void setSelectedItemIndex(int selectedItemIndex) {
        this.selectedItemIndex = selectedItemIndex;
    }

    @Override
    public View getView(int position, View spinnerView, ViewGroup parent) {

        spinnerView = super.getView(position, spinnerView, parent);

        return adjustView(spinnerView, position, true);
    }

    @Override
    public View getDropDownView(int position, View dropdownItem, ViewGroup parent) {

        dropdownItem = super.getDropDownView(position, dropdownItem, parent);

        return adjustView(dropdownItem, position, false);
    }

    private View adjustView(View spinnerView, int position, boolean isSpinner) {

        ImageView imageView = spinnerView.findViewById(getImageViewId());

        TextView textView = spinnerView.findViewById(getTextViewId());

        textView.setText(getItem(position).getScreenText());

        if (isSpinner) {

            imageView.setVisibility(View.VISIBLE);

            imageView.setImageDrawable(ContextCompat.getDrawable(spinnerView.getContext(), R.drawable.arrow_down_blue_bayoux));

            textView.setTextColor(ContextCompat.getColor(spinnerView.getContext(), getSelectedColor()));

        } else {

            if (position == selectedItemIndex) {

                imageView.setVisibility(View.VISIBLE);

                imageView.setImageDrawable(ContextCompat.getDrawable(spinnerView.getContext(), R.drawable.check_blue_bayoux));

                imageView.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(context, getSelectedColor())));

                textView.setTextColor(ContextCompat.getColor(spinnerView.getContext(), getSelectedColor()));

            } else {

                imageView.setVisibility(View.INVISIBLE);

                textView.setTextColor(ContextCompat.getColor(spinnerView.getContext(), getUnSelectedColor()));
            }
        }

        return spinnerView;
    }


    protected @IdRes
    int getTextViewId() {
        return R.id.generalSpinnerItem_textView_text;
    }


    protected @IdRes
    int getImageViewId() {
        return R.id.generalSpinnerItem_imageView;
    }


    protected @ColorRes
    int getSelectedColor() {
        return R.color.pink;
    }


    protected @ColorRes
    int getUnSelectedColor() {
        return R.color.gray3;
    }
}
