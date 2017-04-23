package com.mcxtzhang.commonadapter.viewgroup.adapter.base;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 介绍：datas->View 的 Base Adapter
 * 整个设计的第二层，这里引入datas，实现IViewGroupAdapter的方法
 * <p>
 * V1.7.0 版本加入，刷新方法 notifyDatasetChanged()
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 16/12/08.
 */

public abstract class BaseAdapter<T> implements IViewGroupAdapter {
    protected List<T> mDatas;
    protected Context mContext;
    protected LayoutInflater mInflater;

    protected DataSetObservable mDataSetObservable;

    public BaseAdapter(Context context, List<T> datas) {
        mDatas = datas;
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mDataSetObservable = new DataSetObservable();
    }

    @Override
    public void notifyDatasetChanged() {
        mDataSetObservable.notifyChanged();
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        mDataSetObservable.registerObserver(dataSetObserver);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        mDataSetObservable.unregisterObserver(dataSetObserver);
    }

    /**
     * ViewGroup调用获取ItemView,create bind一起做
     *
     * @param parent
     * @param pos
     * @return
     */
    @Override
    public View getView(ViewGroup parent, int pos) {
        return getView(parent, pos, mDatas.get(pos));
    }

    /**
     * 实际的createItemView的地方
     *
     * @param parent
     * @param pos
     * @param data
     * @return
     */
    public abstract View getView(ViewGroup parent, int pos, T data);

    /**
     * ViewGroup调用，得到ItemCount
     *
     * @return
     */
    @Override
    public int getCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    public List<T> getDatas() {
        return mDatas;
    }

    public BaseAdapter setDatas(List<T> datas) {
        mDatas = datas;
        return this;
    }
}
