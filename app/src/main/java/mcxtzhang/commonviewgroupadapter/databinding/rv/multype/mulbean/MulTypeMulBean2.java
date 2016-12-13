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

public class MulTypeMulBean2 extends BaseObservable implements IBaseMulInterface {
    private String background;

    public MulTypeMulBean2(String background) {
        this.background = background;
    }

    @Bindable
    public String getBackground() {
        return background;
    }

    public MulTypeMulBean2 setBackground(String background) {
        this.background = background;
        notifyPropertyChanged(BR.background);
        return this;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_db_mulbean_2;
    }
}
