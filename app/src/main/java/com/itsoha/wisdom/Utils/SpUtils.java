package com.itsoha.wisdom.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 轻量级存放记录的类
 * Created by Administrator on 2017/4/30.
 */

public class SpUtils {
    public static void putBoolean(Context context,String key,boolean values){
        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        sp.edit().putBoolean(key,values).commit();
    }

    public static boolean getBoolean(Context context,String key,boolean values){
        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getBoolean(key,values);
    }

    public static void putString(Context context,String key,String values){
        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        sp.edit().putString(key,values).commit();
    }

    public static String getString(Context context,String key,String values){
        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getString(key,values);
    }
}
