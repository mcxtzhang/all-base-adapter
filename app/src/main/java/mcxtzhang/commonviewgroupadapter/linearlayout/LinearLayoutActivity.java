package mcxtzhang.commonviewgroupadapter.linearlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mcxtzhang.commonadapter.ViewGroupUtils;
import com.mcxtzhang.commonadapter.adapter.single.SingleAdapter;

import java.util.ArrayList;
import java.util.List;

import mcxtzhang.commonviewgroupadapter.R;
import mcxtzhang.commonviewgroupadapter.TestBean;

public class LinearLayoutActivity extends AppCompatActivity {
    private static final String TAG = "zxt";
    private List<TestBean> mDatas;
    private LinearLayout mLinearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);
        mLinearLayout = (LinearLayout) findViewById(R.id.activity_linear_layout);
        mDatas = initDatas();

        //单一ItemView
        ViewGroupUtils.addViews(mLinearLayout, new SingleAdapter<TestBean>(this, mDatas, R.layout.item_test) {
            @Override
            public void onBindView(ViewGroup parent, View itemView, TestBean data, int pos) {
                Glide.with(LinearLayoutActivity.this)
                        .load(data.getAvatar())
                        .into((ImageView) itemView.findViewById(R.id.ivAvatar));
                ((TextView) itemView.findViewById(R.id.tvName)).setText(data.getName());
            }
        });

    }

    public List<TestBean> initDatas() {
        List<TestBean> datas = new ArrayList<>();
        datas.add(new TestBean("http://imgs.ebrun.com/resources/2016_03/2016_03_25/201603259771458878793312_origin.jpg", "张"));
        datas.add(new TestBean("http://p14.go007.com/2014_11_02_05/a03541088cce31b8_1.jpg", "旭童"));
        datas.add(new TestBean("http://news.k618.cn/tech/201604/W020160407281077548026.jpg", "多种type"));
        datas.add(new TestBean("http://www.kejik.com/image/1460343965520.jpg", "多种type"));
        datas.add(new TestBean("http://cn.chinadaily.com.cn/img/attachement/jpg/site1/20160318/eca86bd77be61855f1b81c.jpg", "多种type"));
        datas.add(new TestBean("http://imgs.ebrun.com/resources/2016_04/2016_04_12/201604124411460430531500.jpg", "多种type"));
        datas.add(new TestBean("http://imgs.ebrun.com/resources/2016_04/2016_04_24/201604244971461460826484_origin.jpeg", "多种type"));
        datas.add(new TestBean("http://www.lnmoto.cn/bbs/data/attachment/forum/201408/12/074018gshshia3is1cw3sg.jpg", "多种type"));
        return datas;
    }
}
