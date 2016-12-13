package com.mcxtzhang.commonadapter.databinding.viewgroup;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.View;
import android.view.ViewGroup;

import com.mcxtzhang.commonadapter.BR;
import com.mcxtzhang.commonadapter.viewgroup.adapter.mul.IMulTypeHelper;

import java.util.List;

/**
 * 介绍：用DataBinding实现的MulTypeAdapter
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 16/12/13.
 */

public class MulTypeBindngAdapter<T extends IMulTypeHelper> extends SingleBindingAdapter<T, ViewDataBinding> {

    public MulTypeBindngAdapter(Context context, List<T> datas) {
        super(context, datas, -1);
    }

    //重写利用DataBinding做
    @Override
    public View getView(ViewGroup parent, int pos, T data) {
        ViewDataBinding binding = DataBindingUtil.inflate(mInflater, data.getItemLayoutId(), parent, false);
        View itemView = binding.getRoot();
        onBindView(parent, itemView, data, pos);
        binding.setVariable(BR.data, data);
        binding.setVariable(BR.itemP, ItemPresenter);
        return itemView;
    }
}
