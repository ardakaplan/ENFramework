package com.enerjisa.enframework.data.model;

import androidx.annotation.NonNull;

import com.enerjisa.enframework.helpers.ENStringHelpers;

/**
 * Created by Arda Kaplan at 27.07.2021 - 14:53
 * <p>
 * ardakaplan101@gmail.com
 */
public class ENObject {

    @NonNull
    @Override
    public String toString() {

        return ENStringHelpers.getAsJsonWithFormat(this);
    }
}
