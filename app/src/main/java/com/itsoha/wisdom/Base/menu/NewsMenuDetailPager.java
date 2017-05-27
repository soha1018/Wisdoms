package com.itsoha.wisdom.Base.menu;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.itsoha.wisdom.Activity.MainActivity;
import com.itsoha.wisdom.Base.BaseMenuDetailPager;
import com.itsoha.wisdom.Bean.NewsMenu;
import com.itsoha.wisdom.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单详情页-新闻
 * 
 * @author Kevin
 * @date 2015-10-18
 */
public class NewsMenuDetailPager extends BaseMenuDetailPager {

	private ViewPager vp_news;
	private final ArrayList<NewsMenu.NewsTabData> dataArrayList;
	private List<TabDetailPager> pagerList;
	private TabPageIndicator indicator;

	public NewsMenuDetailPager(Activity activity, ArrayList<NewsMenu.NewsTabData> children) {
		super(activity);
		dataArrayList = children;
	}

	@Override
	public View initView() {
		View view = View.inflate(mActivity, R.layout.pager_news_menu_dedtil, null);
		vp_news = (ViewPager) view.findViewById(R.id.vp_news_menu);
		indicator = (TabPageIndicator) view.findViewById(R.id.indicator);
		ImageButton ben_next = (ImageButton) view.findViewById(R.id.btn_next);

		ben_next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				indicator.setCurrentItem(vp_news.getCurrentItem()+1);
			}
		});

		indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {
				if (position == 0){
					//打开侧滑
					setSlidingMenuEnable(false);
				}else {
					//关闭侧滑
					setSlidingMenuEnable(true);
				}
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});
		return view;
	}

	@Override
	public void initData() {
		pagerList = new ArrayList<>();
		TabDetailPager detailPager;
		for (int i = 0; i < dataArrayList.size(); i++) {
			detailPager = new TabDetailPager(mActivity,dataArrayList.get(i));
			pagerList.add(detailPager);
		}

		//给ViewPager添加数据
		vp_news.setAdapter(new NewsMenuDetailAdapter());
		//给ViewPager设置指示器
		indicator.setViewPager(vp_news);
	}

	class NewsMenuDetailAdapter extends PagerAdapter{
		@Override
		public CharSequence getPageTitle(int position) {
			return dataArrayList.get(position).title;
		}

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
			TabDetailPager detailPager = pagerList.get(position);
			View view = detailPager.rootView;
			detailPager.initData();
			container.addView(view);
			return view;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
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

}
