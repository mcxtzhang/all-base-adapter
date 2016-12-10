package mcxtzhang.commonviewgroupadapter;

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
}
