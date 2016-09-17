package com.jaison.healthandglowproductlisting.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jaison on 17/09/16.
 */
public enum AppType {
    ANDROID("ANDROID");

    private final String code;
    private static final Map<String, AppType> valuesByCode;

    static {
        valuesByCode = new HashMap<>();
        for (AppType appType : AppType.values()) {
            valuesByCode.put(appType.code, appType);
        }
    }

    AppType(String code) {
        this.code = code;
    }

    public static AppType lookUpByCode(String code) {
        return valuesByCode.get(code);
    }

    public String getCode() {
        return code;
    }
}
