package com.itsoha.wisdom.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;

import com.itsoha.wisdom.Fragment.ContentFragment;
import com.itsoha.wisdom.Fragment.LeftMenuFragment;
import com.itsoha.wisdom.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

/**
 * 进入主界面
 * Created by Administrator on 2017/4/30.
 */

public class MainActivity extends SlidingFragmentActivity {
    private String TAG_LEFT = "left_menu";
    private String TAG_CONTENT = "tag_content";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题,
        // 必须在setContentView之前调用
        setContentView(R.layout.activity_main);

        //Utils.doSomthing();
        //R.drawable.p_10
        setBehindContentView(R.layout.left_menu);
        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//全屏触摸
        slidingMenu.setBehindOffset(350);//屏幕预留200像素宽度

        //初始化Fragment
        initFragment();
    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.replace(R.id.fl_content,new ContentFragment(),TAG_CONTENT);
        beginTransaction.replace(R.id.fl_left_menu,new LeftMenuFragment(),TAG_LEFT);
        beginTransaction.commit();
    }

    /**
     * 获得侧边栏Fragment的对象
     * @return 返回侧边栏的对象
     */
    public LeftMenuFragment getLeftMenuFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        LeftMenuFragment fragment = (LeftMenuFragment) fragmentManager.findFragmentByTag(TAG_LEFT);

        return fragment;
    }

    /**
     * 获得内容区域
     */
    public ContentFragment getContentFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        ContentFragment fragment = (ContentFragment) fragmentManager.findFragmentByTag(TAG_CONTENT);

        return fragment;
    }
}

