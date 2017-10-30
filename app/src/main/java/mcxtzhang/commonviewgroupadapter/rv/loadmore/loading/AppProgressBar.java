package mcxtzhang.commonviewgroupadapter.rv.loadmore.loading;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * 介绍：App全局的Loading
 * 作者：xjzhao
 * 邮箱：mr.feeling.heart@gmail.com
 * 时间: 2016-04-22  下午4:40
 */
public class AppProgressBar extends RelativeLayout {
    /*全局进度条颜色*/
    public static int[] MD_RF_COLOR = {0x0057e7, 0x008744, 0xd62d20, 0xffa700};

    private static final int CIRCLE_DIAMETER = 40;
    private static final int CIRCLE_BG_LIGHT = 0xFFFAFAFA;
    private CircleImageView circleView;
    private MaterialProgressDrawable progressDrawable;
    private boolean isLoading;

    public AppProgressBar(Context context) {
        super(context);
        init();
    }

    public AppProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AppProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AppProgressBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        circleView = new CircleImageView(getContext(), CIRCLE_BG_LIGHT, CIRCLE_DIAMETER / 2);
        progressDrawable = new MaterialProgressDrawable(getContext(), this);
        progressDrawable.setBackgroundColor(CIRCLE_BG_LIGHT);
        circleView.setImageDrawable(progressDrawable);
        circleView.setVisibility(View.VISIBLE);
        progressDrawable.setAlpha(255);
        if (null != MD_RF_COLOR) {
            final Resources res = getResources();
            int[] colorRes = new int[MD_RF_COLOR.length];
            for (int i = 0; i < MD_RF_COLOR.length; i++) {
                colorRes[i] = (MD_RF_COLOR[i]);
            }
            progressDrawable.setColorSchemeColors(colorRes);
        }
        setProgressBarBackgroundColor(Color.WHITE);
        addView(circleView);
        startAnimation();
    }


    public void setColorSchemeResources(int... colors) {
        if (null != progressDrawable) {
            final Resources res = getResources();
            int[] colorRes = new int[colors.length];
            for (int i = 0; i < colors.length; i++) {
                colorRes[i] = res.getColor(colors[i]);
            }
            progressDrawable.setColorSchemeColors(colorRes);
        }
    }

    public void setProgressBarBackgroundColor(int color) {
        if (null != circleView) {
            circleView.setBackgroundColor(color);
        }
    }

    public void startAnimation() {
        if (null != progressDrawable) {
            progressDrawable.start();
            isLoading = true;
        }
    }

    public void stopAnimation() {
        if (null != progressDrawable) {
            progressDrawable.stop();
            isLoading = false;
        }
    }

    public void setInnerVisibility(int innerVisibility) {
        if (null != circleView) {
            circleView.setVisibility(innerVisibility);
            if (innerVisibility == VISIBLE) {
                startAnimation();
            } else {
                stopAnimation();
            }
        }
    }

    public boolean isLoading() {
        return isLoading;
    }
}
