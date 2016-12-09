package mcxtzhang.commonvgadapter;

import android.view.View;
import android.view.ViewGroup;

/**
 * 介绍：
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 16/12/08.
 */

public class ViewGroupUtils {

    public static void addViews(final ViewGroup viewGroup, BaseVgAdapter adapter, boolean removeViews
            , final OnItemClickListener onItemClickListener
            , final OnItemLongClickListener onItemLongClickListener) {
        if (viewGroup == null || adapter == null) {
            return;
        }
        if (removeViews) {
            viewGroup.removeAllViews();
        }
        int count = adapter.getCount();
        for (int i = 0; i < count; i++) {
            View itemView = adapter.getView(viewGroup, i);
            viewGroup.addView(itemView);
            //添加点击事件
            if (null != onItemClickListener) {
                final int finalI = i;
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemClick(viewGroup, view, finalI);
                    }
                });
            }
            //添加点击事件
            if (null != onItemLongClickListener) {
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

}
