package mcxtzhang.commonviewgroupadapter.viewgroup.multype;

import com.mcxtzhang.commonadapter.viewgroup.adapter.mul.IMulTypeHelper;

import mcxtzhang.commonviewgroupadapter.R;

/**
 * 介绍：
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 16/12/11.
 */

public class MulTypeBean implements IMulTypeHelper {
    private String avatar;
    private String name;
    private boolean receive;

    public MulTypeBean(String avatar, String name) {
        this.avatar = avatar;
        this.name = name;
    }

    public boolean isReceive() {
        return receive;
    }

    public MulTypeBean setReceive(boolean receive) {
        this.receive = receive;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public MulTypeBean setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getName() {
        return name;
    }

    public MulTypeBean setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public int getItemLayoutId() {
        if (isReceive()) {
            return R.layout.item_mul_1;
        } else {
            return R.layout.item_mul_2;
        }
    }
}
