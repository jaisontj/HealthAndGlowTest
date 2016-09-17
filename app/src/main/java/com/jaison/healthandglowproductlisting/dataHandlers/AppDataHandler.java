package com.jaison.healthandglowproductlisting.dataHandlers;

import com.jaison.healthandglowproductlisting.enums.AppType;

/**
 * Created by Jaison on 17/09/16.
 */
public class AppDataHandler {

    private static AppDataHandler instance = new AppDataHandler();

    public AppDataHandler getInstance() {
        return instance;
    }

    public static String getAppType() {
        return AppType.ANDROID.getCode();
    }

    public static String getAppVersion() {
        return "2.0.0.1";
    }

    public static String getBatchSize() {
        return "20";
    }
}
