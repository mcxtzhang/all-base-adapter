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

public class MulBean1 implements IMulTypeHelper {
    private String url;

    public MulBean1(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public MulBean1 setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_mulbean_1;
    }
}
