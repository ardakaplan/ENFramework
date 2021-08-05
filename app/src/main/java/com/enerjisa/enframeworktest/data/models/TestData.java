package com.enerjisa.enframeworktest.data.models;

import com.enerjisa.enframework.data.model.ENObject;
import com.enerjisa.enframework.data.model.ENSpinnerItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arda Kaplan at 27.07.2021 - 14:52
 * <p>
 * ardakaplan101@gmail.com
 */
public class TestData extends ENObject implements ENSpinnerItem {

    private String name;

    public TestData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * {@link ENSpinnerItem} implementasyonu için
     *
     * @return name
     */
    @Override
    public String getScreenText() {
        return name;
    }

    public static List<TestData> getTestDataList(int limit) {

        List<TestData> testDataList = new ArrayList<>();

        for (int i = 0; i < limit; i++) {

            testDataList.add(new TestData("TEST DATA " + i));
        }

        return testDataList;
    }

    public static TestData getInstance() {

        return new TestData("TEST DATA");
    }
}
