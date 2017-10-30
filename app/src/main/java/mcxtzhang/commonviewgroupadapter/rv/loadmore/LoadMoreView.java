package mcxtzhang.commonviewgroupadapter.rv.loadmore;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import mcxtzhang.commonviewgroupadapter.R;
import mcxtzhang.commonviewgroupadapter.rv.loadmore.loading.AppProgressBar;

/**
 * Intro: 加载更多的View
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/24.
 * History:
 */

public class LoadMoreView extends FrameLayout {
    View mLoading;
    AppProgressBar mLoadingView;
    View mError;
    View mEmpty;

    public LoadMoreView(Context context) {
        this(context, null);
        init(context);
    }

    public LoadMoreView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init(context);
    }

    public LoadMoreView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_footer, this);
        mLoading = findViewById(R.id.loading);
        mLoadingView = (AppProgressBar) findViewById(R.id.loadingView);
        mError = findViewById(R.id.error);
        mEmpty = findViewById(R.id.empty);

    }

    public LoadMoreView setStateLoading() {
        setBackgroundColor(Color.GRAY);
        mLoading.setVisibility(View.VISIBLE);
        mError.setVisibility(View.GONE);
        mEmpty.setVisibility(View.GONE);
        mLoadingView.startAnimation();

        return this;
    }

    public LoadMoreView setStateReady() {
        setBackgroundColor(Color.YELLOW);
        mLoading.setVisibility(View.GONE);
        mError.setVisibility(View.GONE);
        mEmpty.setVisibility(View.GONE);
        mLoadingView.stopAnimation();
        return this;
    }

    public LoadMoreView setStateError() {
        setBackgroundColor(Color.RED);
        mLoading.setVisibility(View.GONE);
        mError.setVisibility(View.VISIBLE);
        mEmpty.setVisibility(View.GONE);
        mLoadingView.stopAnimation();
        return this;
    }

    public LoadMoreView setStateEmpty() {
        setBackgroundColor(Color.BLUE);
        mLoading.setVisibility(View.GONE);
        mError.setVisibility(View.GONE);
        mEmpty.setVisibility(View.VISIBLE);
        mLoadingView.stopAnimation();
        return this;
    }

}
