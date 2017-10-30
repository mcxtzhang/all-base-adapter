package mcxtzhang.commonviewgroupadapter.rv.loadmore;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.mcxtzhang.commonadapter.rv.HeaderFooterAdapter;
import com.mcxtzhang.commonadapter.rv.IHeaderHelper;
import com.mcxtzhang.commonadapter.rv.ViewHolder;

import mcxtzhang.commonviewgroupadapter.R;

/**
 * Intro: 带LoadMore的Adapter
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/24.
 * History:
 */

public class LoadMoreAdapter extends HeaderFooterAdapter {
    public enum State {
        READY, LOADING, ERROR, EMPTY
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }

    State mState;
    OnLoadMoreListener mLoadMoreListener;
    Context mContext;

    public OnLoadMoreListener getLoadMoreListener() {
        return mLoadMoreListener;
    }

    public LoadMoreAdapter setLoadMoreListener(OnLoadMoreListener loadMoreListener) {
        mLoadMoreListener = loadMoreListener;
        return this;
    }

    public LoadMoreAdapter setStateLoading() {
        mState = State.LOADING;
        notifyItemChanged(getItemCount() - 1);
        return this;
    }

    public LoadMoreAdapter setStateReady() {
        mState = State.READY;
        notifyItemChanged(getItemCount() - 1);
        return this;
    }

    public LoadMoreAdapter setStateError() {
        mState = State.ERROR;
        notifyItemChanged(getItemCount() - 1);
        return this;
    }

    public LoadMoreAdapter setStateEmpty() {
        mState = State.EMPTY;
        notifyItemChanged(getItemCount() - 1);
        return this;
    }

    public LoadMoreAdapter(RecyclerView.Adapter mInnerAdapter) {
        super(mInnerAdapter);
        mState = State.READY;
        addFooterView(new IHeaderHelper() {
            @Override
            public int getItemLayoutId() {
                return R.layout.item_cst_loading_more;
            }

            @Override
            public void onBind(ViewHolder holder) {
                Log.d("TAG", "onBind() called with: mState = [" + mState + "]");
                switch (mState) {
                    case READY:
                        mState = State.LOADING;
                        ((LoadMoreView) holder.itemView).setStateReady();
                        notifyItemChanged(getItemCount() - 1);
                        break;
                    case LOADING:
                        ((LoadMoreView) holder.itemView).setStateLoading();
                        notifyLoadMore();
                        break;
                    case ERROR:
                        ((LoadMoreView) holder.itemView).setStateError();
                        holder.itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                notifyLoadMore();
                            }
                        });
                        break;
                    case EMPTY:
                        ((LoadMoreView) holder.itemView).setStateEmpty();
                        break;
                }
                //((AppProgressBar) holder.getView(R.id.loadingView)).startAnimation();
            }
        });
    }

    private void notifyLoadMore() {
        if (null != mLoadMoreListener) {
            mLoadMoreListener.onLoadMore();
        }
    }


}
