package mcxtzhang.commonadapter.adapter.mul;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mcxtzhang.commonadapter.adapter.base.BaseAdapter;

/**
 * 介绍：支持多种布局的Adapter
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 16/12/10.
 */

public abstract class MulTypeAdapter<T extends IMulTypeHelper> extends BaseAdapter<T> {
    public MulTypeAdapter(List<T> datas, Context context) {
        super(datas, context);
    }

    @Override
    public View getView(ViewGroup parent, int pos, T data) {
        View itemView = mInflater.inflate(data.getItemLayoutId(), parent, false);
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
}
