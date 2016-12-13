package mcxtzhang.commonviewgroupadapter.databinding.viewgroup;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import mcxtzhang.commonviewgroupadapter.BR;


/**
 * 介绍：
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 16/12/11.
 */

public class FlowBean extends BaseObservable {
    private String tag;

    @Bindable
    public String getTag() {
        return tag;
    }

    public FlowBean setTag(String tag) {
        this.tag = tag;
        notifyPropertyChanged(BR.tag);
        return this;
    }

    public FlowBean(String tag) {
        this.tag = tag;
    }
}
