package com.itsoha.wisdom.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/10.
 */

public class NewsTabBean {
    public NewsTab data;
    public String retcode;

    public class NewsTab {
        public String more;
        public List<NewsData> news;
        public List<NewsTopIc> topic;
        public List<NewsTop> topnews;
    }


    public class NewsData {
        public String comment;
        public String commentlist;
        public String commenturl;
        public int id;
        public String listimage;
        public String pubdate;
        public String title;
        public String type;
        public String url;
    }

    public class NewsTopIc {
        public String description;
        public int id;
        public int sort;
        public String title;
        public String listimage;
        public String url;
    }

    public class NewsTop {
        public String comment;
        public String commentlist;
        public String commenturl;
        public int id;
        public String pubdate;
        public String title;
        public String topimage;
        public String type;
        public String url;
    }
}
