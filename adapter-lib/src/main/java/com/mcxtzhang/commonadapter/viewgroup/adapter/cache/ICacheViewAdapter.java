package com.mcxtzhang.commonadapter.viewgroup.adapter.cache;

import android.view.ViewGroup;

/**
 * 介绍：V1.5.0 引入 ViewCache概念
 * ViewCache的接口
 * 1 回收
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 2016/12/29.
 */

public interface ICacheViewAdapter {
    void recycleView(ViewGroup parent, ViewHolder holder);

    void recycleViews(ViewGroup parent);
}
