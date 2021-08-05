package com.enerjisa.enframeworktest.data.property.shareds;

import com.enerjisa.enframework.data.property.ENSharedProperty;
import com.enerjisa.enframework.helpers.ENSharedHelpers;

import javax.inject.Inject;

/**
 * Created by Arda Kaplan at 8.07.2021 - 15:10
 * <p>
 * ardakaplan101@gmail.com
 */
public class SaveStringTestSharedProperty extends ENSharedProperty<String> {

    @Inject
    SaveStringTestSharedProperty(ENSharedHelpers enSharedHelpers) {
        super(enSharedHelpers);
    }

    @Override
    public String getDefault() {
        return "";
    }

    @Override
    public String getValue() {
        return getStringValue();
    }

    @Override
    protected String getKey() {
        return "SaveStringTestSharedProperty";
    }
}
