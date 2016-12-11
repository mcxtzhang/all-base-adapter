package mcxtzhang.commonviewgroupadapter.multype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mcxtzhang.commonadapter.ViewGroupUtils;
import com.mcxtzhang.commonadapter.adapter.mul.MulTypeAdapter;
import mcxtzhang.commonviewgroupadapter.R;
import mcxtzhang.commonviewgroupadapter.scrollview.VipLevelBean;

public class MulTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mul_type);


        ViewGroupUtils.addViews((ViewGroup) findViewById(R.id.activity_mul_type), new MulTypeAdapter<VipLevelBean>(this, initDatas()) {
            @Override
            public void onBindView(ViewGroup parent, View itemView, VipLevelBean data, int pos) {
                TextView tvLevel;
                tvLevel = (TextView) itemView.findViewById(R.id.tvLevel);
                tvLevel.setText(data.getLevel() + "");
            }
        });
    }


    public List<VipLevelBean> initDatas() {
        List<VipLevelBean> datas = new ArrayList<>();
        datas.add(new VipLevelBean(1));
        datas.add(new VipLevelBean(2));
        datas.add(new VipLevelBean(3));
        datas.add(new VipLevelBean(4));
        datas.add(new VipLevelBean(5).setCurrent(true));
        datas.add(new VipLevelBean(6));
        datas.add(new VipLevelBean(7));
        datas.add(new VipLevelBean(8));
        return datas;
    }
}
