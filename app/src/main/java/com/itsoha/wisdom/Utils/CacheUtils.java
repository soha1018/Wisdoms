package com.itsoha.wisdom.Utils;

import android.content.Context;

/**
 * Created by Administrator on 2017/5/7.
 */

public class CacheUtils {
    public static void putCache(String url, String json, Context context){
        SpUtils.putString(context,url,json);
    }

    public static String getCache(String url,Context context){
        return SpUtils.getString(context,url,"");
    }
}
