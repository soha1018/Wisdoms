package com.itsoha.wisdom.Base;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.itsoha.wisdom.Activity.MainActivity;
import com.itsoha.wisdom.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * Created by Administrator on 2017/5/6.
 */

public class BasePager {
    public Activity mActivity;
    public FrameLayout fl_pager_content;
    public TextView tv_title;
    public ImageButton btn_ment;
    public View mRootView;

    public BasePager(Activity mActivity) {
        this.mActivity = mActivity;
        mRootView = initView();
    }

    public View initView(){
        View view = View.inflate(mActivity, R.layout.base_pager, null);
        fl_pager_content = (FrameLayout) view.findViewById(R.id.fl_pager_content);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        btn_ment = (ImageButton) view.findViewById(R.id.btn_menu);

        btn_ment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
            }
        });
        return view;
    }

    /**
     * 收起来侧边栏
     */
    private void toggle() {
        MainActivity activity = (MainActivity) mActivity;
        SlidingMenu slidingMenu = activity.getSlidingMenu();
        slidingMenu.toggle();
    }

    public void initData(){};
}
