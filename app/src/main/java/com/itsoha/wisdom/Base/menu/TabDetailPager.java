package com.itsoha.wisdom.Base.menu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.itsoha.wisdom.Activity.NewsDetailActivity;
import com.itsoha.wisdom.Base.BaseMenuDetailPager;
import com.itsoha.wisdom.Bean.NewsMenu;
import com.itsoha.wisdom.Bean.NewsTabBean;
import com.itsoha.wisdom.R;
import com.itsoha.wisdom.Utils.CacheUtils;
import com.itsoha.wisdom.Utils.Constant;
import com.itsoha.wisdom.Utils.SpUtils;
import com.itsoha.wisdom.View.PullToRefresh;
import com.itsoha.wisdom.View.TopNewsViewPager;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.viewpagerindicator.CirclePageIndicator;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Administrator on 2017/5/10.
 */

public class TabDetailPager extends BaseMenuDetailPager {


    private static final String TAG = "TabDetailPager";
    private final NewsMenu.NewsTabData tabData;
    private TopNewsViewPager vp_table;
    private final String mUrl;
    private List<NewsTabBean.NewsTop> topList;
    private TextView tv_table_title;
    private CirclePageIndicator civ_indicator;
    private PullToRefresh lv_news;
    private List<NewsTabBean.NewsData> mNewsList;
    private String mMoreUrl;
    private TopNewsAdapter newsAdapter;
    private Handler mHandler;

    public TabDetailPager(Activity mActivity, NewsMenu.NewsTabData newsTabData) {
        super(mActivity);
        tabData = newsTabData;
        mUrl = Constant.GET_URL + newsTabData.url;
    }

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.pager_table_detail, null);
        lv_news = (PullToRefresh) view.findViewById(R.id.lv_news);

        //ListView头布局中的内容
        View headerView = View.inflate(mActivity, R.layout.list_item_news_header, null);
        vp_table = (TopNewsViewPager) headerView.findViewById(R.id.vp_table);
        tv_table_title = (TextView) headerView.findViewById(R.id.tv_table_title);
        civ_indicator = (CirclePageIndicator) headerView.findViewById(R.id.civ_indicator);

        lv_news.addHeaderView(headerView);

        //对正在刷新的状态进行监听并且请求网络的数据
        lv_news.setOnRefreshListener(new PullToRefresh.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //刷新中的状态请求网络数据，并告诉ListView刷新完成
                getDataFormService();
            }

            @Override
            public void onLoadMore() {
                //判断加载更多是否有数据
                if (mMoreUrl != null) {
                    //有下一页，去请求数据
                    getMoreData();
                } else {
                    Toast.makeText(mActivity, "没有更多数据了", Toast.LENGTH_SHORT).show();

                    lv_news.onRefreshComplete(false);
                }
            }
        });

        //监听ListView的点击事件，标记已读未读
        lv_news.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //因为添加了两个头布局  需要先减去
                position = position - lv_news.getHeaderViewsCount();

                NewsTabBean.NewsData newsData = mNewsList.get(position);

                //根据Id去标记已读
                String ides = SpUtils.getString(mActivity, Constant.READ_IDES, "");
                //只有不包含当前ID才会添加到里面去
                if (!ides.contains(String.valueOf(newsData.id))){
                    ides = ides + newsData.id + ",";
                    SpUtils.putString(mActivity,Constant.READ_IDES, ides);
                }

                //设置为灰色
                TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
                tv_title.setTextColor(Color.GRAY);

                //跳转到WebView的界面
                Intent intent = new Intent(mActivity, NewsDetailActivity.class);
                intent.putExtra("url",newsData.url);
                mActivity.startActivity(intent);
            }
        });
        return view;
    }

    /**
     * 去请求数据
     */
    private void getMoreData() {
        HttpUtils utils = new HttpUtils();
        utils.send(HttpMethod.GET, mMoreUrl, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                //数据请求成功
                processData(responseInfo.result, true);
                //数据更新完成收起控件
                lv_news.onRefreshComplete(true);
            }

            @Override
            public void onFailure(HttpException e, String s) {
                e.printStackTrace();
                Toast.makeText(mActivity, s, Toast.LENGTH_SHORT).show();

                //数据更新完成收起控件
                lv_news.onRefreshComplete(false);
            }
        });
    }

    @Override
    public void initData() {
        //获得网络来的数据
        String cache = CacheUtils.getCache(mUrl, mActivity);
        if (!TextUtils.isEmpty(cache)) {
            processData(cache, false);
        }
        getDataFormService();

    }

    /**
     * 获得网络来的数据
     */
    private void getDataFormService() {
        HttpUtils utils = new HttpUtils();
        utils.send(HttpMethod.GET, mUrl, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                processData(responseInfo.result, false);

                CacheUtils.putCache(mUrl, responseInfo.result, mActivity);

                //告知ListView收起来刷新的控件
                lv_news.onRefreshComplete(true);
            }

            @Override
            public void onFailure(HttpException error, String msg) {
                error.printStackTrace();
                Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT).show();
                //告知ListView收起来刷新的控件
                lv_news.onRefreshComplete(false);
            }
        });
    }

    /**
     * 解析Json数据
     *
     * @param responseInfo
     * @param isMore       是否有跟多数据
     */
    private void processData(String responseInfo, boolean isMore) {

        Gson gson = new Gson();
        final NewsTabBean newsTabBean = gson.fromJson(responseInfo, NewsTabBean.class);

        //加载更多
        final String more = newsTabBean.data.more;
        if (!TextUtils.isEmpty(more)) {
            mMoreUrl = Constant.GET_URL + more;
        } else {
            mMoreUrl = null;
        }

        if (!isMore) {
            //加载默认的数据
            defaultData(newsTabBean);

            //发送消息循环ViewPager
            if (mHandler == null){
                mHandler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        int currentItem = vp_table.getCurrentItem();
                        currentItem++;

                        if (currentItem > topList.size()-1){
                            currentItem = 0;
                        }
                        vp_table.setCurrentItem(currentItem);

                        mHandler.sendEmptyMessageDelayed(0,3000);
                    }
                };

                mHandler.sendEmptyMessageDelayed(0,3000);

                //监听触摸事件，停止循环
                vp_table.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()){
                            case MotionEvent.ACTION_DOWN:
                                //按下停止循环
                                mHandler.removeCallbacksAndMessages(null);
                                break;
                            case MotionEvent.ACTION_UP:
                                mHandler.sendEmptyMessageDelayed(0,3000);
                                break;
                            case MotionEvent.ACTION_CANCEL:
                                //触摸事件被取消
                                mHandler.sendEmptyMessageDelayed(0,3000);
                                break;
                        }
                        return false;
                    }
                });
            }
        }else {
            //加载更多的数据
            List<NewsTabBean.NewsData> moreList = newsTabBean.data.news;
            //把数据加到集合的最后并通知ListView去更新
            mNewsList.addAll(moreList);

        }
    }

    /**
     * 默认的数据 不需要加载更多
     *
     * @param newsTabBean
     */
    private void defaultData(NewsTabBean newsTabBean) {
        topList = newsTabBean.data.topnews;
        if (topList != null) {
            newsAdapter = new TopNewsAdapter();
            vp_table.setAdapter(newsAdapter);
            civ_indicator.setViewPager(vp_table);
            civ_indicator.setSnap(true);

            civ_indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    tv_table_title.setText(topList.get(position).title);
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });


            //更新第一个头条新闻标题
            tv_table_title.setText(topList.get(0).title);
            //设置回复以后默认的第一个
            civ_indicator.onPageSelected(0);
        }
        mNewsList = newsTabBean.data.news;
        if (mNewsList != null && newsAdapter!=null) {
            NewsAdapter newsAdapter = new NewsAdapter();
            lv_news.setAdapter(newsAdapter);
            newsAdapter.notifyDataSetChanged();
        }
    }

    private class TopNewsAdapter extends PagerAdapter {

        private final BitmapUtils bitmapUtils;

        public TopNewsAdapter() {
            bitmapUtils = new BitmapUtils(mActivity);
            //使用默认的图片
            bitmapUtils.configDefaultLoadingImage(R.mipmap.topnews_item_default);
        }

        @Override
        public int getCount() {
            return topList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(mActivity);
            imageView.setImageResource(R.mipmap.topnews_item_default);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            String image = topList.get(position).topimage;
            String imageUrl = image.replace("10.0.2.2", Constant.LocalHost);
            Log.i(TAG, "instantiateItem详情页的图片: " + imageUrl);
            bitmapUtils.display(imageView, imageUrl);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    private class NewsAdapter extends BaseAdapter {

        private final BitmapUtils bitmapUtils;

        public NewsAdapter() {
            bitmapUtils = new BitmapUtils(mActivity);
            bitmapUtils.configDefaultLoadingImage(R.mipmap.pic_item_list_default);
        }

        @Override
        public int getCount() {
            return mNewsList.size();
        }

        @Override
        public NewsTabBean.NewsData getItem(int position) {
            return mNewsList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = View.inflate(mActivity, R.layout.news_list_item, null);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            NewsTabBean.NewsData newsData = getItem(position);

            viewHolder.tv_title.setText(newsData.title);
            viewHolder.tv_time.setText(newsData.pubdate);
            bitmapUtils.display(viewHolder.iv_image, newsData.listimage);

            //设置已读未读
            String ides = SpUtils.getString(mActivity, Constant.READ_IDES, "");
            if (ides.contains(newsData.id+"")){
                viewHolder.tv_title.setTextColor(Color.GRAY);
            }else {
                viewHolder.tv_title.setTextColor(Color.BLACK);
            }
            return convertView;
        }
    }

    static class ViewHolder {
        View view;
        ImageView iv_image;
        TextView tv_title;
        TextView tv_time;

        ViewHolder(View view) {
            this.view = view;
            this.iv_image = (ImageView) view.findViewById(R.id.iv_image);
            this.tv_title = (TextView) view.findViewById(R.id.tv_title);
            this.tv_time = (TextView) view.findViewById(R.id.tv_time);
        }
    }
}
