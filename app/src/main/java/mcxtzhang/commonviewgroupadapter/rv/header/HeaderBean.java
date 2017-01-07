package mcxtzhang.commonviewgroupadapter.rv.header;

import android.content.Intent;
import android.view.View;

import com.mcxtzhang.commonadapter.rv.IHeaderHelper;
import com.mcxtzhang.commonadapter.rv.ViewHolder;

import mcxtzhang.commonviewgroupadapter.R;
import mcxtzhang.commonviewgroupadapter.rv.mul.RvMulTypeMulBeanActivity;

/**
 * 介绍：
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 17/01/08.
 */

public class HeaderBean implements IHeaderHelper {
    private String text;

    public HeaderBean(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public HeaderBean setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.header_banner;
    }

    @Override
    public void onBind(final ViewHolder holder) {
        holder.setText(R.id.tv, text);
        holder.setOnClickListener(R.id.tv, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击跳转到多ItemType
                holder.itemView.getContext().startActivity(new Intent(holder.itemView.getContext(), RvMulTypeMulBeanActivity.class));
            }
        });
    }
}
