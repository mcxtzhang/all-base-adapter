package mcxtzhang.commonviewgroupadapter.databinding.rv.multype;

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


public class DBMultypeSingleItemActivity extends AppCompatActivity {
    private ActivityDbBinding mBinding;

    private BaseMulTypeBindingAdapter mAdapter;
    private List<MulTypeSingleBean> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityDbBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mDatas = initDatas();
        mAdapter = new BaseMulTypeBindingAdapter<MulTypeSingleBean>(this, mDatas) {
            @Override
            public void onBindViewHolder(BaseBindingVH<ViewDataBinding> holder, int position) {
                super.onBindViewHolder(holder, position);
                //如果有特殊需求，可传入数据结构的泛型，避免强转
                MulTypeSingleBean data = mDatas.get(position);
                //Binding类 不可避免的需要强转了
                ViewDataBinding binding = holder.getBinding();
                switch (data.getItemLayoutId()) {
                    case R.layout.item_db_mul_1:
                        ItemDbMul1Binding itemDbMul1Binding = (ItemDbMul1Binding) binding;
                        break;
                    case R.layout.item_db_mul_2:
                        ItemDbMul2Binding itemDbMul2Binding = (ItemDbMul2Binding) binding;
                        break;
                }

            }
        };

        //设置点击事件
        mAdapter.setItemPresenter(new SingleBeanPresenter());

        mBinding.rv.setAdapter(mAdapter);
        mBinding.rv.setLayoutManager(new LinearLayoutManager(this));

    }

    /**
     * ★ Item点击事件P
     */
    public class SingleBeanPresenter {
        public void onTvClick(String string) {
            Toast.makeText(DBMultypeSingleItemActivity.this, "第一种类型的TextView点击了:" + string, Toast.LENGTH_SHORT).show();
        }

        public void onTvClick2(MulTypeSingleBean mulTypeSingleBean) {
            Toast.makeText(DBMultypeSingleItemActivity.this, "第2种类型的TextView点击了 改变之前:" + mulTypeSingleBean.getName(), Toast.LENGTH_SHORT).show();
            mulTypeSingleBean.setName("改变之后");
        }
    }


    public List<MulTypeSingleBean> initDatas() {
        List<MulTypeSingleBean> datas = new ArrayList<>();
        datas.add(new MulTypeSingleBean("http://imgs.ebrun.com/resources/2016_04/2016_04_12/201604124411460430531500.jpg", "多种type").setReceive(true));
        datas.add(new MulTypeSingleBean("http://imgs.ebrun.com/resources/2016_03/2016_03_25/201603259771458878793312_origin.jpg", "张"));
        datas.add(new MulTypeSingleBean("http://p14.go007.com/2014_11_02_05/a03541088cce31b8_1.jpg", "旭童").setReceive(true));
        datas.add(new MulTypeSingleBean("http://news.k618.cn/tech/201604/W020160407281077548026.jpg", "多种type"));
        datas.add(new MulTypeSingleBean("http://www.kejik.com/image/1460343965520.jpg", "多种type").setReceive(true));
        datas.add(new MulTypeSingleBean("http://cn.chinadaily.com.cn/img/attachement/jpg/site1/20160318/eca86bd77be61855f1b81c.jpg", "多种type"));
        datas.add(new MulTypeSingleBean("http://imgs.ebrun.com/resources/2016_04/2016_04_24/201604244971461460826484_origin.jpeg", "多种type"));
        datas.add(new MulTypeSingleBean("http://www.lnmoto.cn/bbs/data/attachment/forum/201408/12/074018gshshia3is1cw3sg.jpg", "多种type"));
        return datas;
    }
}
