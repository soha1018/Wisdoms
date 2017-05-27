package com.itsoha.wisdom.Base.Impl;

import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.itsoha.wisdom.Base.BasePager;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2017/5/6.
 */

public class HomePager extends BasePager {
    public HomePager(Activity mActivity) {
        super(mActivity);
    }

    @Override
    public void initData() {
        Log.i(TAG, "initData: 执行了首页的数据");
        TextView textView = new TextView(mActivity);
        textView.setGravity(Gravity.CENTER);
        textView.setText("首页");
        textView.setTextSize(25f);

        tv_title.setText("首页");

        //设置首界面不显示侧滑按钮
        btn_ment.setVisibility(View.INVISIBLE);
        fl_pager_content.addView(textView);
    }
}
