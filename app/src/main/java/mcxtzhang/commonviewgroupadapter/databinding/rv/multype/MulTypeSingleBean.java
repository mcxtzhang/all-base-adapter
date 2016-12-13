package mcxtzhang.commonviewgroupadapter.databinding.rv.multype;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.mcxtzhang.commonadapter.databinding.rv.mul.IBaseMulInterface;

import mcxtzhang.commonviewgroupadapter.R;
import mcxtzhang.commonviewgroupadapter.BR;

/**
 * 介绍：多种type单数据结构Bean
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 2016/12/13.
 */

public class MulTypeSingleBean extends BaseObservable implements IBaseMulInterface {
    private String avatar;
    private String name;
    private boolean receive;

    public MulTypeSingleBean(String avatar, String name) {
        this.avatar = avatar;
        this.name = name;
    }

    @Bindable
    public boolean isReceive() {
        return receive;
    }

    public MulTypeSingleBean setReceive(boolean receive) {
        this.receive = receive;
        notifyPropertyChanged(BR.receive);
        return this;
    }

    @Bindable
    public String getAvatar() {
        return avatar;
    }

    public MulTypeSingleBean setAvatar(String avatar) {
        this.avatar = avatar;
        notifyPropertyChanged(BR.avatar);
        return this;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public MulTypeSingleBean setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
        return this;
    }

    @Override
    public int getItemLayoutId() {
        if (isReceive()) {
            return R.layout.item_db_mul_1;
        } else {
            return R.layout.item_db_mul_2;
        }
    }
}
