package com.mcxtzhang.commonadapter.rv;

import android.support.v7.widget.RecyclerView;

/**
 * 介绍：新HeaderFooter Adapter，优化头部数据绑定 参考DataBinding思想 分离数据绑定 和 View层
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 17/01/08.
 */

public class HeaderFooterAdapter extends HeaderRecyclerAndFooterWrapperAdapter {
    public HeaderFooterAdapter(RecyclerView.Adapter mInnerAdapter) {
        super(mInnerAdapter);
    }

    public void addFooterView(IHeaderHelper headerHelper) {
        mFooterDatas.add(new HeaderData(headerHelper.getItemLayoutId(), headerHelper));
    }

    /**
     * 添加HeaderView
     */
    public void addHeaderView(IHeaderHelper headerHelper) {
        mHeaderDatas.add(new HeaderData(headerHelper.getItemLayoutId(), headerHelper));
    }

    /**
     * 添加HeaderView
     *
     * @param cacheSize 该种headerView在缓存池中的缓存个数
     */
    public void addHeaderView(IHeaderHelper headerHelper, int cacheSize) {
        mHeaderDatas.add(new HeaderData(headerHelper.getItemLayoutId(), headerHelper, cacheSize));
    }

    /**
     * 设置某个位置的HeaderView
     *
     * @param headerPos 从0开始，如果pos过大 就是addHeaderview
     */
    public void setHeaderView(int headerPos, IHeaderHelper headerHelper) {
        if (mHeaderDatas.size() > headerPos) {
            mHeaderDatas.get(headerPos).setLayoutId(headerHelper.getItemLayoutId());
            mHeaderDatas.get(headerPos).setData(headerHelper);
        } else if (mHeaderDatas.size() == headerPos) {//调用addHeaderView
            addHeaderView(headerHelper);
        } else {
            //
            addHeaderView(headerHelper);
        }
    }

    /**
     * 设置某个位置的HeaderView
     *
     * @param headerPos 从0开始，如果pos过大 就是addHeaderview
     * @param cacheSize 该种headerView在缓存池中的缓存个数
     */
    public void setHeaderView(int headerPos, IHeaderHelper headerHelper, int cacheSize) {
        if (mHeaderDatas.size() > headerPos) {
/*            SparseArrayCompat headerContainer = new SparseArrayCompat();
            headerContainer.put(layoutId, data);
            mHeaderDatas.setValueAt(headerPos, headerContainer);*/
            mHeaderDatas.get(headerPos).setLayoutId(headerHelper.getItemLayoutId());
            mHeaderDatas.get(headerPos).setData(headerHelper);
            mHeaderDatas.get(headerPos).setCacheSize(cacheSize);
        } else if (mHeaderDatas.size() == headerPos) {//调用addHeaderView
            addHeaderView(headerHelper, cacheSize);
        } else {
            //
            addHeaderView(headerHelper, cacheSize);
        }
    }


    @Override
    protected void onBindHeaderHolder(ViewHolder holder, int headerPos, int layoutId, Object o) {
        if (o instanceof IHeaderHelper) {
            IHeaderHelper headerHelper = (IHeaderHelper) o;
            headerHelper.onBind(holder);
        }
    }
}
