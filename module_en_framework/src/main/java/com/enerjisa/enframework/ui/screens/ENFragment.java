package com.enerjisa.enframework.ui.screens;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.enerjisa.enframework.helpers.ENDeviceHelpers;
import com.enerjisa.enframework.helpers.ENStringHelpers;
import com.enerjisa.enframework.helpers.ENViewHelpers;
import com.enerjisa.enframework.ui.screens.contracts.UIController;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerFragment;

/**
 * Created by Arda Kaplan at 28.07.2021 - 16:47
 * <p>
 * ardakaplan101@gmail.com
 */
public abstract class ENFragment extends DaggerFragment implements UIController {

    private Unbinder unbinder;

    public void onAttach(Context context) {

        AndroidSupportInjection.inject(this);

        super.onAttach(context);
    }

    @Override
    public void closeKeyboard() {

        ENDeviceHelpers.closeKeyboard(getContainerActivity());
    }

    @Override
    public boolean isTextViewFilled(EditText editText) {
        return ENStringHelpers.isFilled(getPureTextFromTextView(editText));
    }

    @Override
    public boolean isTextViewEmpty(EditText editText) {
        return ENStringHelpers.isEmpty(getPureTextFromTextView(editText));
    }

    @Override
    public String getPureTextFromTextView(TextView textView) {
        return ENViewHelpers.getPureText(textView);
    }

    @Override
    public void showProgress(String message) {

        if (getContainerActivity() != null) {

            getContainerActivity().showProgress(message);
        }
    }

    @Override
    public void closeProgress() {

        if (getContainerActivity() != null) {

            getContainerActivity().closeProgress();
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(getLayoutId(), container, false);

        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    public ENActivity getContainerActivity() {

        return ((ENActivity) getActivity());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        unbinder.unbind();
    }

    public abstract String getViewPagerTitle();
}
