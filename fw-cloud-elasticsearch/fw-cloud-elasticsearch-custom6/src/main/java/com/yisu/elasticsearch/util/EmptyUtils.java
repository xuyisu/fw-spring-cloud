package com.yisu.elasticsearch.util;

import java.util.List;
import java.util.Map;


/**
 * @author xuyisu
 * @description 判空工具类
 * @date 2020/10/26
 */
public class EmptyUtils {

    public static boolean isEmpty(Object s) {
        if (s == null) {
            return true;
        }
        if ((s instanceof String) && (((String)s).trim().length() == 0)) {
            return true;
        }
        if (s instanceof Map) {
            return ((Map<?, ?>)s).isEmpty();
        }
        if (s instanceof List) {
            return ((List<?>)s).isEmpty();
        }
        if (s instanceof Object[]) {
            return (((Object[])s).length == 0);
        }
        return false;
    }

}
