package com.test.shadow;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tencent.shadow.dynamic.host.EnterCallback;
import com.test.constants.Constant;
import com.test.shadow.manager.PluginHelper;

/**
 * SimpleDes:
 * Creator: Sindi
 * Date: 2021-06-21
 * UseDes:
 */
public class MainActivity extends AppCompatActivity {
   private LinearLayout ll;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll = findViewById(R.id.ll);
    }

    public void start_plugin(View view) {
        PluginHelper.getInstance().singlePool.execute(new Runnable() {
            @Override
            public void run() {
                MyApplication.getApp().loadPluginManager(PluginHelper.getInstance().pluginManagerFile);

                /**
                 * @param context context
                 * @param formId  标识本次请求的来源位置，用于区分入口
                 * @param bundle  参数列表, 建议在参数列表加入自己的验证
                 * @param callback 用于从PluginManager实现中返回View
                 */
                Bundle bundle = new Bundle();//插件 zip，这几个参数也都可以不传，直接在 PluginManager 中硬编码
                bundle.putString(Constant.KEY_PLUGIN_ZIP_PATH, PluginHelper.getInstance().pluginZipFile.getAbsolutePath());
                bundle.putString(Constant.KEY_PLUGIN_NAME, Constant.PLUGIN_APP_NAME);// partKey 每个插件都有自己的 partKey 用来区分多个插件，如何配置在下面讲到
                bundle.putString(Constant.KEY_ACTIVITY_CLASSNAME, "com.test.plugin_app.SplashActivity");//要启动的插件的Activity页面
                bundle.putBundle("extra_to_plugin_bundle", new Bundle()); // 要传入到插件里的参数
                MyApplication.getApp().getPluginManager().enter(MainActivity.this, Constant.FROM_ID_START_ACTIVITY, bundle, new EnterCallback() {
                    @Override
                    public void onShowLoadingView(View view) {
                        Log.e("PluginLoad", "onShowLoadingView");
                        loading(view);
                    }

                    @Override
                    public void onCloseLoadingView() {
                        Log.e("PluginLoad", "onCloseLoadingView");
                    }

                    @Override
                    public void onEnterComplete() {
                        // 启动成功
                        Log.e("PluginLoad", "onEnterComplete");
                    }
                });
            }
        });
    }
    private void loading(View view) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                ll.removeAllViews();
                ll.addView(view);
            }
        });
    }
}
