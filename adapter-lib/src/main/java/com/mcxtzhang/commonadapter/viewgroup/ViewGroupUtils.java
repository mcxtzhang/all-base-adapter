package com.mcxtzhang.commonadapter.viewgroup;

import android.view.View;
import android.view.ViewGroup;

import com.mcxtzhang.commonadapter.viewgroup.adapter.base.IViewGroupAdapter;
import com.mcxtzhang.commonadapter.viewgroup.listener.OnItemClickListener;
import com.mcxtzhang.commonadapter.viewgroup.listener.OnItemLongClickListener;

/**
 * 介绍：ViewGroupUtils
 * 为任意ViewGroup 动态addView的工具类，
 * 只依赖于 IViewGroupAdapter 接口
 * <p>
 * 已经废弃，推荐使用{@link VGUtil}
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 16/12/08.
 */
@Deprecated
public class ViewGroupUtils {

    /**
     * 刷新UI
     * 没有点击事件
     * The method is deprecated ,{@link VGUtil}
     *
     * @param viewGroup
     * @param adapter
     */
    @Deprecated
    public static void refreshUI(ViewGroup viewGroup, IViewGroupAdapter adapter) {
        addViews(viewGroup, adapter);
    }

    /**
     * 刷新UI ，和点击事件
     * The method is deprecated ,{@link VGUtil}
     *
     * @param viewGroup
     * @param adapter
     * @param onItemClickListener
     */
    @Deprecated
    public static void refreshUIWithClickListener(ViewGroup viewGroup, IViewGroupAdapter adapter, OnItemClickListener onItemClickListener) {
        addViews(viewGroup, adapter, onItemClickListener);
    }

    /**
     * 刷新UI ，和长按事件
     * The method is deprecated ,{@link VGUtil}
     *
     * @param viewGroup
     * @param adapter
     * @param onItemClickListener
     */
    @Deprecated
    public static void refreshUIWithLongClickListener(ViewGroup viewGroup, IViewGroupAdapter adapter
            , OnItemClickListener onItemClickListener, OnItemLongClickListener onItemLongClickListener) {
        addViews(viewGroup, adapter, true, onItemClickListener, onItemLongClickListener);
    }

    /**
     * 为任意ViewGroup 添加ItemViews.
     * 并且会清除掉之前所有add过的View
     * The method is deprecated ,{@link VGUtil}
     *
     * @param viewGroup 必传
     * @param adapter   必传，至少提供要add的View和需要add的count
     */
    @Deprecated
    public static void addViews(final ViewGroup viewGroup, IViewGroupAdapter adapter) {
        addViews(viewGroup, adapter, true, null, null);
    }

    /**
     * 为任意ViewGroup 添加ItemViews.
     * 并且会清除掉之前所有add过的View
     * The method is deprecated ,{@link VGUtil}
     *
     * @param viewGroup           必传
     * @param adapter             必传，至少提供要add的View和需要add的count
     * @param onItemClickListener Item点击事件
     */
    @Deprecated
    public static void addViews(final ViewGroup viewGroup, IViewGroupAdapter adapter
            , final OnItemClickListener onItemClickListener) {
        addViews(viewGroup, adapter, true, onItemClickListener, null);
    }


    /**
     * 为任意ViewGroup 添加ItemViews.
     * The method is deprecated ,{@link VGUtil}
     *
     * @param viewGroup               必传
     * @param adapter                 必传，至少提供要add的View和需要add的count
     * @param removeViews             是否需要remove掉之前的Views
     * @param onItemClickListener     Item点击事件
     * @param onItemLongClickListener Item长按事件
     */
    @Deprecated
    public static void addViews(final ViewGroup viewGroup, IViewGroupAdapter adapter
            , boolean removeViews
            , final OnItemClickListener onItemClickListener
            , final OnItemLongClickListener onItemLongClickListener) {
        if (viewGroup == null || adapter == null) {
            return;
        }
        //如果需要remove掉之前的Views
        if (removeViews) {
            //viewGroup.removeAllViews();
            adapter.recycleViews(viewGroup);
        }
        //开始添加子Views,通过Adapter获得需要添加的Count
        int count = adapter.getCount();
        for (int i = 0; i < count; i++) {
            //通过Adapter获得ItemView
            View itemView = adapter.getView(viewGroup, i);
            viewGroup.addView(itemView);
            //添加点击事件,itemView之前没有点击事件才会去设置
            if (null != onItemClickListener && !itemView.isClickable()) {
                final int finalI = i;
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemClick(viewGroup, view, finalI);
                    }
                });
            }
            //添加长按事件itemView之前没有长按事件才会去设置
            if (null != onItemLongClickListener && !itemView.isLongClickable()) {
                final int finalI = i;
                itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        return onItemLongClickListener.onItemLongClick(viewGroup, view, finalI);
                    }
                });
            }
        }
    }


    /**
     * 为任意ViewGroup设置OnItemClickListener.
     * 该方法必须在addViews()方法之后调用，否则无效。
     * 因为ItemView 必须被添加在ViewGroup里才能遍历到。
     * 建议直接在addViews()方法里传入OnItemClickListener进行设置，性能更高
     *
     * @param viewGroup
     * @param onItemClickListener
     */
    public static void setOnItemClickListener(final ViewGroup viewGroup, final OnItemClickListener onItemClickListener) {
        if (viewGroup == null || onItemClickListener == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View itemView = viewGroup.getChildAt(i);
            //itemView之前没有点击事件才会去设置
            if (null != itemView && !itemView.isClickable()) {
                final int finalI = i;
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemClick(viewGroup, itemView, finalI);
                    }
                });
            }
        }
    }


    /**
     * 为任意ViewGroup设置OnItemLongClickListener.
     * 该方法必须在addViews()方法之后调用，否则无效。
     * 因为ItemView 必须被添加在ViewGroup里才能遍历到。
     * 建议直接在addViews()方法里传入OnItemLongClickListener进行设置，性能更高
     *
     * @param viewGroup
     * @param onItemLongClickListener
     */
    public static void setOnItemLongClickListener(final ViewGroup viewGroup, final OnItemLongClickListener onItemLongClickListener) {
        if (viewGroup == null || onItemLongClickListener == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View itemView = viewGroup.getChildAt(i);
            //itemView之前没有长按事件才会去设置
            if (null != itemView && !itemView.isLongClickable()) {
                final int finalI = i;
                itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        return onItemLongClickListener.onItemLongClick(viewGroup, itemView, finalI);
                    }
                });
            }
        }
    }

}
