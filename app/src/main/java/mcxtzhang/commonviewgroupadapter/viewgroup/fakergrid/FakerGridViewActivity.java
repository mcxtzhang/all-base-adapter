package mcxtzhang.commonviewgroupadapter.viewgroup.fakergrid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mcxtzhang.commonadapter.viewgroup.VGUtil;
import com.mcxtzhang.commonadapter.viewgroup.adapter.cache.ViewHolder;
import com.mcxtzhang.commonadapter.viewgroup.adapter.single.SingleAdapter;
import com.mcxtzhang.commonadapter.viewgroup.widget.fakergrid.FakerGridView;

import java.util.ArrayList;
import java.util.List;

import mcxtzhang.commonviewgroupadapter.R;
import mcxtzhang.commonviewgroupadapter.viewgroup.multype.MulTypeBean;


public class FakerGridViewActivity extends AppCompatActivity {

    VGUtil mVGUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faker_grid_view);
        FakerGridView fakerGridView = (FakerGridView) findViewById(R.id.fgv);
        //多种ItemViewType，但是数据结构相同，可以传入数据结构泛型，避免强转
        mVGUtil = new VGUtil(fakerGridView, new SingleAdapter<MulTypeBean>(this, initDatas(), R.layout.item_mul_1) {
            @Override
            public void onBindViewHolder(ViewGroup parent, ViewHolder holder, final MulTypeBean data, int pos) {
                holder.setText(R.id.tvWords, data.getName() + "");
                Glide.with(FakerGridViewActivity.this)
                        .load(data.getAvatar())
                        .into((ImageView) holder.getView(R.id.ivAvatar));
                //#### Adapter.onBindView()里设置 优先级更高
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mContext, "onBindView里设置:文字是:" + data.getName(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        })
                .bind();


    }

    public List<MulTypeBean> initDatas() {
        List<MulTypeBean> datas = new ArrayList<>();
        datas.add(new MulTypeBean("http://imgs.ebrun.com/resources/2016_04/2016_04_12/201604124411460430531500.jpg", "0").setReceive(true));
        datas.add(new MulTypeBean("http://imgs.ebrun.com/resources/2016_03/2016_03_25/201603259771458878793312_origin.jpg", "1张"));
        datas.add(new MulTypeBean("http://p14.go007.com/2014_11_02_05/a03541088cce31b8_1.jpg", "2旭童").setReceive(true));
        datas.add(new MulTypeBean("http://news.k618.cn/tech/201604/W020160407281077548026.jpg", "3多种type"));
        datas.add(new MulTypeBean("http://www.kejik.com/image/1460343965520.jpg", "4多种type").setReceive(true));
        datas.add(new MulTypeBean("http://cn.chinadaily.com.cn/img/attachement/jpg/site1/20160318/eca86bd77be61855f1b81c.jpg", "5多种type"));
        datas.add(new MulTypeBean("http://imgs.ebrun.com/resources/2016_04/2016_04_24/201604244971461460826484_origin.jpeg", "6多种type"));
        datas.add(new MulTypeBean("http://www.lnmoto.cn/bbs/data/attachment/forum/201408/12/074018gshshia3is1cw3sg.jpg", "7多种type"));
        return datas;
    }
}
