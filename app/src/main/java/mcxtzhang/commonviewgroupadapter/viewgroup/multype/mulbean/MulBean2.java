package mcxtzhang.commonviewgroupadapter.viewgroup.multype.mulbean;

import com.mcxtzhang.commonadapter.viewgroup.adapter.mul.IMulTypeHelper;
import mcxtzhang.commonviewgroupadapter.R;

/**
 * 介绍：
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 16/12/11.
 */

public class MulBean2 implements IMulTypeHelper {
    private String name;

    public MulBean2(String url) {
        this.name = url;
    }

    public String getName() {
        return name;
    }

    public MulBean2 setName(String url) {
        this.name = url;
        return this;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_mulbean_2;
    }
}
