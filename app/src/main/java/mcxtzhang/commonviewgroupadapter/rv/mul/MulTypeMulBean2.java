package mcxtzhang.commonviewgroupadapter.rv.mul;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mcxtzhang.commonadapter.rv.ViewHolder;
import com.mcxtzhang.commonadapter.rv.mul.IMulTypeHelper;

import mcxtzhang.commonviewgroupadapter.R;

/**
 * 介绍：
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 2016/12/13.
 */

public class MulTypeMulBean2 implements IMulTypeHelper {
    private String background;

    public MulTypeMulBean2(String background) {
        this.background = background;
    }

    public String getBackground() {
        return background;
    }

    public MulTypeMulBean2 setBackground(String background) {
        this.background = background;
        return this;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_rv_mulbean_2;
    }

    @Override
    public void onBind(ViewHolder holder) {
        Glide.with(holder.itemView.getContext()).load(background).into((ImageView) holder.getView(R.id.banner));
    }
}
