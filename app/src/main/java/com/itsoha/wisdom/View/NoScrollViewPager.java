package com.itsoha.wisdom.View;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 自定义ViewPager禁止滚动事件
 * Created by Administrator on 2017/5/6.
 */

public class NoScrollViewPager extends ViewPager {
    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //已经消费了此事件
        return true;
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        //不拦截子控件的触摸事件
        return false;
    }
}
