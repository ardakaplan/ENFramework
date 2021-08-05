package com.enerjisa.enframeworktest.ui.screens;

import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

import com.enerjisa.enframeworktest.R;
import com.enerjisa.enframeworktest.data.property.shareds.SaveStringTestSharedProperty;
import com.enerjisa.enframeworktest.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Arda Kaplan at 8.07.2021 - 15:50
 * <p>
 * ardakaplan101@gmail.com
 */
public class SharedTestActivity extends BaseActivity {


    @BindView(R.id.sharedTestActivity_editText_stringValue)
    EditText stringValueEditText;
    @BindView(R.id.sharedTestActivity_textView_stringValue)
    TextView stringValueTextView;

    @Inject
    SaveStringTestSharedProperty saveStringTestSharedProperty;

    @OnClick(R.id.sharedTestActivity_button_saveString)
    void clickedSaveString() {

        saveStringTestSharedProperty.saveValue(getPureTextFromTextView(stringValueEditText));
    }

    @OnClick(R.id.sharedTestActivity_button_readString)
    void clickedReadString() {

        stringValueTextView.setText(String.format("SHARED OKUNAN DEĞER -> %s", saveStringTestSharedProperty.getValue()));
    }

    @Override
    public int getLayoutId() {
        return R.layout.shared_test_activity;
    }

    public static void open(BaseActivity activity) {

        activity.startActivity(new Intent(activity, SharedTestActivity.class));
    }
}
