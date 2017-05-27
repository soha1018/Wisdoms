package com.itsoha.wisdom.Base.Impl;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.itsoha.wisdom.Activity.MainActivity;
import com.itsoha.wisdom.Base.BaseMenuDetailPager;
import com.itsoha.wisdom.Base.BasePager;
import com.itsoha.wisdom.Base.menu.InteractMenuDetailPager;
import com.itsoha.wisdom.Base.menu.NewsMenuDetailPager;
import com.itsoha.wisdom.Base.menu.PhotosMenuDetailPager;
import com.itsoha.wisdom.Base.menu.TopicMenuDetailPager;
import com.itsoha.wisdom.Bean.NewsMenu;
import com.itsoha.wisdom.Fragment.LeftMenuFragment;
import com.itsoha.wisdom.Utils.CacheUtils;
import com.itsoha.wisdom.Utils.Constant;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;


import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * 新闻中心的界面
 * Created by Administrator on 2017/5/6.
 */

public class NewsPager extends BasePager {

    private List<BaseMenuDetailPager> menuDetailList;
    private NewsMenu newsMenu;

    public NewsPager(Activity mActivity) {
        super(mActivity);
    }

    @Override
    public void initData() {

        btn_ment.setVisibility(View.VISIBLE);

        //判断是否有缓存提前加载
        String cache = CacheUtils.getCache(Constant.GETGORY_URL, mActivity);
        if (!TextUtils.isEmpty(cache)) {
            //加载缓存
            processData(cache);
            Log.i(TAG, "initData: 加载缓存");
        }
        //获取网络的数据
        getDataFormService();

    }

    /**
     * 获取网络的数据
     */
    private void getDataFormService() {
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(HttpMethod.GET, Constant.GETGORY_URL, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                //请求成功
                String result = responseInfo.result;
                Log.i(TAG, "onSuccess: " + result);
                //对请求到的数据进行解析
                processData(result);
                //把数据缓存起来
                CacheUtils.putCache(Constant.GETGORY_URL, result, mActivity);
            }

            @Override
            public void onFailure(HttpException e, String s) {
                //请求失败
                e.printStackTrace();
                Toast.makeText(mActivity, s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 对请求到的数据进行解析
     *
     * @param result json数据
     */
    private void processData(String result) {
        Gson gson = new Gson();
        newsMenu = gson.fromJson(result, NewsMenu.class);
        Log.i(TAG, "processData: " + newsMenu.data.get(0));

        //填充侧边栏
        MainActivity activity = (MainActivity) mActivity;
        LeftMenuFragment menuFragment = activity.getLeftMenuFragment();
        menuFragment.setMenData(newsMenu.data);

        //初始化四个菜单详情页
        menuDetailList = new ArrayList<>();
        menuDetailList.add(new NewsMenuDetailPager(mActivity, newsMenu.data.get(0).children));
        menuDetailList.add(new TopicMenuDetailPager(mActivity));
        menuDetailList.add(new PhotosMenuDetailPager(mActivity));
        menuDetailList.add(new InteractMenuDetailPager(mActivity));

        setCurrentDetailPager(0);
    }

    /**
     * 设置新闻中心详情页面
     *
     * @param position 当前的条目
     */
    public void setCurrentDetailPager(int position) {
        BaseMenuDetailPager pager = menuDetailList.get(position);
        //获得每个界面的根布局
        View rootView = pager.rootView;

        //再添加新界面之前先清楚以前的界面
        fl_pager_content.removeAllViews();
        fl_pager_content.addView(rootView);

        pager.initData();

        //设置标题
        tv_title.setText(newsMenu.data.get(position).title);
    }
}
