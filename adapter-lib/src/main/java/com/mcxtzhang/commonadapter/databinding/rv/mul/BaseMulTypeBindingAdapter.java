package com.mcxtzhang.commonadapter.databinding.rv.mul;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.ViewGroup;

import com.mcxtzhang.commonadapter.databinding.rv.BaseBindingAdapter;
import com.mcxtzhang.commonadapter.databinding.rv.BaseBindingVH;

import java.util.List;

/**
 * 介绍：多种ItemType的Base类
 * 泛型T:多Item多Bean情况可以不传。如果只有一种Bean类型，可以传入Bean，实现IBaseMulInterface接口。
 * 或者传入IBaseMulInterface接口，可以拿到 getItemLayoutId()，
 * 但是通过getItemViewType(int position)，一样。所以多Item多Bean建议不传。
 * <p>
 * 基类的泛型B：不用传，因为多种ItemType 肯定Layout长得不一样，那么Binding类也不一样，传入没有任何意义
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 时间： 16/09/25.
 */

public class BaseMulTypeBindingAdapter<T extends IBaseMulInterface> extends BaseBindingAdapter<T, ViewDataBinding> {

    public BaseMulTypeBindingAdapter(Context mContext, List<T> mDatas) {
        super(mContext, mDatas);
    }

    @Override
    public int getItemViewType(int position) {
        return mDatas.get(position).getItemLayoutId();
    }

    @Override
    public BaseBindingVH<ViewDataBinding> onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseBindingVH<ViewDataBinding> holder = new BaseBindingVH<ViewDataBinding>(DataBindingUtil.inflate(mInfalter, viewType, parent, false));
        onCreateViewHolder(holder);
        return holder;
    }
}
