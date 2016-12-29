package com.mcxtzhang.commonadapter.viewgroup.adapter.cache;

/**
 * 介绍：V1.5.0 引入 ViewCache概念
 * <p>
 * <p>
 * <p>
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 2016/12/29.
 */

public interface IViewCache {
    void put(ViewHolder view);

    ViewHolder get(int itemType);

    void setCacheSize(int itemType, int size);

    int getCacheSize(int itemType);
}
