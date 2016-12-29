package mcxtzhang.commonviewgroupadapter.databinding.rv.single;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.mcxtzhang.commonadapter.databinding.rv.BaseBindingAdapter;
import com.mcxtzhang.commonadapter.databinding.rv.BaseBindingVH;

import java.util.ArrayList;
import java.util.List;

import mcxtzhang.commonviewgroupadapter.R;
import mcxtzhang.commonviewgroupadapter.databinding.ActivityDbBinding;
import mcxtzhang.commonviewgroupadapter.databinding.ItemDbSingleBinding;

public class DBSingleActivity extends AppCompatActivity {
    private ActivityDbBinding mBinding;
    private BaseBindingAdapter mAdapter;
    private List<DBSingleBean> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        mBinding = ActivityDbBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mDatas = initDatas();
        mBinding.setClickPresenter(new ClickPresenter());
        mBinding.rv.setLayoutManager(new LinearLayoutManager(this));


        // ★泛型D:是Bean类型，如果有就传。  泛型B:是对应的xml Layout的Binding类
        mAdapter = new BaseBindingAdapter<DBSingleBean, ItemDbSingleBinding>(this, mDatas, R.layout.item_db_single) {
            @Override
            public void onBindViewHolder(BaseBindingVH<ItemDbSingleBinding> holder, int position) {
                //★super一定不要删除
                super.onBindViewHolder(holder, position);
                //如果有特殊需求，可传入两个泛型，重写onBindViewHolder搞事情。
                ItemDbSingleBinding binding = holder.getBinding();
                DBSingleBean data = mDatas.get(position);
                holder.getBinding().setPosition(holder.getLayoutPosition());
            }
        };

        //★ 设置Item点击事件
        mAdapter.setItemPresenter(new SingleItemPresenter());
        mBinding.rv.setAdapter(mAdapter);

    }

    /**
     * ★ Item点击事件P
     */
    public class SingleItemPresenter {
        public void onItemClick(DBSingleBean data, int position) {
            data.setName("修改之后立刻见效");
            Toast.makeText(DBSingleActivity.this, "postion:" + position, Toast.LENGTH_SHORT).show();
        }
    }


    public class ClickPresenter {
        public void onAddClick(View v) {
            mAdapter.add(1, new DBSingleBean("http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1304/25/c1/20230636_1366863045911_800x800.jpg", "add"));
        }

        public void onDelClick(View v) {
            mAdapter.remove(1);
        }

        public void onAddClick2(View v) {
            mAdapter.add(new DBSingleBean("http://image57.360doc.com/DownloadImg/2012/12/1111/28833848_3.jpg", "add末尾"));
        }

    }

    public List<DBSingleBean> initDatas() {
        List<DBSingleBean> datas = new ArrayList<>();
        datas.add(new DBSingleBean("http://imgs.ebrun.com/resources/2016_03/2016_03_25/201603259771458878793312_origin.jpg", "张"));
        datas.add(new DBSingleBean("http://p14.go007.com/2014_11_02_05/a03541088cce31b8_1.jpg", "旭童"));
        datas.add(new DBSingleBean("http://news.k618.cn/tech/201604/W020160407281077548026.jpg", "多种type"));
        datas.add(new DBSingleBean("http://www.kejik.com/image/1460343965520.jpg", "多种type"));
        datas.add(new DBSingleBean("http://cn.chinadaily.com.cn/img/attachement/jpg/site1/20160318/eca86bd77be61855f1b81c.jpg", "多种type"));
        datas.add(new DBSingleBean("http://imgs.ebrun.com/resources/2016_04/2016_04_12/201604124411460430531500.jpg", "多种type"));
        datas.add(new DBSingleBean("http://imgs.ebrun.com/resources/2016_04/2016_04_24/201604244971461460826484_origin.jpeg", "多种type"));
        datas.add(new DBSingleBean("http://www.lnmoto.cn/bbs/data/attachment/forum/201408/12/074018gshshia3is1cw3sg.jpg", "多种type"));
        return datas;
    }

}
