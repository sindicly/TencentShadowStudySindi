package com.test.shadow.service;

import android.content.pm.ApplicationInfo;
import android.content.res.Resources;

/**
 * SimpleDes:
 * Creator: Sindi
 * Date: 2021-06-21
 * UseDes:
 */
public class LoadPluginCallback {
    private static Callback sCallback;
    public static void setCallback(Callback callback) {
        sCallback = callback;
    }
    public static Callback getCallback() {
        return sCallback;
    }
    public interface Callback {
        void beforeLoadPlugin(String partKey);
        void afterLoadPlugin(String partKey, ApplicationInfo applicationInfo, ClassLoader pluginClassLoader, Resources pluginResources);
    }
}