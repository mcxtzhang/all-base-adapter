package com.mcxtzhang.commonadapter.viewgroup.adapter.cache;

import android.view.View;

/**
 * 介绍：V1.5.0 引入 ViewCache概念
 * 配合ViewCache 存储 ItemViewType 信息
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 2016/12/29.
 */

public class ViewHolder {
    public final View itemView;
    public final int itemViewType;

    public ViewHolder(View itemView, int itemViewType) {
        if (itemView == null) {
            throw new IllegalArgumentException("itemView may not be null");
        }
        this.itemView = itemView;
        this.itemViewType = itemViewType;
    }
}
