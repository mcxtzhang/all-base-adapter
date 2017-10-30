package mcxtzhang.commonviewgroupadapter.rv.loadmore;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.mcxtzhang.commonadapter.rv.HeaderAndFooterWrapperAdapter;

/**
 * Intro: 带LoadMore的Adapter
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/24.
 * History:
 */

public class LoadMoreAdapter2 extends HeaderAndFooterWrapperAdapter {
    public enum State {
        READY, LOADING, ERROR, EMPTY
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }

    State mState;
    OnLoadMoreListener mLoadMoreListener;
    Context mContext;
    LoadMoreView mLoadMoreView;

    public OnLoadMoreListener getLoadMoreListener() {
        return mLoadMoreListener;
    }

    public LoadMoreAdapter2 setLoadMoreListener(OnLoadMoreListener loadMoreListener) {
        mLoadMoreListener = loadMoreListener;
        return this;
    }

    public LoadMoreAdapter2 setStateLoading() {
        mState = State.LOADING;
        mLoadMoreView.setStateLoading();
        return this;
    }

    public LoadMoreAdapter2 setStateReady() {
        mState = State.READY;
        mLoadMoreView.setStateReady();
        return this;
    }

    public LoadMoreAdapter2 setStateError() {
        mState = State.ERROR;
        mLoadMoreView.setStateError();
        return this;
    }

    public LoadMoreAdapter2 setStateEmpty() {
        mState = State.EMPTY;
        mLoadMoreView.setStateEmpty();
        return this;
    }

    public LoadMoreAdapter2(Context context, RecyclerView.Adapter mInnerAdapter) {
        super(mInnerAdapter);
        mLoadMoreView = new LoadMoreView(context);
        addFooterView(mLoadMoreView);
        mState = State.READY;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        if (isFooterViewPos(position)) {
            Log.d("TAG", "onBind() called with: mState = [" + mState + "]");
            switch (mState) {
                case READY:
                    this.setStateReady();
                    this.setStateLoading();
                    break;
                case LOADING:
                    mLoadMoreView.setStateLoading();
                    notifyLoadMore();
                    break;
                case ERROR:
                    mLoadMoreView.setStateError();
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            notifyLoadMore();
                        }
                    });
                    break;
                case EMPTY:
                    mLoadMoreView.setStateEmpty();
                    break;
            }
        }
    }

    private void notifyLoadMore() {
        if (null != mLoadMoreListener) {
            mLoadMoreListener.onLoadMore();
        }
    }


}
