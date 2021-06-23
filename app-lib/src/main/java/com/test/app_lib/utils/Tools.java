package com.test.app_lib.utils;

import android.content.Context;
import android.content.res.Resources;

/**
 * SimpleDes:
 * Creator: Sindi
 * Date: 2021-06-23
 * UseDes:
 */
public class Tools {

    public static void cc() {
        System.out.println("1234564");
    }


    private static Tools sInstance;

    final private Context mContext;

    public static void init(Context mHostApplicationContext) {
        sInstance = new Tools(mHostApplicationContext);
    }

    public static Tools getInstance() {
        return sInstance;
    }


    private Tools(Context mHostApplicationContext) {
        this.mContext = mHostApplicationContext;
    }

    public int getResourcesID() {
        Resources res = mContext.getResources();
        return res.getIdentifier("green_7200AF66", "color", mContext.getPackageName());
    }
}
