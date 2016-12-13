package mcxtzhang.commonviewgroupadapter.rv.databinding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.mcxtzhang.commonadapter.rv.databinding.BaseBindingAdapter;

import java.util.ArrayList;
import java.util.List;

import mcxtzhang.commonviewgroupadapter.R;
import mcxtzhang.commonviewgroupadapter.databinding.ActivityDbsingleBinding;
import mcxtzhang.commonviewgroupadapter.databinding.ItemDbSingleBinding;

public class DBSingleActivity extends AppCompatActivity {
    private ActivityDbsingleBinding mBinding;
    private BaseBindingAdapter mAdapter;
    private List<DBSingleBean> mDatas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbsingle);
        mBinding = ActivityDbsingleBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mDatas = initDatas();
        mBinding.rv.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rv.setAdapter(mAdapter = new BaseBindingAdapter<DBSingleBean, ItemDbSingleBinding>(
                this, mDatas,R.layout.item_db_single));
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
