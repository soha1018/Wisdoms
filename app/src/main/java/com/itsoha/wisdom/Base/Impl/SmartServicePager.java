package com.itsoha.wisdom.Base.Impl;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.itsoha.wisdom.Base.BasePager;

/**
 * Created by Administrator on 2017/5/6.
 */

public class SmartServicePager extends BasePager {
    public SmartServicePager(Activity mActivity) {
        super(mActivity);
    }

    @Override
    public void initData() {
        TextView textView = new TextView(mActivity);
        textView.setGravity(Gravity.CENTER);
        textView.setText("智慧服务");
        textView.setTextSize(25f);

        tv_title.setText("智慧服务");
        btn_ment.setVisibility(View.VISIBLE);

        fl_pager_content.addView(textView);
    }
}
