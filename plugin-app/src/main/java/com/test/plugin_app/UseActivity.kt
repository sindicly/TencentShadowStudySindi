package com.test.plugin_app;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.test.app_lib.HostUiLayerProvider;
import com.test.app_lib.utils.Tools;


/**
 * SimpleDes:
 * Creator: Sindi
 * Date: 2021-06-02
 * UseDes:调用宿主
 */
public class UseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Tools.cc();
        LinearLayout linearLayout = new LinearLayout(this);
        HostUiLayerProvider hostUiLayerProvider = HostUiLayerProvider.getInstance();
        View hostUiLayer = hostUiLayerProvider.buildHostUiLayer();
        linearLayout.addView(hostUiLayer);
        setContentView(linearLayout);

        //System.out.println("颜色值" + Tools.getInstance().getResourcesID());
    }
}
