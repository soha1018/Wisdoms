package com.itsoha.wisdom.Bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/7.
 */

public class NewsMenu {
    public String retcode;

    public ArrayList<Integer> extend;

    public ArrayList<NewsMenuData> data;


    public class NewsMenuData {
        public int id;
        public String title;
        public int type;

        public ArrayList<NewsTabData> children;
    }

    public class NewsTabData {
        public int id;
        public String title;
        public int type;
        public String url;
    }
}
