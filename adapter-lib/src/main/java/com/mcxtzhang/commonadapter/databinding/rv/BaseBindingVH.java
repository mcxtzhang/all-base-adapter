package com.mcxtzhang.commonadapter.databinding.rv;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * 介绍：使用DataBinding ，告别ViewHolder
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 16/09/25.
 */

public class BaseBindingVH<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    protected final T mBinding;

    public BaseBindingVH(T t) {
        super(t.getRoot());
        mBinding = t;
    }

    public T getBinding() {
        return mBinding;
    }
}
