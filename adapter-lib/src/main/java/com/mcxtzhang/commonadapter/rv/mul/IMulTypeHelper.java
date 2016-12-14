package com.mcxtzhang.commonadapter.rv.mul;

import com.mcxtzhang.commonadapter.rv.ViewHolder;

/**
 * 介绍：受DataBinding启发，将数据填充方法挪出来
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 16/12/14.
 */

public interface IMulTypeHelper {

    int getItemLayoutId();

    void onBind(ViewHolder holder);
}
