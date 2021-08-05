package com.enerjisa.enframework.data.property.files;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Arda Kaplan at 4/5/2019
 * <p>
 * arda.kaplan09@gmail.com
 */
public abstract class ENTextFileProperty extends ENFileProperty {

    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    protected File createFile() {

        File file;

        if (getRootFile() == null) {

            file = new File(Environment.getExternalStorageDirectory().toString(), getFileName());

        } else {

            file = new File(getRootFile(), getFileName());
        }

        return file;
    }

    /**
     * @param content kayıt edilecek içerik
     * @param append  eski içeriğin sonuna mı eklenecek yoksa üzerine mi yazılacak
     * @return file
     * @throws IOException
     */
    public File saveContent(String content, boolean append) throws IOException {

        File file = createFile();

        FileWriter reportWriter = new FileWriter(file, append);

        BufferedWriter bw = new BufferedWriter(reportWriter);

        bw.write(content);

        bw.close();

        return file;
    }

    public File saveContent(boolean append) throws IOException {

        return saveContent(content, append);
    }

    public String getContent() throws IOException {

        StringBuilder contentText = new StringBuilder();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(getFile()));

        String line;

        while ((line = bufferedReader.readLine()) != null) {

            contentText.append(line);

            contentText.append('\n');
        }

        bufferedReader.close();

        return contentText.toString();
    }

}
