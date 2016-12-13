package mcxtzhang.commonviewgroupadapter.databinding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

/**
 * 介绍：
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * CSDN：http://blog.csdn.net/zxt0601
 * 时间： 16/09/25.
 */

public class LoadImgAdapter {

    //后面的netUrl是xml里的名字, 必须是static方法
    @BindingAdapter({"netUrl", "shenqi"})
    public static void loadNetImage(ImageView imageView, String url, String shenqi) {
        //图片加载
        Glide.with(imageView.getContext()).load(url).into(imageView);
        Toast.makeText(imageView.getContext(), "shenqi" + shenqi, Toast.LENGTH_SHORT).show();
    }

    @BindingAdapter({"netUrl"})
    public static void loadNetImage(ImageView iv, String url) {
        Glide.with(iv.getContext()).load(url).into(iv);
    }
}
