package com.enerjisa.enframework.data.property.files;

import android.os.Environment;
import android.util.Log;

import java.io.File;

/**
 * Created by Arda Kaplan on 03-Apr-19 - 17:23
 */
public abstract class ENFolderProperty extends ENFileProperty {

    /**
     * @return null döner ise dosya yaratılamamış demektir
     */
    public File getFile() {

        StringBuilder path = new StringBuilder();

        if (getRootFile() == null) {

            //this is root folder
            path.append(Environment.getExternalStorageDirectory());

        } else {

            path.append(getRootFile().getAbsolutePath());
        }

        path.append(File.separator);

        path.append(getFileName());

        File file = new File(path.toString());

        if (checkAndCreateFile(file)) {

            return file;

        } else {

            return null;
        }
    }

    private boolean checkAndCreateFile(File file) {

        boolean result;

        if (file.exists()) {

            Log.i(getClass().getSimpleName(), "File is already exists || path : " + file.getAbsolutePath());

            result = true;

        } else {

            result = file.mkdirs();

            Log.i(getClass().getSimpleName(), "File mkdirs result : " + result + " || path : " + file.getAbsolutePath());
        }

        return result;
    }

}
