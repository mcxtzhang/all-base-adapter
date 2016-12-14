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

public class MulTypeMulBean1 implements IMulTypeHelper {
    private String avatar;
    private String name;

    public MulTypeMulBean1(String avatar, String name) {
        this.avatar = avatar;
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public MulTypeMulBean1 setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getName() {
        return name;
    }

    public MulTypeMulBean1 setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_rv_mulbean_1;
    }

    @Override
    public void onBind(ViewHolder holder) {
        holder.setText(R.id.tv, name);
        Glide.with(holder.itemView.getContext()).load(avatar).into((ImageView) holder.getView(R.id.iv1));
        Glide.with(holder.itemView.getContext()).load(avatar).into((ImageView) holder.getView(R.id.iv2));
    }
}
