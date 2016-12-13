package mcxtzhang.commonviewgroupadapter.databinding.rv.single;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import mcxtzhang.commonviewgroupadapter.BR;


/**
 * 介绍：
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 2016/12/13.
 */

public class DBSingleBean extends BaseObservable {
    private String avatar;
    private String name;

    public DBSingleBean(String avatar, String name) {
        this.avatar = avatar;
        this.name = name;
    }

    @Bindable
    public String getAvatar() {
        return avatar;
    }

    public DBSingleBean setAvatar(String avatar) {
        this.avatar = avatar;
        notifyPropertyChanged(BR.avatar);
        return this;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public DBSingleBean setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
        return this;
    }
}
