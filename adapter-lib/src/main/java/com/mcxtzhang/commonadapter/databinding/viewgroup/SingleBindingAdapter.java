package com.mcxtzhang.commonadapter.databinding.viewgroup;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.mcxtzhang.commonadapter.BR;
import com.mcxtzhang.commonadapter.R;
import com.mcxtzhang.commonadapter.viewgroup.adapter.cache.ViewHolder;
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

    /**
     * 不必关心从缓存取 还是inflate
     *
     * @param parent
     * @param layoutId
     * @return
     */
    @Override
    public ViewHolder getViewHolderByType(ViewGroup parent, int layoutId) {
        ViewHolder holder = mViewCache.get(layoutId);
        if (holder == null) {
            Log.d("TAG", "创建");
            ViewDataBinding binding = DataBindingUtil.inflate(mInflater, layoutId, parent, false);
            View itemView = binding.getRoot();
            ViewHolder holder2 = new ViewHolder(itemView, layoutId);
            itemView.setTag(R.id.zxt_tag_vh, holder2);
            itemView.setTag(R.id.zxt_tag_vdb, binding);
            return holder2;
        }
        Log.d("TAG", "复用");
        return holder;
    }

    //重写利用DataBinding做
    @Override
    public View getView(ViewGroup parent, int pos, D data) {
        ViewHolder holder = getViewHolderByType(parent, mItemLayoutId);
        ViewDataBinding binding = (ViewDataBinding) holder.itemView.getTag(R.id.zxt_tag_vdb);
        onBindViewHolder(parent, holder, data, pos);
        binding.setVariable(BR.data, data);
        binding.setVariable(BR.itemP, ItemPresenter);
        return holder.itemView;
    }

    //空实现即可，因为DataBinding的实现都是在xml里做
    @Override
    public void onBindViewHolder(ViewGroup parent, ViewHolder holder, D data, int pos) {

    }


}
