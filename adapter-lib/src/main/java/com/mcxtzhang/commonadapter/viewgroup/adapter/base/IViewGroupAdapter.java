package com.mcxtzhang.commonadapter.viewgroup.adapter.base;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

import com.mcxtzhang.commonadapter.viewgroup.adapter.cache.ICacheViewAdapter;

/**
 * 介绍：最顶层的Adapter接口
 * 不涉及数据,
 * 对外暴漏 getView 和getCount方法 ，供ViewGroup调用。
 * <p>
 * 根据迪米特法则（最少知道原则）,
 * 我们应该抽象出一个顶层的接口，对ViewGroup暴露出最少的方法供使用。
 * 我们想一下，对于ViewGroup，它最少只需要哪些就能完成我们的需求。
 * ChildView是什么---> View
 * 有多少ChildView 需要 添加--->count
 * <p>
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 16/12/10.
 */

public interface IViewGroupAdapter extends ICacheViewAdapter {
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

    /**
     * 用户调用，刷新ViewGroup界面
     */
    void notifyDatasetChanged();

    void registerDataSetObserver(DataSetObserver dataSetObserver);

    void unregisterDataSetObserver(DataSetObserver dataSetObserver);
}
