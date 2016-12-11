package com.mcxtzhang.commonadapter.adapter.single;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mcxtzhang.commonadapter.adapter.base.BaseAdapter;

import java.util.List;

/**
 * 介绍：一个简化的Adapter
 * 只支持单种Item
 * 用LayoutId 构建View
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 16/12/10.
 */

public abstract class SingleAdapter<T> extends BaseAdapter<T> {

    private int mItemLayoutId;

    public SingleAdapter(Context context, List<T> datas, int itemLayoutId) {
        super(context, datas);
        mItemLayoutId = itemLayoutId;
    }

    @Override
    public View getView(ViewGroup parent, int pos, T data) {
        //实现getView
        View itemView = /*onCreateView(parent, pos)*/mInflater.inflate(mItemLayoutId, parent, false);
        onBindView(parent, itemView, data, pos);
        return itemView;
    }

    /**
     * 暴漏这个 让外部bind数据
     *
     * @param parent
     * @param itemView
     * @param data
     * @param pos
     */
    public abstract void onBindView(ViewGroup parent, View itemView, T data, int pos);

/*    *//**
     * 通过ItemLayoutId inflate View
     *
     * @param parent
     * @param pos
     * @return
     *//*
    public View onCreateView(ViewGroup parent, int pos) {
        return createItemView(parent, pos);
    }

    public View createItemView(ViewGroup parent, int pos) {
        return mInflater.inflate(mItemLayoutId, parent, false);
    }*/
}
