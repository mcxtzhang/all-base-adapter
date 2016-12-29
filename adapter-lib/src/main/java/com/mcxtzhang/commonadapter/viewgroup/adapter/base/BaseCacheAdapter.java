package com.mcxtzhang.commonadapter.viewgroup.adapter.base;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.mcxtzhang.commonadapter.R;
import com.mcxtzhang.commonadapter.viewgroup.adapter.cache.IViewCache;
import com.mcxtzhang.commonadapter.viewgroup.adapter.cache.ViewCacheImpl;
import com.mcxtzhang.commonadapter.viewgroup.adapter.cache.ViewHolder;

import java.util.List;

/**
 * 介绍：V1.5.0 引入 ViewCache概念
 * 一个带缓存的基类
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 2016/12/29.
 */

public abstract class BaseCacheAdapter<T> extends BaseAdapter<T> {
    protected IViewCache mViewCache;

    public BaseCacheAdapter(Context context, List datas) {
        super(context, datas);
        mViewCache = new ViewCacheImpl();
    }


    /**
     * 不必关心从缓存取 还是inflate
     *
     * @param parent
     * @param layoutId
     * @return
     */
    public View getViewByType(ViewGroup parent, int layoutId) {
        ViewHolder holder = mViewCache.get(layoutId);
        if (holder == null) {
            Log.d("TAG", "创建");
            View inflate = mInflater.inflate(layoutId, parent, false);
            ViewHolder holder2 = new ViewHolder(inflate, layoutId);
            inflate.setTag(R.id.zxt_tag_vh,holder2);
            return inflate;
        }
        Log.d("TAG", "复用");
        return holder.itemView;
    }

    /**
     * 回收这个View
     *
     * @param parent
     */
    @Override
    public void recycleView(ViewGroup parent, ViewHolder holder) {
        parent.removeView(holder.itemView);
        mViewCache.put(holder);
    }


}
