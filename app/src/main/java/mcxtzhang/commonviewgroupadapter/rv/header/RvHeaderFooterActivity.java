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
import com.mcxtzhang.commonadapter.rv.IHeaderHelper;
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
        //1-0 同步静态数据，借助实体类
        mHeaderFooterAdapter.setHeaderView(0, new HeaderBean("1-0 同步静态数据，借助实体类 点我跳转到多Type界面"));
        //1-1 同步静态数据，不借助实体类。
        mHeaderFooterAdapter.setHeaderView(1, new IHeaderHelper() {
            @Override
            public int getItemLayoutId() {
                return R.layout.header_1_1;
            }

            @Override
            public void onBind(ViewHolder holder) {
                holder.setText(R.id.tv1, "1-1  同步静态数据，不借助实体类。");
            }
        });


        mRv.setAdapter(mHeaderFooterAdapter);


        //2-1 异步数据，不借助实体类
        mRv.postDelayed(new Runnable() {
            @Override
            public void run() {
                mHeaderFooterAdapter.setHeaderView(2, new IHeaderHelper() {
                    @Override
                    public int getItemLayoutId() {
                        return R.layout.header_2_1;
                    }

                    @Override
                    public void onBind(ViewHolder holder) {
                        //假装从网络拿到了数据
                        HeaderBean temp = new HeaderBean("2-1 异步数据，不借助实体类");
                        holder.setText(R.id.tv2, temp.getText());
                    }
                });
                mHeaderFooterAdapter.notifyItemInserted(2);
            }
        }, 4000);

    }
}
