package com.mcxtzhang.commob_lib.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mcxtzhang.commob_lib.R;


/**
 * app全局TopBanner
 *
 * 作者：xjzhao
 * 时间：2015-02-20 上午11:20
 */
public class CstTopBanner extends RelativeLayout {

    private LinearLayout layout;
    private View view;
    private Context context;
    private int height;
    private LinearLayout left;
    private RelativeLayout centre;
    private LinearLayout right;

    private ImageView leftImg;
    private ImageView centreImg;
    private ImageView rightImg;

    private TextView leftText;
    private TextView centreText;
    private TextView rightText;

    private TextView leftFame;
    private TextView rightFame;
    private RelativeLayout customedLayout;
    private RelativeLayout commonLayout;

    public CstTopBanner(Context context) {
        super(context);
        init(context);
    }

    public CstTopBanner(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CstTopBanner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public RelativeLayout getCustomedLayout() {
        return customedLayout;
    }

    public void init(final Context context) {
        if (null == context) {
            throw new IllegalArgumentException("TopBannerView creat: null params(context)");
        }
        this.context = context;
        view = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.cst_top_banner, this);
       // height = getViewWidthOrHeight(view, false);
        initView();
    }

    public void setBgColor(int color){
        if (null != layout){
            layout.setBackgroundColor(color);
        }
    }

    public ImageView getRightImage(){
    	return rightImg;
    }
    
    private void initView() {
        if (null != view) {
            //view.setMinimumHeight(Constant.SCREEN_HEIGHT / 15);
            layout = (LinearLayout) view.findViewById(R.id.app_top_banner_layout);
            left = (LinearLayout) view.findViewById(R.id.app_top_banner_left_layout);
            centre = (RelativeLayout) view.findViewById(R.id.app_top_banner_centre_layout);
            right = (LinearLayout) view.findViewById(R.id.app_top_banner_right_layout);
            leftImg = (ImageView) view.findViewById(R.id.app_top_banner_left_image);
            centreImg = (ImageView) view.findViewById(R.id.app_top_banner_centre_image);
            rightImg = (ImageView) view.findViewById(R.id.app_top_banner_right_image);
            leftText = (TextView) view.findViewById(R.id.app_top_banner_left_text);
            centreText = (TextView) view.findViewById(R.id.app_top_banner_centre_text);
            rightText = (TextView) view.findViewById(R.id.app_top_banner_right_text);
            leftFame = (TextView) view.findViewById(R.id.app_top_banner_left_fame);
            rightFame = (TextView) view.findViewById(R.id.app_top_banner_right_fame);

            customedLayout = (RelativeLayout) view.findViewById(R.id.custom_layout);
            commonLayout = (RelativeLayout) view.findViewById(R.id.common_layout);

            setCustom(false);

            setLeftVisible(false);
            setCentreVisible(false);
            setRightVisible(false);
        }
    }


    public void setBackColor(int color) {
        if (null != layout) {
            layout.setBackgroundDrawable(null);
            layout.setBackgroundColor(color);
        }
    }

    /**
     * 设置中间，调用时默认将传递不为空的显示
     *
     * @param imgResId
     * @param s
     * @param l
     */
    public void setCentre(final Integer imgResId, final String s, final OnClickListener l) {
        setCustom(false);
        setCentreVisible(true);
        setImgRes(centreImg, imgResId);
        setText(centreText, s);
        setOnClickListener(l);
        setCentre();
    }

    /**
     * 设置左侧，调用时默认将传递不为空的显示
     *
     * @param imgResId
     * @param s
     * @param l
     */
    public void setLeft(final Integer imgResId, final String s, final OnClickListener l) {
        setCustom(false);
        setLeftVisible(true);
        setImgRes(leftImg, imgResId);
        setText(leftText, s);
        setOnClickListener(left, l);
        setCentre();
    }

    /**
     * 设置右侧，调用时默认将传递不为空的显示
     *
     * @param imgResId
     * @param s
     * @param l
     */
    public void setRight(final Integer imgResId, final String s, final OnClickListener l) {
        setCustom(false);
        setRightVisible(true);
        setImgRes(rightImg, imgResId);
        setText(rightText, s);
        setOnClickListener(right, l);
        setCentre();
    }

    /**
     * 设置右侧，调用时默认将传递不为空的显示
     *
     * @param imgResId
     */
    public void setRightImage(final Integer imgResId) {
        setCustom(false);
        setRightVisible(true);
        setImgRes(rightImg, imgResId);
        setCentre();
    }


    private void setVisible(final View v, final boolean visible) {
        if (null != v) {
            if (visible) {
                v.setVisibility(View.VISIBLE);
            } else {
                v.setVisibility(View.INVISIBLE);
            }
        }
    }


    public void setCentreVisible(final boolean visible) {
        setVisible(centre, visible);
    }

    public void setLeftVisible(final boolean visible) {
        setVisible(left, visible);
    }

    public void setRightVisible(final boolean visible) {
        setVisible(right, visible);
    }

    private void setImgRes(final ImageView img, final Integer imgResId) {
        if (null != img) {
            if (null != imgResId) {
                img.setImageResource(imgResId);
//                int imgH = getViewWidthOrHeight(img, false);
//                int h = height - DisplayUtils.dip2px(context, 30);
                img.setVisibility(View.VISIBLE);
            } else {
                img.setVisibility(View.INVISIBLE);
            }
        }
    }

    public void setCentreTextColor(int color){
        if (null != centreText){
            centreText.setTextColor(color);
        }
    }

    public void setLeftTextColor(int color){
        if (null != leftText){
            leftText.setTextColor(color);
        }
    }

    public void setRightTextColor(int color){
        if (null != rightText){
            rightText.setTextColor(color);
        }
    }

    public void addToRight(View view) {
        if (view != null) {
            right.setVisibility(VISIBLE);
            right.removeAllViewsInLayout();
            right.addView(view);
//            int imgH = getViewWidthOrHeight(view, false);
//            int h = height - DisplayUtils.dip2px(30);
//            if (imgH > h && h > 0) {
//                float scale = h * 1f / height;
//                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) view.getLayoutParams();
//                lp.width = (int) ((getViewWidthOrHeight(view, true) * scale));
//                lp.height = h;
//                view.setLayoutParams(lp);
//            }
            view.setVisibility(View.VISIBLE);
            setCentre();
        }
    }


    public void addToCenter(View view){
        if (null != view){
            centre.setVisibility(VISIBLE);
            centre.removeAllViewsInLayout();
            centre.addView(view);
            setCentre();
        }
    }


    public void addToLeft(View view) {
        if (view != null) {
            left.setVisibility(VISIBLE);
            left.removeAllViewsInLayout();
            left.addView(view);
//            int imgH = getViewWidthOrHeight(view, false);
//            int h = height - DisplayUtils.dip2px(30);
//            if (imgH > h && h > 0) {
//                float scale = h * 1f / height;
//                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) view.getLayoutParams();
//                lp.width = (int) ((getViewWidthOrHeight(view, true) * scale));
//                lp.height = h;
//            }
            view.setVisibility(View.VISIBLE);
            setCentre();
        }
    }

    private void setText(final TextView t, final String s) {
        if (null != t) {
            if (!TextUtils.isEmpty(s)) {
                t.setVisibility(View.VISIBLE);
                t.setText(s);
            } else {
                t.setVisibility(View.GONE);
            }
        }
    }

    private void setOnClickListener(final View v, final OnClickListener l) {
        if (null != v) {
            v.setOnClickListener(l);
        }
    }

    //对于有可能顶部左右布局宽度不同时使用
    private void setCentre() {
        if (null != view) {
            int lw = getViewWidthOrHeight(left, true);
            int rw = getViewWidthOrHeight(right, true);
            int maxW = getMaxWidth(lw, rw);

            if (null != rightFame) {
                LayoutParams paramsR = new LayoutParams(maxW, LayoutParams.WRAP_CONTENT);
                paramsR.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                rightFame.setLayoutParams(paramsR);
            }

            if (null != leftFame) {
                LayoutParams paramsL = new LayoutParams(maxW, LayoutParams.WRAP_CONTENT);
                paramsL.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                leftFame.setLayoutParams(paramsL);
            }
        }
    }

    private int getMaxWidth(int lw, int rw) {
        if (lw > rw) {
            return lw;
        } else {
            return rw;
        }
    }

    public LinearLayout getLayout(){
        return layout;
    }

    public RelativeLayout getCentre(){
        return centre;
    }

    public TextView getRightText() {
        return rightText;
    }

    public TextView getCentreText() {
        return centreText;
    }

    public TextView getLeftText() {
        return leftText;
    }


    public ViewGroup getLeftLayout() {
        return left;
    }

    public RelativeLayout getCentreLayout() {
        return centre;
    }

    public ViewGroup getRightLayout() {
        return right;
    }

    int getViewWidthOrHeight(final View v, final boolean isWidth) {
        int param = 0;
        if (null != v) {
            int w = MeasureSpec.makeMeasureSpec(0,
                    MeasureSpec.UNSPECIFIED);
            int h = MeasureSpec.makeMeasureSpec(0,
                    MeasureSpec.UNSPECIFIED);
            v.measure(w, h);
            if (isWidth) {
                param = v.getMeasuredWidth();
            } else {
                param = v.getMeasuredHeight();
            }
        }
        return param;
    }


    public void setLayoutOnClickListener(OnClickListener l){
        if (null != layout){
            layout.setOnClickListener(l);
        }
    }

    private void setCustom(boolean isCustom){
        if (isCustom){
            customedLayout.setVisibility(VISIBLE);
            commonLayout.setVisibility(GONE);
        }else {
            customedLayout.setVisibility(GONE);
            commonLayout.setVisibility(VISIBLE);
        }
    }

    public void setCustomedTopBanner(View view){
        setCustom(true);
        customedLayout.removeAllViews();
        customedLayout.addView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }
}
