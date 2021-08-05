package com.enerjisa.enframework.data.property;

import com.enerjisa.enframework.helpers.ENSharedHelpers;

/**
 * Created by Arda Kaplan on 05-Feb-19 - 15:47
 * <p>
 * <p>
 * W can be Integer,Boolean,Long,String
 */
public abstract class ENSharedProperty<W> {

    private final ENSharedHelpers enSharedHelpers;

    public ENSharedProperty(ENSharedHelpers enSharedHelpers) {
        this.enSharedHelpers = enSharedHelpers;
    }

    public void saveValue(W w) {

        if (w instanceof Integer) {

            enSharedHelpers.putInt(getKey(), (Integer) w);

        } else if (w instanceof String) {

            enSharedHelpers.putString(getKey(), (String) w);

        } else if (w instanceof Boolean) {

            enSharedHelpers.putBoolean(getKey(), (Boolean) w);

        } else if (w instanceof Long) {

            enSharedHelpers.putLong(getKey(), (Long) w);
        }
    }

    protected Integer getIntegerValue() {

        return enSharedHelpers.getInt(getKey(), (Integer) getDefault());
    }

    protected String getStringValue() {

        return enSharedHelpers.getString(getKey(), (String) getDefault());
    }

    protected Boolean getBooleanValue() {

        return enSharedHelpers.getBoolean(getKey(), (Boolean) getDefault());
    }

    protected Long getLongValue() {

        return enSharedHelpers.getLong(getKey(), (Long) getDefault());
    }

    public void delete() {

        enSharedHelpers.delete(getKey());
    }

    public abstract W getDefault();

    public abstract W getValue();

    protected abstract String getKey();
}
