package com.tencent.shadow.dynamic.impl;

/**
 * SimpleDes:
 * Creator: Sindi
 * Date: 2021-06-21
 * UseDes:
 *
 * 此类包名及类名固定
 * classLoader的白名单
 * PluginManager可以加载宿主中位于白名单内的类
 * 这个白名单类暂时没啥用，可以在插件打包的时候配置白名单
 */
public interface WhiteList {
    String[] sWhiteList = new String[]
            {
                    //"com.tencent.host.shadow",
                    //"com.tencent.shadow.test.lib.constant",
            };
}