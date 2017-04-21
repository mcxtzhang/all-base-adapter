package com.mcxtzhang.commonadapter.rv.mul;

import android.content.Context;
import android.view.ViewGroup;

import com.mcxtzhang.commonadapter.rv.CommonAdapter;
import com.mcxtzhang.commonadapter.rv.ViewHolder;

import java.util.List;

/**
 * 介绍：
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 16/12/14.
 */

public class BaseMulTypeAdapter<T extends IMulTypeHelper> extends CommonAdapter<T> {


    public BaseMulTypeAdapter(Context context, List<T> datas) {
        super(context, datas, -1);
    }

    @Override
    public int getItemViewType(int position) {
        if (mDatas != null && !mDatas.isEmpty()) {
            return mDatas.get(position).getItemLayoutId();
        }
        return super.getItemViewType(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //add by zhangxutong 2016 08 05 begin ,for 点击事件为了兼容HeaderView FooterView 的Adapter
        if (null == mRv) {
            mRv = parent;
        }
        //add by zhangxutong 2016 08 05 end ,for 点击事件为了兼容HeaderView FooterView 的Adapter
        return ViewHolder.get(mContext, parent, viewType);
    }

    @Override
    public void convert(ViewHolder holder, T t) {
        t.onBind(holder);
    }
}
