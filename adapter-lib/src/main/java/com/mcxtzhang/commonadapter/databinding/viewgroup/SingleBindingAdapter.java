package com.mcxtzhang.commonadapter.databinding.viewgroup;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.View;
import android.view.ViewGroup;

import com.mcxtzhang.commonadapter.BR;
import com.mcxtzhang.commonadapter.viewgroup.adapter.single.SingleAdapter;

import java.util.List;

/**
 * 介绍：用DataBinding实现的SingleAdapter
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 16/12/13.
 */

public class SingleBindingAdapter<D, B extends ViewDataBinding> extends SingleAdapter<D> {
    //用于设置Item的事件Presenter
    protected Object ItemPresenter;

    public Object getItemPresenter() {
        return ItemPresenter;
    }

    /**
     * 用于设置Item的事件Presenter
     *
     * @param itemPresenter
     * @return
     */
    public SingleBindingAdapter setItemPresenter(Object itemPresenter) {
        ItemPresenter = itemPresenter;
        return this;
    }

    public SingleBindingAdapter(Context context, List<D> datas, int itemLayoutId) {
        super(context, datas, itemLayoutId);
    }

    //重写利用DataBinding做
    @Override
    public View getView(ViewGroup parent, int pos, D data) {
        ViewDataBinding binding = DataBindingUtil.inflate(mInflater, mItemLayoutId, parent, false);
        View itemView = binding.getRoot();
        onBindView(parent, itemView, data, pos);
        binding.setVariable(BR.data, data);
        binding.setVariable(BR.itemP, ItemPresenter);
        return itemView;
    }

    //空实现即可，因为DataBinding的实现都是在xml里做
    @Override
    public void onBindView(ViewGroup parent, View itemView, D data, int pos) {

    }
}
