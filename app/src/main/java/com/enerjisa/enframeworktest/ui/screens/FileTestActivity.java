package com.enerjisa.enframeworktest.ui.screens;

import android.Manifest;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import com.ardakaplan.rdalogger.RDALogger;
import com.enerjisa.enframeworktest.R;
import com.enerjisa.enframeworktest.data.property.files.TXTFileProperty;
import com.enerjisa.enframeworktest.ui.base.BaseActivity;

import java.io.IOException;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Arda Kaplan at 8.07.2021 - 15:50
 * <p>
 * ardakaplan101@gmail.com
 */
public class FileTestActivity extends BaseActivity {

    @BindView(R.id.fileTestActivity_editText_txtContent)
    EditText txtContentEditText;
    @Inject
    TXTFileProperty txtFileProperty;

    @OnClick(R.id.fileTestActivity_button_saveTXTAppend)
    void clickedSaveTXTAppend() {

        if (checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            try {

                txtFileProperty.saveContent(getPureTextFromTextView(txtContentEditText), true);

            } catch (IOException e) {

                e.printStackTrace();
            }

        } else {

            Toast.makeText(this, "uygulama izinlerini sağlamalısın", Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.fileTestActivity_button_saveTXT)
    void clickedSaveTXT() {

        if (checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            try {

                txtFileProperty.saveContent(getPureTextFromTextView(txtContentEditText), false);

            } catch (IOException e) {

                e.printStackTrace();
            }

        } else {

            Toast.makeText(this, "uygulama izinlerini sağlamalısın", Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.fileTestActivity_button_readTXT)
    void clickedReadTXT() {

        if (checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            try {

                txtContentEditText.setText(txtFileProperty.getContent());

                RDALogger.info("TXT CONTENT\n" + txtFileProperty.getContent());

            } catch (IOException e) {

                e.printStackTrace();
            }

        } else {

            Toast.makeText(this, "uygulama izinlerini sağlamalısın", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.file_test_activity;
    }

    public static void open(BaseActivity activity) {

        activity.startActivity(new Intent(activity, FileTestActivity.class));
    }
}
