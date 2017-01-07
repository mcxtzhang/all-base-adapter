package mcxtzhang.commonviewgroupadapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 介绍：
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 16/12/10.
 */

public class TestBean {
    private String avatar;
    private String name;

    public TestBean(String avatar, String name) {
        this.avatar = avatar;
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public TestBean setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getName() {
        return name;
    }

    public TestBean setName(String name) {
        this.name = name;
        return this;
    }

    public static List<TestBean> initDatas() {
        List<TestBean> datas = new ArrayList<>();
        datas.add(new TestBean("http://imgs.ebrun.com/resources/2016_03/2016_03_25/201603259771458878793312_origin.jpg", "张"));
        datas.add(new TestBean("http://p14.go007.com/2014_11_02_05/a03541088cce31b8_1.jpg", "旭童"));
        datas.add(new TestBean("http://news.k618.cn/tech/201604/W020160407281077548026.jpg", "多种type"));
        datas.add(new TestBean("http://www.kejik.com/image/1460343965520.jpg", "多种type"));
        datas.add(new TestBean("http://cn.chinadaily.com.cn/img/attachement/jpg/site1/20160318/eca86bd77be61855f1b81c.jpg", "多种type"));
        datas.add(new TestBean("http://imgs.ebrun.com/resources/2016_04/2016_04_12/201604124411460430531500.jpg", "多种type"));
        datas.add(new TestBean("http://imgs.ebrun.com/resources/2016_04/2016_04_24/201604244971461460826484_origin.jpeg", "多种type"));
        datas.add(new TestBean("http://www.lnmoto.cn/bbs/data/attachment/forum/201408/12/074018gshshia3is1cw3sg.jpg", "多种type"));
        return datas;
    }
}
