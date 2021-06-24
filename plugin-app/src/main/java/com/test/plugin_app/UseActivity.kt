package com.test.plugin_app

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.test.app_lib.HostUiLayerProvider
import com.test.app_lib.utils.Tools

/**
 * SimpleDes:
 * Creator: Sindi
 * Date: 2021-06-02
 * UseDes:调用宿主
 */
class UseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Tools.cc()
        val linearLayout = LinearLayout(this)
        val hostUiLayerProvider = HostUiLayerProvider.getInstance()
        val hostUiLayer = hostUiLayerProvider.buildHostUiLayer()
        linearLayout.addView(hostUiLayer)
        setContentView(linearLayout)

        //System.out.println("颜色值" + Tools.getInstance().getResourcesID());
        Tools.getPluginData{ "456" }//给宿主传数据
    }
}