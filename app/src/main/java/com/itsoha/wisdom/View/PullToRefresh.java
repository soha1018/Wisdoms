package com.itsoha.wisdom.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.itsoha.wisdom.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/17.
 */

public class PullToRefresh extends ListView implements AbsListView.OnScrollListener {

    private View pullView;
    private int mHeight;
    private int startY = -1;
    private int currentStatus = STATE_PULL_REFRESH;
    //正在刷新时
    private static final int STATE_REFRESHING = 1;
    //下拉刷新的状态
    private static final int STATE_PULL_REFRESH = 2;
    //刷新完成
    private static final int STATE_REFRESH_FINISH = 3;
    private TextView tv_pull_title;
    private TextView tv_pull_time;
    private ImageView iv_pull;
    private ProgressBar pb_pull;
    private RotateAnimation pullAnimation;
    private RotateAnimation finishAnimation;
    private OnRefreshListener refreshListener;
    private View footerView;
    private int footerHeight;
    private boolean isLoadMore;

    public PullToRefresh(Context context) {
        super(context);
        initPullRefresh();
        initAnimation();
        initFooter();
    }

    public PullToRefresh(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPullRefresh();
        initAnimation();
        initFooter();

    }

    public PullToRefresh(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPullRefresh();
        initAnimation();
        initFooter();

    }

    /**
     * 初始化动画
     */
    private void initAnimation() {
        finishAnimation = new RotateAnimation(0, -180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        finishAnimation.setDuration(400);
        finishAnimation.setFillAfter(true);

        pullAnimation = new RotateAnimation(-180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        finishAnimation.setDuration(400);
        finishAnimation.setFillAfter(true);
    }

    /**
     * 加载更多界面
     */
    private void initFooter() {
        footerView = View.inflate(getContext(), R.layout.view_pull_refresh_footer, null);
        //添加到ListView的脚布局
        addFooterView(footerView);
        //手动测量宽高,并隐藏控件
        footerView.measure(0,0);
        footerHeight = footerView.getMeasuredHeight();
        footerView.setPadding(0,-footerHeight,0,0);

        this.setOnScrollListener(this);
    }

    /**
     * 初始化下拉刷新的菜单
     */
    public void initPullRefresh() {
        pullView = View.inflate(getContext(), R.layout.view_pull_refresh_head, null);
        tv_pull_title = (TextView) pullView.findViewById(R.id.tv_pull_title);
        tv_pull_time = (TextView) pullView.findViewById(R.id.tv_pull_time);
        iv_pull = (ImageView) pullView.findViewById(R.id.iv_pull);
        pb_pull = (ProgressBar) pullView.findViewById(R.id.pb_pull);
        addHeaderView(pullView);
        //手动测量视图的高度
        pullView.measure(0, 0);
        mHeight = pullView.getMeasuredHeight();
        pullView.setPadding(0, -mHeight, 0, 0);

        setTime();
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startY = (int) ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                //对按下的位置做健壮性判断
                if (startY == -1) {
                    startY = (int) ev.getY();
                }
                int endY = (int) ev.getY();
                int dy = endY - startY;

                //正在刷新中跳出循环
                if (currentStatus == STATE_REFRESHING){
                    break;
                }
                //判读是否是第一个条目且是否是向下刷新
                int position = getFirstVisiblePosition();
                if (dy > 0 && position == 0) {
                    int padding = dy - mHeight;
                    pullView.setPadding(0, padding, 0, 0);
                    //下拉刷新的状态
                    if (padding > 0 && currentStatus != STATE_REFRESH_FINISH){
                        //改为松开刷新
                        currentStatus = STATE_REFRESH_FINISH;
                        refreshState();
                    }else if (padding < 0 && currentStatus != STATE_PULL_REFRESH){
                        //改为下拉刷新
                        currentStatus = STATE_PULL_REFRESH;
                        refreshState();
                    }
                        //消费此事件
                        return true;
                }
                break;
            case MotionEvent.ACTION_UP:
                startY = -1;

                if (currentStatus == STATE_REFRESH_FINISH){
                    //松手以后把松开刷新改成正在刷新中
                    currentStatus = STATE_REFRESHING;
                    pullView.setPadding(0,0,0,0);

                    //通知接口内的方法正在刷新
                    if (refreshListener!=null){
                        refreshListener.onRefresh();
                    }
                }else if (currentStatus == STATE_PULL_REFRESH){
                    //隐藏头布局
                    pullView.setPadding(0,-mHeight,0,0);
                }
                refreshState();
                break;
        }
        return super.onTouchEvent(ev);
    }

    private void refreshState() {
        switch (currentStatus){
            case STATE_REFRESH_FINISH:
                tv_pull_title.setText("松开刷新");
                iv_pull.startAnimation(finishAnimation);
                iv_pull.setVisibility(VISIBLE);
                pb_pull.setVisibility(INVISIBLE);

                break;
            case STATE_PULL_REFRESH:
                tv_pull_title.setText("下拉刷新");
                iv_pull.startAnimation(pullAnimation);
                iv_pull.setVisibility(VISIBLE);
                pb_pull.setVisibility(INVISIBLE);
                break;
            case STATE_REFRESHING:
                //清除动画,否则不能隐藏
                iv_pull.clearAnimation();

                tv_pull_title.setText("正在刷新中");
                pb_pull.setVisibility(VISIBLE);
                iv_pull.setVisibility(INVISIBLE);
                break;
        }
    }

    /**
     * 设置对正在刷新状态的监听
     * @param listener 刷新中的回调接口
     */
    public void setOnRefreshListener(OnRefreshListener listener){
        refreshListener = listener;
    }

    /**
     * 刷新结束收起来控件
     * @param success
     */
    public void onRefreshComplete(boolean success) {
        if (!isLoadMore){
            pullView.setPadding(0,-mHeight,0,0);

            //把当前的状态设置为下拉刷新，不然重复下拉没效果
            currentStatus = STATE_PULL_REFRESH;
            tv_pull_title.setText("下拉刷新");
            iv_pull.startAnimation(pullAnimation);
            iv_pull.setVisibility(VISIBLE);
            pb_pull.setVisibility(INVISIBLE);

            if (success){
                //成功以后设置刷新时间
                setTime();
            }
        }else {
            //收起来加载更多
            footerView.setPadding(0,-footerHeight,0,0);

            isLoadMore = false;
        }


    }

    /**
     * 设置当前时间
     */
    private void setTime() {
        SimpleDateFormat dateFormat = (SimpleDateFormat) SimpleDateFormat.getDateInstance();
        dateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(new Date());

        tv_pull_time.setText(format);
    }

    /**
     * 滑动状态发生变态
     * @param view
     * @param scrollState
     */
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        //滑动是空闲状态且是最后一个条目就加载更多控件
        if (scrollState == SCROLL_STATE_IDLE){
            int position = getLastVisiblePosition();
            if (position == getCount()-1 && !isLoadMore){
                //加载更多
                //当前的状态是在加载更多
                isLoadMore = true;
                //将ListView设置在最后一个条目，直接就会加载更多
                setSelection(getCount()-1);
                //显示加载更多
                footerView.setPadding(0,0,0,0);

                //通知主界面加载更多数据
                if (refreshListener!=null){
                    refreshListener.onLoadMore();
                }
            }
        }
    }

    /**
     * 滑动状态回调
     * @param view
     * @param firstVisibleItem
     * @param visibleItemCount
     * @param totalItemCount
     */
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

    //定义一个接口
    public interface OnRefreshListener{
        public void onRefresh();
        public void onLoadMore();
    }
}
