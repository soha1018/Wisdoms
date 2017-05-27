package com.itsoha.wisdom.Fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.itsoha.wisdom.Activity.MainActivity;
import com.itsoha.wisdom.Base.Impl.NewsPager;
import com.itsoha.wisdom.Bean.NewsMenu;
import com.itsoha.wisdom.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/5.
 */

public class LeftMenuFragment extends BaseFragment {


    private int currentPosition;
    private ListView lv_left;
    private ArrayList<NewsMenu.NewsMenuData> menuDataArrayList;
    private Myadapter mAdapter;

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_left_menu, null);
        lv_left = (ListView) view.findViewById(R.id.lv_left);
        return view;
    }

    @Override
    public void initData() {

    }

    /**
     * 填充侧边栏
     *
     * @param data
     */
    public void setMenData(ArrayList<NewsMenu.NewsMenuData> data) {
        menuDataArrayList = data;
        mAdapter = new Myadapter();
        lv_left.setAdapter(mAdapter);

        lv_left.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //把当前的条目选中通知适配器更新
                currentPosition = position;
                mAdapter.notifyDataSetChanged();

                //收起来侧边栏
                toggle();
                //设置点击当前界面的详情页面
                setCurrentMenu(position);
            }
        });
    }

    /**
     * 设置点击当前界面的详情页面
     * @param position 条目
     */
    private void setCurrentMenu(int position) {
        //通过MainActivity拿到News的Fragment
        MainActivity activity = (MainActivity) mActivity;
        ContentFragment contentFragment = activity.getContentFragment();
        NewsPager newsFragment = contentFragment.getNewsFragment();
        newsFragment.setCurrentDetailPager(position);
    }

    /**
     * 收起来侧边栏
     */
    private void toggle() {
        MainActivity activity = (MainActivity) mActivity;
        SlidingMenu slidingMenu = activity.getSlidingMenu();
        slidingMenu.toggle();
    }

    /**
     * 新闻侧边栏
     */
    class Myadapter extends BaseAdapter {

        @Override
        public int getCount() {
            return menuDataArrayList.size();
        }

        @Override
        public NewsMenu.NewsMenuData getItem(int position) {
            return menuDataArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(mActivity, R.layout.list_item_left_menu, null);
            TextView tv_menu = (TextView) view.findViewById(R.id.tv_menu);

            tv_menu.setText(getItem(position).title);
            if (position == currentPosition) {
                tv_menu.setEnabled(true);
            } else {
                tv_menu.setEnabled(false);
            }
            return view;
        }
    }
}
