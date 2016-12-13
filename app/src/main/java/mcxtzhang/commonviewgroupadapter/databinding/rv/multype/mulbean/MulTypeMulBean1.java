package mcxtzhang.commonviewgroupadapter.databinding.rv.multype.mulbean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.mcxtzhang.commonadapter.databinding.rv.mul.IBaseMulInterface;

import mcxtzhang.commonviewgroupadapter.BR;
import mcxtzhang.commonviewgroupadapter.R;

/**
 * 介绍：
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 2016/12/13.
 */

public class MulTypeMulBean1 extends BaseObservable implements IBaseMulInterface {
    private String avatar;
    private String name;

    public MulTypeMulBean1(String avatar, String name) {
        this.avatar = avatar;
        this.name = name;
    }

    @Bindable
    public String getAvatar() {
        return avatar;
    }

    public MulTypeMulBean1 setAvatar(String avatar) {
        this.avatar = avatar;
        notifyPropertyChanged(BR.avatar);
        return this;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public MulTypeMulBean1 setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
        return this;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_db_mulbean_1;
    }
}
