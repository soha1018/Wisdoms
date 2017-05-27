package com.itsoha.wisdom.Fragment;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.itsoha.wisdom.Activity.MainActivity;
import com.itsoha.wisdom.Base.BasePager;
import com.itsoha.wisdom.Base.Impl.GovAffairsPager;
import com.itsoha.wisdom.Base.Impl.HomePager;
import com.itsoha.wisdom.Base.Impl.NewsPager;
import com.itsoha.wisdom.Base.Impl.SettingPager;
import com.itsoha.wisdom.Base.Impl.SmartServicePager;
import com.itsoha.wisdom.R;
import com.itsoha.wisdom.View.NoScrollViewPager;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2017/5/5.
 */

public class ContentFragment extends BaseFragment {

    private NoScrollViewPager vp_content;
    private List<BasePager> pagerList;
    private RadioGroup rg_group;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            pagerList.get(0).initData();
        }
    };

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_content, null);
        vp_content = (NoScrollViewPager) view.findViewById(R.id.vp_content);
        rg_group = (RadioGroup) view.findViewById(R.id.rg_group);

        return view;
    }

    @Override
    public void initData() {


        pagerList = new ArrayList<>();

        pagerList.add(new HomePager(mActivity));
        pagerList.add(new NewsPager(mActivity));
        pagerList.add(new SmartServicePager(mActivity));
        pagerList.add(new GovAffairsPager(mActivity));
        pagerList.add(new SettingPager(mActivity));

        //给ViewPager设置数据
        vp_content.setAdapter(new Myadapter());

        //底部标签切换的监听
        rg_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        vp_content.setCurrentItem(0);
                        break;
                    case R.id.rb_news:
                        vp_content.setCurrentItem(1);
                        break;
                    case R.id.rb_smart:
                        vp_content.setCurrentItem(2);
                        break;
                    case R.id.rb_gvo:
                        vp_content.setCurrentItem(3);
                        break;
                    case R.id.rb_setting:
                        vp_content.setCurrentItem(4);
                        break;
                }
            }
        });

        //选中单个页面在加载数据
        vp_content.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.i(TAG, "onPageSelected: 当前条目"+position);
                BasePager basePager = pagerList.get(position);
                basePager.initData();

                if (position == 0 || position == pagerList.size() - 1){
                    //禁止侧滑
                    setSlidingMenuEnable(true);
                }else {
                    //开启侧滑
                    setSlidingMenuEnable(false);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        rg_group.check(R.id.rb_home);
        setSlidingMenuEnable(true);

    }

    /**
     * 设置侧滑状态
     * @param enable 设置侧滑的状态
     */
    private void setSlidingMenuEnable(boolean enable) {
        MainActivity activity = (MainActivity) mActivity;
        SlidingMenu slidingMenu = activity.getSlidingMenu();
        if (enable){
            //关闭
            slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        }else {
            slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        }
    }

    /**
     * 获得新闻中心界面
     */
    public NewsPager getNewsFragment() {
        NewsPager newsPager = (NewsPager) pagerList.get(1);
        return newsPager;
    }

    private class Myadapter extends PagerAdapter {
        @Override
        public int getCount() {
            return pagerList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager basePager = pagerList.get(position);
            View view = basePager.mRootView;
            Log.i(TAG, "instantiateItem: 当前加载的界面："+position);
            container.addView(view);
            mHandler.sendEmptyMessage(0);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
