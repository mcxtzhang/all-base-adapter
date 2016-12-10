package mcxtzhang.commonviewgroupadapter.multype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import mcxtzhang.commonadapter.ViewGroupUtils;
import mcxtzhang.commonadapter.adapter.mul.IMulTypeHelper;
import mcxtzhang.commonadapter.adapter.mul.MulTypeAdapter;
import mcxtzhang.commonviewgroupadapter.R;

public class MulTypeMulBeanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mul_type_mul_bean);

        List datas = new ArrayList();
        datas.add(new MulBean1("http://p14.go007.com/2014_11_02_05/a03541088cce31b8_1.jpg"));
        datas.add(new MulBean2("张旭童"));

        //多种Item类型：数据结构不同 不传泛型了
        ViewGroupUtils.addViews((ViewGroup) findViewById(R.id.activity_mul_type_mul_bean), new MulTypeAdapter(this, datas) {
            @Override
            public void onBindView(ViewGroup parent, View itemView, IMulTypeHelper data, int pos) {
                switch (data.getItemLayoutId()) {
                    case R.layout.item_mul_1:
                        MulBean1 mulBean1 = (MulBean1) data;
                        Glide.with(MulTypeMulBeanActivity.this)
                                .load(mulBean1.getUrl())
                                .into((ImageView) itemView);
                        break;
                    case R.layout.item_mul_2:
                        MulBean2 mulBean2 = (MulBean2) data;
                        TextView tv = (TextView) itemView;
                        tv.setText(mulBean2.getName());
                }
            }
        });
    }
}
