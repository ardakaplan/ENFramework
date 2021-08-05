package com.enerjisa.enframeworktest.data.property.files;

import com.enerjisa.enframework.data.property.files.ENFolderProperty;

import java.io.File;

import javax.inject.Inject;

/**
 * Created by Arda Kaplan on 05-Apr-19 - 17:05
 */
public class FolderProperty extends ENFolderProperty {

    @Inject
    FolderProperty() {
    }

    @Override
    public String getFileName() {
        return "EN_FRAMEWORK_FOLDER";
    }

    @Override
    protected File getRootFile() {
        return null;
    }


}
