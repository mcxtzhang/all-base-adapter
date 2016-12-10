package mcxtzhang.commonadapter.adapter.base;

import android.view.View;
import android.view.ViewGroup;

/**
 * 介绍：最顶层的Adapter接口
 * 不涉及数据,
 * 对外暴漏 getView 和getCount方法 ，供ViewGroup调用。
 * <p>
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 16/12/10.
 */

public interface IViewGroupAdapter {
    /**
     * ViewGroup调用获取ItemView
     *
     * @param parent
     * @param pos
     * @return
     */
    View getView(ViewGroup parent, int pos);

    /**
     * ViewGroup调用，得到ItemCount
     *
     * @return
     */
    int getCount();
}
