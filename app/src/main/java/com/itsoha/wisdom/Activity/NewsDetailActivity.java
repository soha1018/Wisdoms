package com.itsoha.wisdom.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.itsoha.wisdom.R;

import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * 菜单详情页
 * Created by Administrator on 2017/5/22.
 */

public class NewsDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "NewsDetailActivity";
    private ImageButton btn_bak;
    private ImageButton btn_text_size;
    private ImageButton btn_share;
    private ProgressBar pb_news_detail;
    private WebView wv_news_detail;
    private ProgressBar pb_detail_horizontal;
    private int mCurrentWhich = 2;
    private int mWhich;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_news_detail);

        initView();
        initData();

    }

    /**
     * 初始化数据
     */
    private void initData() {
        //获取页面的Url
        String mUrl = getIntent().getStringExtra("url");

        //加载页面
        wv_news_detail.loadUrl(mUrl);
//        wv_news_detail.loadUrl("http://www.itheima.com");
        //获取设置
        WebSettings settings = wv_news_detail.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);

        wv_news_detail.setWebViewClient(new WebViewClient(){
            //页面开始加载的时候
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pb_news_detail.setVisibility(View.VISIBLE);
                Log.i(TAG, "onPageStarted: 开始加载");
            }
            //页面加载完成的时候

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pb_news_detail.setVisibility(View.INVISIBLE);
                Log.i(TAG, "onPageFinished: 加载完成");
            }

            //就在本页面中继续加载数据
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

        });

        wv_news_detail.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                pb_detail_horizontal.setProgress(newProgress);
                if (newProgress > 60){
                    pb_detail_horizontal.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                Log.i(TAG, "onReceivedTitle: 网页标题："+title);
            }
        });
    }

    /**
     * 初始化控件
     */
    private void initView() {
        btn_bak = (ImageButton) findViewById(R.id.btn_bak);
        btn_text_size = (ImageButton) findViewById(R.id.btn_text_size);
        btn_share = (ImageButton) findViewById(R.id.btn_share);
        btn_bak.setOnClickListener(this);
        btn_text_size.setOnClickListener(this);
        btn_share.setOnClickListener(this);
        pb_news_detail = (ProgressBar) findViewById(R.id.pb_news_detail);
        pb_detail_horizontal = (ProgressBar) findViewById(R.id.pb_detail_horizontal);
        wv_news_detail = (WebView) findViewById(R.id.wv_news_detail);

        pb_news_detail.setMax(100);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_bak:
                //关闭当前页面
                finish();
                break;
            case R.id.btn_text_size:
                //弹出对话框选择字体大小
                showSingleDialog();
                break;
            case R.id.btn_share:
                //利用分享的开发平台
                showShare();
                break;
        }
    }

    /**
     * 弹出单选对话框的Dialog
     */
    private void showSingleDialog() {
        String[] items = new String[]{"超大号字体","大好字体","正常字体","小号字体","超小号字体"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择字体大小");
        builder.setSingleChoiceItems(items, mCurrentWhich, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mWhich = which;
            }
        });

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                WebSettings settings = wv_news_detail.getSettings();
                switch (mWhich){
                    case 0:
                        settings.setTextSize(WebSettings.TextSize.LARGEST);
                        break;
                    case 1:
                        settings.setTextSize(WebSettings.TextSize.LARGER);
                        break;
                    case 2:
                        settings.setTextSize(WebSettings.TextSize.NORMAL);
                        break;
                    case 3:
                        settings.setTextSize(WebSettings.TextSize.SMALLER);
                        break;
                    case 4:
                        settings.setTextSize(WebSettings.TextSize.SMALLEST);
                        break;
                }
                mCurrentWhich = mWhich;
            }
        });

        builder.setNegativeButton("取消",null);

        builder.show();
    }

    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，印象笔记、邮箱、信息、微信、人人网、QQ和QQ空间使用
        oks.setTitle("智慧北京");
        // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
        oks.setTitleUrl("http://baidu.com");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("这是一款不错的应用");
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://baidu.com");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("这是一款不错的应用");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite("ShareSDK");
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://baidu.com");

// 启动分享GUI
        oks.show(this);
    }
}
