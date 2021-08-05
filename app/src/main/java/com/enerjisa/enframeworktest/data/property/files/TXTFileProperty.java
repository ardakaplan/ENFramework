package com.enerjisa.enframeworktest.data.property.files;


import com.enerjisa.enframework.data.property.files.ENTextFileProperty;

import java.io.File;

import javax.inject.Inject;

/**
 * Created by Arda Kaplan at 21-Oct-20 - 10:35
 * <p>
 * ardakaplan101@gmail.com
 */
public class TXTFileProperty extends ENTextFileProperty {

    private final FolderProperty folderProperty;

    @Inject
    TXTFileProperty(FolderProperty folderProperty) {
        this.folderProperty = folderProperty;
    }

    @Override
    protected String getFileName() {
        return "en_frame_work.txt";
    }

    @Override
    protected File getRootFile() {
        return folderProperty.getFile();
    }


}
