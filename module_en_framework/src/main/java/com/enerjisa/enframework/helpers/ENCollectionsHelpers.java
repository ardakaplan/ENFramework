package com.enerjisa.enframework.helpers;

import java.util.List;
import java.util.Map;

/**
 * collection sınıflarına ait yardımcı sınıf
 */
public class ENCollectionsHelpers {

    private ENCollectionsHelpers() {

    }

    /**
     * @param map map
     * @return verilen map boş veya null ?
     */
    public static boolean isMapEmpty(Map<?, ?> map) {

        return map == null || map.isEmpty();
    }

    /**
     * @param list list
     * @return verilen list null ?
     */
    public static boolean isListNull(List<?> list) {

        return list == null;
    }

    /**
     * @param list list
     * @return verilen list boç veya null?
     */
    public static boolean isListEmpty(List<?> list) {

        return isListNull(list) || list.size() == 0;
    }
}
