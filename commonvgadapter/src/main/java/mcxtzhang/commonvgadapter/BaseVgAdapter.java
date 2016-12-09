package mcxtzhang.commonvgadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 介绍：datas->View 的 BaseAdapter
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 16/12/08.
 */

public abstract class BaseVgAdapter<T> {
    protected List<T> mDatas;
    protected Context mContext;
    protected LayoutInflater mInflater;

    public BaseVgAdapter(List<T> datas, Context context) {
        mDatas = datas;
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    /**
     * ViewGroup调用获取ItemView,create bind一起做
     *
     * @param parent
     * @param pos
     * @return
     */
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
    public int getCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    public List<T> getDatas() {
        return mDatas;
    }

    public BaseVgAdapter setDatas(List<T> datas) {
        mDatas = datas;
        return this;
    }
}
