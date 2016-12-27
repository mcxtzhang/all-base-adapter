package com.mcxtzhang.commonadapter.viewgroup.widget.fakergrid;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.mcxtzhang.commonadapter.R;


/**
 * 介绍：模仿GridView的控件，
 * 用以替代、解决在列表中嵌套GridView的性能额外消耗问题。
 * (性能额外消耗 ：http://blog.csdn.net/zxt0601/article/details/52494665)
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 2016/12/27.
 */

public class FakerGridView extends ViewGroup {
    private static final int COLUMNS_DEFAULT = 1;
    //列数
    private int mColumns;
    //每一列的间距
    private int mHorizontalSpacing;
    //每一行的间距
    private int mVerticalSpacing;

    private int mWidth, mHeight;
    //每一列的宽度
    private int mPerColumnWidth;

    public FakerGridView(Context context) {
        this(context, null);
    }

    public FakerGridView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FakerGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.FakerGridView, defStyleAttr, 0);
        int count = typedArray.getIndexCount();
        for (int i = 0; i < count; i++) {
            int index = typedArray.getIndex(i);
            if (index == R.styleable.FakerGridView_numColumns) {
                mColumns = typedArray.getInteger(index, COLUMNS_DEFAULT);
            } else if (index == R.styleable.FakerGridView_horizontalSpacing) {
                mHorizontalSpacing = typedArray.getDimensionPixelOffset(index, 0);
            } else if (index == R.styleable.FakerGridView_verticalSpacing) {
                mVerticalSpacing = typedArray.getDimensionPixelOffset(index, 0);
            }
        }
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //获取系统传递过来测量出的宽度 高度，以及相应的测量模式。

        //GridView主要是计算height的值 宽度 一般 match
        //如果测量模式为 EXACTLY( 确定的dp值，match_parent)，则可以调用setMeasuredDimension()设置，
        //如果测量模式为 AT_MOST(wrap_content),则需要经过计算再去调用setMeasuredDimension()设置
        int heightMeasure = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int childCount = getChildCount();
        View child = null;
        int maxHeightPerline = 0;
        int computeHeight = 0;


        for (int i = 0; i < childCount; i++) {
            child = getChildAt(i);
            measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);
            maxHeightPerline = Math.max(maxHeightPerline, child.getMeasuredHeight());
            //换行 或者 最后一个 都累加一下
            if (i == childCount - 1) {
                computeHeight = computeHeight + maxHeightPerline;
            } else if (i % mColumns == mColumns - 1) {
                computeHeight = computeHeight + maxHeightPerline + mVerticalSpacing;
                maxHeightPerline = 0;
            }
        }

        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec),
                heightMode != MeasureSpec.EXACTLY ? computeHeight + getPaddingTop() + getPaddingBottom() : heightMeasure);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        mWidth = getWidth();
        //这里如果考虑每个column的间距 则还需要修改
        mPerColumnWidth = (mWidth - getPaddingRight() - getPaddingLeft() - mHorizontalSpacing * (mColumns - 1)) / mColumns;
        View child = null;
        int left = getPaddingLeft();
        int top = getPaddingTop();
        int maxHeightPerline = 0;
        for (int i = 0; i < childCount; i++) {
            child = getChildAt(i);
            child.layout(left, top, left + mPerColumnWidth, top + child.getMeasuredHeight());
            maxHeightPerline = Math.max(maxHeightPerline, child.getMeasuredHeight());
            //到达最后一列
            if (i % mColumns == mColumns - 1) {
                left = getPaddingLeft();
                top = top + maxHeightPerline + mVerticalSpacing;
                maxHeightPerline = 0;
            } else {
                left = left + mPerColumnWidth + mHorizontalSpacing;
            }
        }
    }

    /**
     * @return 当前ViewGroup返回的Params的类型
     */
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }
}
