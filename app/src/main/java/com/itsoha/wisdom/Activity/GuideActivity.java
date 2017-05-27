package com.itsoha.wisdom.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.itsoha.wisdom.R;
import com.itsoha.wisdom.Utils.Constant;
import com.itsoha.wisdom.Utils.SpUtils;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * 引导界面
 * Created by Administrator on 2017/4/30.
 */

public class GuideActivity extends Activity implements View.OnClickListener {
    private ViewPager vp_guide;
    /**
     * 开始体验
     */
    private Button bt_start;
    private LinearLayout layout_point;
    private int[] mImage = new int[]{R.mipmap.guide_1,R.mipmap.guide_2,R.mipmap.guide_3};
    private List<ImageView> mList;
    private int leftPoint;
    private ImageView iv_red;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        //初始化控件
        initView();
        //初始化数据
        initData();
        //初始化适配器
        initAdapter();

    }

    /**
     * 初始化适配器
     */
    private void initAdapter() {
        GuideAdapter guideAdapter = new GuideAdapter();
        vp_guide.setAdapter(guideAdapter);

        vp_guide.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //当前小红点间距乘以偏移百分比
                float v = leftPoint * positionOffset + position * leftPoint;

                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) iv_red.getLayoutParams();
                layoutParams.leftMargin = (int) v;

                iv_red.setLayoutParams(layoutParams);

            }

            @Override
            public void onPageSelected(int position) {

                if (position == mList.size() - 1){
                    bt_start.setVisibility(View.VISIBLE);
                }else {
                    bt_start.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        final ViewTreeObserver treeObserver = layout_point.getViewTreeObserver();
        treeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                layout_point.getViewTreeObserver().removeGlobalOnLayoutListener(this);

                //第二个点和第一个的偏移
                leftPoint = layout_point.getChildAt(1).getLeft() - layout_point.getChildAt(0).getLeft();
                Log.i(TAG, "onGlobalLayout: "+leftPoint);
            }
        });
    }

    /**
     * 初始化数据
     */
    private void initData() {
        ImageView imageView ;
        LinearLayout.LayoutParams layoutParams ;
        mList = new ArrayList<>();
        for (int i = 0; i < mImage.length; i++) {
            imageView = new ImageView(this);
            imageView.setBackgroundResource(mImage[i]);
//            imageView.setImageResource();
            mList.add(imageView);

            imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.shape_point_gray);
            layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            if (i > 0){
                layoutParams.leftMargin = 10;
            }
            layout_point.addView(imageView,layoutParams);
        }
    }

    /**
     * 初始化控件
     */
    private void initView() {
        vp_guide = (ViewPager) findViewById(R.id.vp_guide);
        bt_start = (Button) findViewById(R.id.bt_start);
        bt_start.setOnClickListener(this);
        layout_point = (LinearLayout) findViewById(R.id.layout_point);
        iv_red = (ImageView) findViewById(R.id.iv_red);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_start:
                //告知已经第一次开启过引导界面
                SpUtils.putBoolean(getApplicationContext(), Constant.IS_FIRST_ENTER,false);
                //点击体验按钮
                startActivity(new Intent(getApplicationContext(),MainActivity.class));

                finish();
                break;
        }
    }

    private class GuideAdapter extends PagerAdapter{
        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView view = mList.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
