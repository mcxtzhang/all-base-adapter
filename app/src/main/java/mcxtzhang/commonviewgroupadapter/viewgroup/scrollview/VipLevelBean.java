package mcxtzhang.commonviewgroupadapter.viewgroup.scrollview;

import com.mcxtzhang.commonadapter.viewgroup.adapter.mul.IMulTypeHelper;
import mcxtzhang.commonviewgroupadapter.R;

/**
 * 介绍：
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * CSDN：http://blog.csdn.net/zxt0601
 * 时间： 16/12/08.
 */

public class VipLevelBean implements IMulTypeHelper {
    private int level;
    private int levelValue;
    private boolean isCurrent;

    public VipLevelBean(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public VipLevelBean setLevel(int level) {
        this.level = level;
        return this;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public VipLevelBean setCurrent(boolean current) {
        isCurrent = current;
        return this;
    }

    public int getLevelValue() {
        return levelValue;
    }

    public VipLevelBean setLevelValue(int levelValue) {
        this.levelValue = levelValue;
        return this;
    }

    @Override
    public int getItemLayoutId() {
        if (isCurrent()) {
            return R.layout.item_current;
        } else {
            return R.layout.item_normal;
        }
    }
}
