package com.itsoha.wisdom.Bean;

import java.util.List;

/**
 * 组图的对象
 * Created by Administrator on 2017/5/22.
 */

public class PhotosBean {

    /**
     * data : {"countcommenturl":"http://zhbj.qianlong.com/client/content/countComment/","more":"http://zhbj.qianlong.com/static/api/news/10003/list_2.json","news":[{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/72/82772/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/82772","id":82772,"largeimage":"http://zhbj.qianlong.com/static/images/2014/11/07/70/476518773M7R.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/46728356JDGO.jpg","pubdate":"2014-11-07 11:40","smallimage":"http://zhbj.qianlong.com/static/images/2014/11/07/79/485753989TVL.jpg","title":"鍖椾含路APEC缁氫附涔嬪","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/11/07/7743665E4E6B10766F26.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/90/79290/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/79290","id":79290,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/24/76/47651877XMO1.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/46728356H323.jpg","pubdate":"2014-10-24 14:40","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/24/53/48575398C8VT.jpg","title":"甯︿綘鐪嬩笘鐣屽悇鍦扮殑鍘ㄦ埧","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/24/764D6655416111796B20.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/63/79263/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/79263","id":79263,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/24/23/47651877KIJC.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/46728356PMQ6.jpg","pubdate":"2014-10-24 13:57","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/24/68/48575398CSR8.jpg","title":"鍝ヤ鸡姣斾簹鈥滈粦瓒呬繚闀栤\u20ac濈偧鎴愯","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/24/754E6D5E4E6E197E672F.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/83/78883/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/78883","id":78883,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/23/0/153729125094E2.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/153821477101GE.jpg","pubdate":"2014-10-23 10:57","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/23/10/1540061813Y71H.jpg","title":"涓浗鏂伴椈濂栭儴鍒嗙収鐗囨璧�","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/23/704B695B406A1C756921.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/92/78592/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/78592","id":78592,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/22/55/1649960812RQFY.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/1651807854W6KO.jpg","pubdate":"2014-10-22 14:04","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/22/46/1650884333ZVHP.jpg","title":"褰辫鍓у悇鐗堚\u20ac滄鍒欏ぉ鈥漃K","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/22/72496D5F4F681D75672E.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/75/77775/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/77775","id":77775,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/20/51/1505891536XYLA.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/5000725356GRE.jpg","pubdate":"2014-10-20 09:25","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/20/31/1485574074U25I.jpg","title":"绉戞妧鑼冨効锛佷鸡鏁︽柊鍦伴搧浼煎畤瀹欓鑸�","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/20/714A6F52496C197F6B25.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/96/77596/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/77596","id":77596,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/17/29/1655501938PR0X.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/1656425459S7CD.jpg","pubdate":"2014-10-17 21:09","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/17/41/165734898034KA.jpg","title":"鐪嬩功鐨勫鍥戒汉涓庣帺鎵嬫満鐨勪腑鍥戒汉","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/17/714A675A486F1F77672A.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/99/77099/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/77099","id":77099,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/16/62/47651877483X.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/46728356SFJE.jpg","pubdate":"2014-10-16 11:05","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/16/51/485753981NU5.jpg","title":"鏈\u20ac缇庡叕璺� 闅句互鎯宠薄","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/16/764D6855406219716C2E.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/20/76920/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/76920","id":76920,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/15/75/1678589963DWQY.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/1679513484QXOC.jpg","pubdate":"2014-10-15 21:08","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/15/42/16804370051MYP.jpg","title":"杩介鏆寸殑浜猴細涓堝か涓哄瀛愭媿椋庢毚鍐欑湡","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/15/72496B574D661D7E6922.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/09/76909/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/76909","id":76909,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/15/66/15917789896YFY.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/1571461527JCBR.jpg","pubdate":"2014-10-15 19:25","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/15/93/1592702510DM5B.jpg","title":"涓栫晫绮鏃ワ細楗ラタ鐨勫▉鑳�","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/15/72496D514D661071682A.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/55/76755/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/76755","id":76755,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/15/94/4765187717OI.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/46728356I1TZ.jpg","pubdate":"2014-10-15 13:13","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/15/6/485753986PLS.jpg","title":"绌胯鍦ㄥ湴閾�","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/15/754E69554D681A7E6A24.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/50/76750/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/76750","id":76750,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/15/32/47651877XKBO.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/4672835675CV.jpg","pubdate":"2014-10-15 12:54","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/15/12/48575398U11O.jpg","title":"鎺㈢鏈濋矞楂樹附鑸┖","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/15/714A6D514F6A1F7B6922.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/70/75170/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/75170","id":75170,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/09/29/16231787037271.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/1159137654MWR8.jpg","pubdate":"2014-10-09 20:05","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/09/13/1622255182BIT1.jpg","title":"钀屽憜浜嗭紒姹槦浜烘姳鐜╁伓閰ｇ潯","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/09/704B68574063197F6E25.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/66/74766/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/74766","id":74766,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/08/1/47651877DPOH.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/46728356PCLM.jpg","pubdate":"2014-10-08 15:24","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/08/18/4857539813M1.jpg","title":"鐜悆灏忓绱犻鎺掔粌鐓�","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/08/774C6E504C691D7A6D20.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/92/74292/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/74292","id":74292,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/03/80/1536367729LR1Y.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/444689448KDQ5.jpg","pubdate":"2014-10-03 10:40","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/03/35/15354442085DEE.jpg","title":"鈥�90鍚庘\u20ac濆浗鏃楁墜鏄浣曠偧鎴愮殑","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/03/774C6C524F6F1D756C25.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/81/74181/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/74181","id":74181,"largeimage":"http://zhbj.qianlong.com/static/images/2014/09/30/55/2076222180RTEM.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/308245KDDV.jpg","pubdate":"2014-09-30 16:32","smallimage":"http://zhbj.qianlong.com/static/images/2014/09/30/84/207529865969U2.jpg","title":"鍖椾含涓\u20ac瀹朵汉鐨�20骞村浘鐗囪蹇�","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/09/30/72496A5441621F766B21.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/48/73148/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/73148","id":73148,"largeimage":"http://zhbj.qianlong.com/static/images/2014/09/26/32/1599167157WN8T.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/160009067810KV.jpg","pubdate":"2014-09-26 13:52","smallimage":"http://zhbj.qianlong.com/static/images/2014/09/26/55/16204081400J1C.jpg","title":"鍒姈锛佸叏鐞冭浜鸿吙杞殑鏅尯闃舵","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/09/26/72496D5440631B7E682B.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/51/72851/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/72851","id":72851,"largeimage":"http://zhbj.qianlong.com/static/images/2014/09/25/57/476518775JAU.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/46728356GW3I.jpg","pubdate":"2014-09-25 14:49","smallimage":"http://zhbj.qianlong.com/static/images/2014/09/25/1/48575398JZCR.jpg","title":"鍘熸眮鍘熷懗鐨勫寳浜汉","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/09/25/704B6B534F65197D6B21.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/14/71414/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/71414","id":71414,"largeimage":"http://zhbj.qianlong.com/static/images/2014/09/20/47/16231787033RH7.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/115913765474ZV.jpg","pubdate":"2014-09-20 11:49","smallimage":"http://zhbj.qianlong.com/static/images/2014/09/20/56/1622255182UXNV.jpg","title":"閫冭劚澶у笀鎴愬姛鎸戞垬鐧剧背楂樼┖<鏋侀檺閫冪敓>","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/09/20/774C6B5041671D7D6A25.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/66/69866/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/69866","id":69866,"largeimage":"http://zhbj.qianlong.com/static/images/2014/09/15/64/47651877KF8W.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/46728356YLZ2.jpg","pubdate":"2014-09-15 11:26","smallimage":"http://zhbj.qianlong.com/static/images/2014/09/15/25/485753981N83.jpg","title":"鍗楀畞鐗硅涓婚娴锋姤 鐐技澶х墖","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/09/15/764C6F5C4862187F6825.html"}],"title":"缁勫浘","topic":[]}
     * retcode : 200
     */

    private DataBean data;
    private int retcode;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getRetcode() {
        return retcode;
    }

    public void setRetcode(int retcode) {
        this.retcode = retcode;
    }

    public static class DataBean {
        /**
         * countcommenturl : http://zhbj.qianlong.com/client/content/countComment/
         * more : http://zhbj.qianlong.com/static/api/news/10003/list_2.json
         * news : [{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/72/82772/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/82772","id":82772,"largeimage":"http://zhbj.qianlong.com/static/images/2014/11/07/70/476518773M7R.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/46728356JDGO.jpg","pubdate":"2014-11-07 11:40","smallimage":"http://zhbj.qianlong.com/static/images/2014/11/07/79/485753989TVL.jpg","title":"鍖椾含路APEC缁氫附涔嬪","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/11/07/7743665E4E6B10766F26.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/90/79290/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/79290","id":79290,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/24/76/47651877XMO1.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/46728356H323.jpg","pubdate":"2014-10-24 14:40","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/24/53/48575398C8VT.jpg","title":"甯︿綘鐪嬩笘鐣屽悇鍦扮殑鍘ㄦ埧","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/24/764D6655416111796B20.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/63/79263/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/79263","id":79263,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/24/23/47651877KIJC.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/46728356PMQ6.jpg","pubdate":"2014-10-24 13:57","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/24/68/48575398CSR8.jpg","title":"鍝ヤ鸡姣斾簹鈥滈粦瓒呬繚闀栤\u20ac濈偧鎴愯","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/24/754E6D5E4E6E197E672F.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/83/78883/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/78883","id":78883,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/23/0/153729125094E2.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/153821477101GE.jpg","pubdate":"2014-10-23 10:57","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/23/10/1540061813Y71H.jpg","title":"涓浗鏂伴椈濂栭儴鍒嗙収鐗囨璧�","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/23/704B695B406A1C756921.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/92/78592/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/78592","id":78592,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/22/55/1649960812RQFY.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/1651807854W6KO.jpg","pubdate":"2014-10-22 14:04","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/22/46/1650884333ZVHP.jpg","title":"褰辫鍓у悇鐗堚\u20ac滄鍒欏ぉ鈥漃K","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/22/72496D5F4F681D75672E.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/75/77775/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/77775","id":77775,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/20/51/1505891536XYLA.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/5000725356GRE.jpg","pubdate":"2014-10-20 09:25","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/20/31/1485574074U25I.jpg","title":"绉戞妧鑼冨効锛佷鸡鏁︽柊鍦伴搧浼煎畤瀹欓鑸�","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/20/714A6F52496C197F6B25.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/96/77596/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/77596","id":77596,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/17/29/1655501938PR0X.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/1656425459S7CD.jpg","pubdate":"2014-10-17 21:09","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/17/41/165734898034KA.jpg","title":"鐪嬩功鐨勫鍥戒汉涓庣帺鎵嬫満鐨勪腑鍥戒汉","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/17/714A675A486F1F77672A.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/99/77099/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/77099","id":77099,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/16/62/47651877483X.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/46728356SFJE.jpg","pubdate":"2014-10-16 11:05","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/16/51/485753981NU5.jpg","title":"鏈\u20ac缇庡叕璺� 闅句互鎯宠薄","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/16/764D6855406219716C2E.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/20/76920/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/76920","id":76920,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/15/75/1678589963DWQY.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/1679513484QXOC.jpg","pubdate":"2014-10-15 21:08","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/15/42/16804370051MYP.jpg","title":"杩介鏆寸殑浜猴細涓堝か涓哄瀛愭媿椋庢毚鍐欑湡","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/15/72496B574D661D7E6922.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/09/76909/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/76909","id":76909,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/15/66/15917789896YFY.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/1571461527JCBR.jpg","pubdate":"2014-10-15 19:25","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/15/93/1592702510DM5B.jpg","title":"涓栫晫绮鏃ワ細楗ラタ鐨勫▉鑳�","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/15/72496D514D661071682A.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/55/76755/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/76755","id":76755,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/15/94/4765187717OI.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/46728356I1TZ.jpg","pubdate":"2014-10-15 13:13","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/15/6/485753986PLS.jpg","title":"绌胯鍦ㄥ湴閾�","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/15/754E69554D681A7E6A24.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/50/76750/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/76750","id":76750,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/15/32/47651877XKBO.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/4672835675CV.jpg","pubdate":"2014-10-15 12:54","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/15/12/48575398U11O.jpg","title":"鎺㈢鏈濋矞楂樹附鑸┖","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/15/714A6D514F6A1F7B6922.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/70/75170/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/75170","id":75170,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/09/29/16231787037271.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/1159137654MWR8.jpg","pubdate":"2014-10-09 20:05","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/09/13/1622255182BIT1.jpg","title":"钀屽憜浜嗭紒姹槦浜烘姳鐜╁伓閰ｇ潯","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/09/704B68574063197F6E25.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/66/74766/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/74766","id":74766,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/08/1/47651877DPOH.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/46728356PCLM.jpg","pubdate":"2014-10-08 15:24","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/08/18/4857539813M1.jpg","title":"鐜悆灏忓绱犻鎺掔粌鐓�","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/08/774C6E504C691D7A6D20.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/92/74292/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/74292","id":74292,"largeimage":"http://zhbj.qianlong.com/static/images/2014/10/03/80/1536367729LR1Y.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/444689448KDQ5.jpg","pubdate":"2014-10-03 10:40","smallimage":"http://zhbj.qianlong.com/static/images/2014/10/03/35/15354442085DEE.jpg","title":"鈥�90鍚庘\u20ac濆浗鏃楁墜鏄浣曠偧鎴愮殑","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/10/03/774C6C524F6F1D756C25.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/81/74181/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/74181","id":74181,"largeimage":"http://zhbj.qianlong.com/static/images/2014/09/30/55/2076222180RTEM.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/308245KDDV.jpg","pubdate":"2014-09-30 16:32","smallimage":"http://zhbj.qianlong.com/static/images/2014/09/30/84/207529865969U2.jpg","title":"鍖椾含涓\u20ac瀹朵汉鐨�20骞村浘鐗囪蹇�","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/09/30/72496A5441621F766B21.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/48/73148/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/73148","id":73148,"largeimage":"http://zhbj.qianlong.com/static/images/2014/09/26/32/1599167157WN8T.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/160009067810KV.jpg","pubdate":"2014-09-26 13:52","smallimage":"http://zhbj.qianlong.com/static/images/2014/09/26/55/16204081400J1C.jpg","title":"鍒姈锛佸叏鐞冭浜鸿吙杞殑鏅尯闃舵","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/09/26/72496D5440631B7E682B.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/51/72851/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/72851","id":72851,"largeimage":"http://zhbj.qianlong.com/static/images/2014/09/25/57/476518775JAU.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/46728356GW3I.jpg","pubdate":"2014-09-25 14:49","smallimage":"http://zhbj.qianlong.com/static/images/2014/09/25/1/48575398JZCR.jpg","title":"鍘熸眮鍘熷懗鐨勫寳浜汉","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/09/25/704B6B534F65197D6B21.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/14/71414/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/71414","id":71414,"largeimage":"http://zhbj.qianlong.com/static/images/2014/09/20/47/16231787033RH7.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/115913765474ZV.jpg","pubdate":"2014-09-20 11:49","smallimage":"http://zhbj.qianlong.com/static/images/2014/09/20/56/1622255182UXNV.jpg","title":"閫冭劚澶у笀鎴愬姛鎸戞垬鐧剧背楂樼┖<鏋侀檺閫冪敓>","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/09/20/774C6B5041671D7D6A25.html"},{"comment":true,"commentlist":"http://zhbj.qianlong.com/static/api/news/10003/66/69866/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/69866","id":69866,"largeimage":"http://zhbj.qianlong.com/static/images/2014/09/15/64/47651877KF8W.jpg","listimage":"http://10.0.2.2:8080/zhbj/photos/images/46728356YLZ2.jpg","pubdate":"2014-09-15 11:26","smallimage":"http://zhbj.qianlong.com/static/images/2014/09/15/25/485753981N83.jpg","title":"鍗楀畞鐗硅涓婚娴锋姤 鐐技澶х墖","type":"news","url":"http://zhbj.qianlong.com/static/html/2014/09/15/764C6F5C4862187F6825.html"}]
         * title : 缁勫浘
         * topic : []
         */

        private String countcommenturl;
        private String more;
        private String title;
        private List<NewsBean> news;
        private List<?> topic;

        public String getCountcommenturl() {
            return countcommenturl;
        }

        public void setCountcommenturl(String countcommenturl) {
            this.countcommenturl = countcommenturl;
        }

        public String getMore() {
            return more;
        }

        public void setMore(String more) {
            this.more = more;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<NewsBean> getNews() {
            return news;
        }

        public void setNews(List<NewsBean> news) {
            this.news = news;
        }

        public List<?> getTopic() {
            return topic;
        }

        public void setTopic(List<?> topic) {
            this.topic = topic;
        }

        public static class NewsBean {
            /**
             * comment : true
             * commentlist : http://zhbj.qianlong.com/static/api/news/10003/72/82772/comment_1.json
             * commenturl : http://zhbj.qianlong.com/client/user/newComment/82772
             * id : 82772
             * largeimage : http://zhbj.qianlong.com/static/images/2014/11/07/70/476518773M7R.jpg
             * listimage : http://10.0.2.2:8080/zhbj/photos/images/46728356JDGO.jpg
             * pubdate : 2014-11-07 11:40
             * smallimage : http://zhbj.qianlong.com/static/images/2014/11/07/79/485753989TVL.jpg
             * title : 鍖椾含路APEC缁氫附涔嬪
             * type : news
             * url : http://zhbj.qianlong.com/static/html/2014/11/07/7743665E4E6B10766F26.html
             */

            private boolean comment;
            private String commentlist;
            private String commenturl;
            private int id;
            private String largeimage;
            private String listimage;
            private String pubdate;
            private String smallimage;
            private String title;
            private String type;
            private String url;

            public boolean isComment() {
                return comment;
            }

            public void setComment(boolean comment) {
                this.comment = comment;
            }

            public String getCommentlist() {
                return commentlist;
            }

            public void setCommentlist(String commentlist) {
                this.commentlist = commentlist;
            }

            public String getCommenturl() {
                return commenturl;
            }

            public void setCommenturl(String commenturl) {
                this.commenturl = commenturl;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLargeimage() {
                return largeimage;
            }

            public void setLargeimage(String largeimage) {
                this.largeimage = largeimage;
            }

            public String getListimage() {
                return listimage;
            }

            public void setListimage(String listimage) {
                this.listimage = listimage;
            }

            public String getPubdate() {
                return pubdate;
            }

            public void setPubdate(String pubdate) {
                this.pubdate = pubdate;
            }

            public String getSmallimage() {
                return smallimage;
            }

            public void setSmallimage(String smallimage) {
                this.smallimage = smallimage;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
