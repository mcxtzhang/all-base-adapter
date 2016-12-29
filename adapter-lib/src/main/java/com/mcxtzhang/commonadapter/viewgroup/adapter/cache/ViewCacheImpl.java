package com.mcxtzhang.commonadapter.viewgroup.adapter.cache;

import android.util.SparseArray;
import android.util.SparseIntArray;

import java.util.ArrayList;

/**
 * 介绍：ViewCache的实现类
 * 以ItemType（即LayoutId）为key，
 * 缓存Views，
 * <p>
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 2016/12/29.
 */

public class ViewCacheImpl implements IViewCache {
    //以ItemType（即LayoutId）为key， 缓存ViewHolders，
    private SparseArray<ArrayList<ViewHolder>> mCachedViews;
    //以ItemType（即LayoutId）为key，存储每种缓存的大小
    private SparseIntArray mCachedSize;

    //默认缓存数量
    private static final int DEFAULT_MAX_SIZE = 5;


    public ViewCacheImpl() {
        mCachedViews = new SparseArray<>();
        mCachedSize = new SparseIntArray();
    }

    @Override
    public void put(ViewHolder holder) {
        ArrayList<ViewHolder> cacheViews = mCachedViews.get(holder.itemViewType);
        if (cacheViews == null) {
            cacheViews = new ArrayList<>();
            mCachedViews.put(holder.itemViewType, cacheViews);
        }
        if (cacheViews.size() < getCacheSize(holder.itemViewType)) {
            cacheViews.add(holder);
        }
    }

    @Override
    public ViewHolder get(int itemType) {
        ArrayList<ViewHolder> cacheViews = mCachedViews.get(itemType);
        if (null == cacheViews || cacheViews.isEmpty()) {
            return null;
        } else {
            return cacheViews.remove(cacheViews.size() - 1);
        }
    }

    @Override
    public void setCacheSize(int itemType, int size) {
        ArrayList<ViewHolder> cacheViews = mCachedViews.get(itemType);
        if (cacheViews != null) {
            while (cacheViews.size() > size) {
                cacheViews.remove(cacheViews.size() - 1);
            }
        }
        mCachedSize.put(itemType, size);
    }

    @Override
    public int getCacheSize(int itemType) {
        int cacheSize = mCachedSize.get(itemType);
        if (cacheSize == 0) {
            return DEFAULT_MAX_SIZE;
        }
        return cacheSize;
    }

}
