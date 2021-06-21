package com.tencent.shadow.dynamic.impl;

/**
 * SimpleDes:
 * Creator: Sindi
 * Date: 2021-06-21
 * UseDes:
 */
import android.content.Context;
import com.tencent.shadow.dynamic.host.ManagerFactory;
import com.tencent.shadow.dynamic.host.PluginManagerImpl;
import com.test.plugin_manager.SamplePluginManager;

//此类包名及类名固定
public final class ManagerFactoryImpl implements ManagerFactory {
    @Override
    public PluginManagerImpl buildManager(Context context) {
        return new SamplePluginManager(context);
    }
}
