package mcxtzhang.commonviewgroupadapter.viewgroup.multype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mcxtzhang.commonadapter.viewgroup.ViewGroupUtils;
import com.mcxtzhang.commonadapter.viewgroup.adapter.cache.ViewHolder;
import com.mcxtzhang.commonadapter.viewgroup.adapter.mul.MulTypeAdapter;
import com.mcxtzhang.commonadapter.viewgroup.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import mcxtzhang.commonviewgroupadapter.R;

import static mcxtzhang.commonviewgroupadapter.R.id.ivAvatar;

/**
 * 介绍：多种Item类型：数据结构相同：
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 16/12/10.
 */
public class MulTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mul_type);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.activity_mul_type);

        //设置OnItemClickListener
        OnItemClickListener onItemClickListener = new OnItemClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View itemView, int position) {
                Toast.makeText(MulTypeActivity.this, "通过OnItemClickListener设置:" + position, Toast.LENGTH_SHORT).show();
            }
        };

        //多种ItemViewType，但是数据结构相同，可以传入数据结构泛型，避免强转
        ViewGroupUtils.addViews(linearLayout, new MulTypeAdapter<MulTypeBean>(this, initDatas()) {
            @Override
            public void onBindViewHolder(ViewGroup parent, ViewHolder holder, final MulTypeBean data, int pos) {
                holder.setText(R.id.tvWords, data.getName() + "");
                Glide.with(MulTypeActivity.this)
                        .load(data.getAvatar())
                        .into((ImageView) holder.findViewById(ivAvatar));
                //#### Adapter.onBindView()里设置 优先级更高
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mContext, "onBindView里设置:文字是:" + data.getName(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

        }, onItemClickListener);
        //可以在`ViewGroupUtils.addViews`直接作为参数传入.\
        // 也可以用`ViewGroupUtils.setOnItemClickListener(）`设置
        // **优先级比`Adapter.onBindView()`里设置低，**
        //ViewGroupUtils.setOnItemClickListener(linearLayout,onItemClickListener);

    }


    public List<MulTypeBean> initDatas() {
        List<MulTypeBean> datas = new ArrayList<>();
        datas.add(new MulTypeBean("http://imgs.ebrun.com/resources/2016_04/2016_04_12/201604124411460430531500.jpg", "多种type").setReceive(true));
        datas.add(new MulTypeBean("http://imgs.ebrun.com/resources/2016_03/2016_03_25/201603259771458878793312_origin.jpg", "张"));
        datas.add(new MulTypeBean("http://p14.go007.com/2014_11_02_05/a03541088cce31b8_1.jpg", "旭童").setReceive(true));
        datas.add(new MulTypeBean("http://news.k618.cn/tech/201604/W020160407281077548026.jpg", "多种type"));
        datas.add(new MulTypeBean("http://www.kejik.com/image/1460343965520.jpg", "多种type").setReceive(true));
        datas.add(new MulTypeBean("http://cn.chinadaily.com.cn/img/attachement/jpg/site1/20160318/eca86bd77be61855f1b81c.jpg", "多种type"));
        datas.add(new MulTypeBean("http://imgs.ebrun.com/resources/2016_04/2016_04_24/201604244971461460826484_origin.jpeg", "多种type"));
        datas.add(new MulTypeBean("http://www.lnmoto.cn/bbs/data/attachment/forum/201408/12/074018gshshia3is1cw3sg.jpg", "多种type"));
        return datas;
    }
}
