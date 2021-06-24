package com.test.app_lib.utils

import android.content.Context

/**
 * SimpleDes:
 * Creator: Sindi
 * Date: 2021-06-23
 * UseDes:
 */
class Tools private constructor(private val mContext: Context) {
    val resourcesID: Int
        get() {
            val res = mContext.resources
            return res.getIdentifier("green_7200AF66", "color", mContext.packageName)
        }

    companion object {
        fun cc() {
            println("1234564")
        }

        var instance: Tools? = null
            private set

        @JvmStatic
        fun init(mHostApplicationContext: Context) {
            instance = Tools(mHostApplicationContext)
        }


        //获取插件的数据
        fun getPluginData(callback: ((str:String) -> String)? = null) {
            val str ="123"
            println("获取到插件的数据 ："+callback?.invoke(str))
        }
    }
}