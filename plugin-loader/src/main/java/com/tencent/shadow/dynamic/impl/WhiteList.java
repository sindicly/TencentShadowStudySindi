package com.tencent.shadow.dynamic.impl;

/**
 * SimpleDes:
 * Creator: Sindi
 * Date: 2021-06-21
 * UseDes:
 * 此类包名及类名固定
 * classLoader的白名单
 * PluginLoader可以加载宿主中位于白名单内的类
 */
public interface WhiteList {
    String[] sWhiteList = new String[]{
            "com.a.b",
    };
}