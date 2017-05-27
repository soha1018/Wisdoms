package com.itsoha.wisdom.Base;

import android.app.Activity;
import android.view.View;

/**
 * Created by Administrator on 2017/5/7.
 */

public abstract class BaseMenuDetailPager{
    public Activity mActivity;
    //界面的根布局
    public View rootView;

    public BaseMenuDetailPager(Activity mActivity) {
        this.mActivity = mActivity;
        rootView = initView();
    }

    public abstract View initView();

    public void initData(){};
}
