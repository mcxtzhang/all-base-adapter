package mcxtzhang.commonviewgroupadapter.rv.header;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mcxtzhang.commonadapter.rv.CommonAdapter;
import com.mcxtzhang.commonadapter.rv.HeaderFooterAdapter;
import com.mcxtzhang.commonadapter.rv.ViewHolder;

import java.util.List;

import mcxtzhang.commonviewgroupadapter.R;
import mcxtzhang.commonviewgroupadapter.TestBean;

import static mcxtzhang.commonviewgroupadapter.TestBean.initDatas;

public class RvHeaderFooterActivity extends AppCompatActivity {
    private RecyclerView mRv;
    private List<TestBean> mDatas;
    private CommonAdapter mInnerAdapter;
    private HeaderFooterAdapter mHeaderFooterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_header_footer);
        mRv = (RecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mInnerAdapter = new CommonAdapter<TestBean>(this, mDatas = initDatas(), R.layout.item_test) {
            @Override
            public void convert(ViewHolder holder, TestBean testBean) {
                Glide.with(RvHeaderFooterActivity.this)
                        .load(testBean.getAvatar())
                        .into((ImageView) holder.itemView.findViewById(R.id.ivAvatar));
                ((TextView) holder.itemView.findViewById(R.id.tvName)).setText(testBean.getName());
            }
        };
        mHeaderFooterAdapter = new HeaderFooterAdapter(mInnerAdapter);
        mHeaderFooterAdapter.setHeaderView(0, new HeaderBean("点我跳转到多Type界面"));

        mRv.setAdapter(mHeaderFooterAdapter);

    }
}
