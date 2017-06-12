package com.mcxtzhang.commonadapter.viewgroup;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

import com.mcxtzhang.commonadapter.viewgroup.adapter.base.IViewGroupAdapter;
import com.mcxtzhang.commonadapter.viewgroup.listener.OnItemClickListener;
import com.mcxtzhang.commonadapter.viewgroup.listener.OnItemLongClickListener;

/**
 * Intro       A util to add views for any viewgroup.
 * Author      zhangxutong
 * E-mail      mcxtzhang@163.com
 * Home Page   http://blog.csdn.net/zxt0601
 * Created     2017/1/13.
 * Since       1.5.2
 * History
 */
public class VGUtil {
    ViewGroup mParent;
    IViewGroupAdapter mAdapter;

    DataSetObserver mDataSetObserver = new DataSetObserver() {
        @Override
        public void onChanged() {
            refreshUI();
        }

        @Override
        public void onInvalidated() {
        }
    };

    boolean mRemainExistViews;

    OnItemClickListener mOnItemClickListener;
    OnItemLongClickListener mOnItemLongClickListener;

    public static class Builder {
        private ViewGroup mParent;
        private IViewGroupAdapter mAdapter;
        private boolean mRemainExistViews;
        private OnItemClickListener mOnItemClickListener;
        private OnItemLongClickListener mOnItemLongClickListener;

        public Builder setParent(ViewGroup parent) {
            mParent = parent;
            return this;
        }

        public Builder setAdapter(IViewGroupAdapter adapter) {
            mAdapter = adapter;
            return this;
        }

        public Builder setRemainExistViews(boolean remainExistViews) {
            mRemainExistViews = remainExistViews;
            return this;
        }

        public Builder setOnItemClickListener(OnItemClickListener onItemClickListener) {
            mOnItemClickListener = onItemClickListener;
            return this;
        }

        public Builder setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
            mOnItemLongClickListener = onItemLongClickListener;
            return this;
        }

        public VGUtil build() {
            return new VGUtil(mParent, mAdapter, mRemainExistViews, mOnItemClickListener, mOnItemLongClickListener);
        }


    }


    public VGUtil(ViewGroup parent, IViewGroupAdapter adapter) {
        this(parent, adapter, false);
    }

    public VGUtil(ViewGroup parent, IViewGroupAdapter adapter, boolean remainExistViews) {
        this(parent, adapter, remainExistViews, null, null);
    }

    public VGUtil(ViewGroup parent, IViewGroupAdapter adapter, OnItemClickListener onItemClickListener) {
        this(parent, adapter, false, onItemClickListener, null);
    }

    public VGUtil(ViewGroup parent, IViewGroupAdapter adapter, OnItemLongClickListener onItemLongClickListener) {
        this(parent, adapter, false, null, onItemLongClickListener);
    }

    public VGUtil(ViewGroup parent, IViewGroupAdapter adapter, boolean remainExistViews, OnItemClickListener onItemClickListener, OnItemLongClickListener onItemLongClickListener) {
        if (parent == null || adapter == null) {
            throw new IllegalArgumentException("ViewGroup or Adapter can't be null! ");
        }
        if (mAdapter != null) {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
        }
        mParent = parent;
        mAdapter = adapter;
        mAdapter.registerDataSetObserver(mDataSetObserver);
        mRemainExistViews = remainExistViews;
        mOnItemClickListener = onItemClickListener;
        mOnItemLongClickListener = onItemLongClickListener;
    }

    /**
     * Begin bind views for {@link #mParent}
     */
    public VGUtil bind() {
        return bind(false);
    }

    /**
     * Refresh ui for {@link #mParent}.
     * This method will reset {@link OnItemClickListener} and {@link OnItemLongClickListener}
     *
     * @return
     */
    public VGUtil refreshUI() {
        return bind(true);
    }

    private VGUtil bind(boolean refresh) {
        if (mParent == null || mAdapter == null) {
            return this;
        }
        //Step 1
        //If need clear all existed views
        if (!mRemainExistViews) {
            mAdapter.recycleViews(mParent);
        }
        //Step 2, begin add views
        int count = mAdapter.getCount();
        for (int i = 0; i < count; i++) {
            //Get itemView by adapter
            View itemView = mAdapter.getView(mParent, i);
            mParent.addView(itemView);

            //Step 3 (Optional),
            //If item has not set click listener before, add click listener for each item.
            //If in refresh , reset click listener
            if (null != mOnItemClickListener && (!itemView.isClickable() || refresh)) {
                final int finalI = i;
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mOnItemClickListener.onItemClick(mParent, view, finalI);
                    }
                });
            }
            //If item has not set long click listener before, add long click listener for each item.
            if (null != mOnItemLongClickListener && (!itemView.isLongClickable() || refresh)) {
                final int finalI = i;
                itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        return mOnItemLongClickListener.onItemLongClick(mParent, view, finalI);
                    }
                });
            }
        }
        return this;
    }
}
