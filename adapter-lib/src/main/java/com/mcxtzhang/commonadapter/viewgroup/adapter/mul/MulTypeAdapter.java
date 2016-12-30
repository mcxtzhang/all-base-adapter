package com.mcxtzhang.commonadapter.viewgroup.adapter.mul;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mcxtzhang.commonadapter.viewgroup.adapter.cache.BaseCacheAdapter;
import com.mcxtzhang.commonadapter.viewgroup.adapter.cache.ViewHolder;

import java.util.List;

/**
 * 介绍：支持多种布局的Adapter
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 16/12/10.
 */

public abstract class MulTypeAdapter<T extends IMulTypeHelper> extends BaseCacheAdapter<T> {
    public MulTypeAdapter(Context context, List<T> datas) {
        super(context, datas);
    }

    @Override
    public View getView(ViewGroup parent, int pos, T data) {
        ViewHolder holder = /*mInflater.inflate(data.getItemLayoutId(), parent, false)*/getViewHolderByType(parent, data.getItemLayoutId());
        onBindViewHolder(parent, holder, data, pos);
        return holder.itemView;
    }

    /**
     * 暴漏这个 让外部bind数据
     *
     * @param parent
     * @param holder
     * @param data
     * @param pos
     */
    public abstract void onBindViewHolder(ViewGroup parent, ViewHolder holder, T data, int pos);
}
