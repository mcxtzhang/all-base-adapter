package mcxtzhang.commonviewgroupadapter.databinding.rv.multype.mulbean;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.mcxtzhang.commonadapter.databinding.rv.BaseBindingVH;
import com.mcxtzhang.commonadapter.databinding.rv.mul.BaseMulTypeBindingAdapter;

import java.util.ArrayList;
import java.util.List;

import mcxtzhang.commonviewgroupadapter.R;
import mcxtzhang.commonviewgroupadapter.databinding.ActivityDbBinding;
import mcxtzhang.commonviewgroupadapter.databinding.ItemDbMul1Binding;
import mcxtzhang.commonviewgroupadapter.databinding.ItemDbMul2Binding;

public class DBMulTypeMulBeanActivity extends AppCompatActivity {
    private ActivityDbBinding mBinding;

    private BaseMulTypeBindingAdapter mAdapter;
    private List mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityDbBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mDatas = initDatas();

        mAdapter = new BaseMulTypeBindingAdapter(this, mDatas) {
            @Override
            public void onBindViewHolder(BaseBindingVH holder, int position) {
                super.onBindViewHolder(holder, position);
                //如果有特殊需求 重写onBindViewHolder方法
                // 数据结构 和 Binding类 都不可避免的需要强转了
                ViewDataBinding binding = holder.getBinding();
                switch (getItemViewType(position)) {
                    case R.layout.item_db_mul_1:
                        ItemDbMul1Binding itemDbMul1Binding = (ItemDbMul1Binding) binding;
                        MulTypeMulBean1 data1 = (MulTypeMulBean1) mDatas.get(position);
                        break;
                    case R.layout.item_db_mul_2:
                        ItemDbMul2Binding itemDbMul2Binding = (ItemDbMul2Binding) binding;
                        MulTypeMulBean2 data2 = (MulTypeMulBean2) mDatas.get(position);
                        break;
                }
            }
        };

        //设置点击事件：
        mAdapter.setItemPresenter(new MulTypeMulBeanPresenter());

        mBinding.rv.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rv.setAdapter(mAdapter);
    }

    /**
     * ★ Item点击事件P
     */
    public class MulTypeMulBeanPresenter {
        public void onTvClick(String string) {
            Toast.makeText(DBMulTypeMulBeanActivity.this, "第一种类型的TextView点击了:" + string, Toast.LENGTH_SHORT).show();
        }

        public void onImageClick2(MulTypeMulBean2 data) {
            data.setBackground("http://image101.360doc.com/DownloadImg/2016/10/2813/83246025_16.jpg");
        }
    }

    public List initDatas() {
        List datas = new ArrayList<>();
        datas.add(new MulTypeMulBean2("http://desk.fd.zol-img.com.cn/t_s960x600c5/g5/M00/01/0E/ChMkJlbKwaOIN8zJAAs5DadIS-IAALGbQPo5ngACzkl365.jpg"));

        datas.add(new MulTypeMulBean1("http://imgs.ebrun.com/resources/2016_04/2016_04_12/201604124411460430531500.jpg", "多种type"));
        datas.add(new MulTypeMulBean1("http://imgs.ebrun.com/resources/2016_03/2016_03_25/201603259771458878793312_origin.jpg", "张"));

        datas.add(new MulTypeMulBean2("http://cdn.duitang.com/uploads/item/201610/20/20161020070310_c5xWi.jpeg"));

        datas.add(new MulTypeMulBean1("http://p14.go007.com/2014_11_02_05/a03541088cce31b8_1.jpg", "旭童"));
        datas.add(new MulTypeMulBean1("http://news.k618.cn/tech/201604/W020160407281077548026.jpg", "多种type"));
        datas.add(new MulTypeMulBean1("http://www.kejik.com/image/1460343965520.jpg", "多种type"));
        datas.add(new MulTypeMulBean1("http://cn.chinadaily.com.cn/img/attachement/jpg/site1/20160318/eca86bd77be61855f1b81c.jpg", "多种type"));

        datas.add(new MulTypeMulBean2("http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1512/31/c4/17105160_1451572371249_800x800.jpg"));

        datas.add(new MulTypeMulBean1("http://imgs.ebrun.com/resources/2016_04/2016_04_24/201604244971461460826484_origin.jpeg", "多种type"));
        datas.add(new MulTypeMulBean1("http://www.lnmoto.cn/bbs/data/attachment/forum/201408/12/074018gshshia3is1cw3sg.jpg", "多种type"));
        return datas;
    }
}
