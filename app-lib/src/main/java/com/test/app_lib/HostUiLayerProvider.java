
package com.test.app_lib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;


/**
 * 这是一个将要打包到宿主中的类。原本的目的是宿主依赖插件，宿主
 */
public class HostUiLayerProvider {
    private static HostUiLayerProvider sInstance;

    public static void init(Context mHostApplicationContext) {
        sInstance = new HostUiLayerProvider(mHostApplicationContext);
    }

    public static HostUiLayerProvider getInstance() {
        return sInstance;
    }

    final private Context mHostApplicationContext;

    private HostUiLayerProvider(Context mHostApplicationContext) {
        this.mHostApplicationContext = mHostApplicationContext;
    }

    public View buildHostUiLayer() {
        return LayoutInflater.from(mHostApplicationContext)
                .inflate(R.layout.host_ui_layer_layout, null, false);
    }
}
