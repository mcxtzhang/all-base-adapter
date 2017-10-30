package mcxtzhang.commonviewgroupadapter.rv.loadmore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mcxtzhang.commonadapter.rv.CommonAdapter;
import com.mcxtzhang.commonadapter.rv.ViewHolder;

import java.util.List;

import mcxtzhang.commonviewgroupadapter.R;
import mcxtzhang.commonviewgroupadapter.TestBean;

import static mcxtzhang.commonviewgroupadapter.TestBean.initDatas;

public class RvLoadingMoreActivity extends AppCompatActivity {
    private RecyclerView mRv;
    private List<TestBean> mDatas;
    private CommonAdapter mInnerAdapter;
    private LoadMoreAdapter mLoadMoreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_header_footer);
        mRv = (RecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mInnerAdapter = new CommonAdapter<TestBean>(this, mDatas = initDatas(), R.layout.item_test) {
            @Override
            public void convert(ViewHolder holder, TestBean testBean) {
                Glide.with(RvLoadingMoreActivity.this)
                        .load(testBean.getAvatar())
                        .into((ImageView) holder.itemView.findViewById(R.id.ivAvatar));
                ((TextView) holder.itemView.findViewById(R.id.tvName)).setText(testBean.getName());
            }
        };
        mLoadMoreAdapter = new LoadMoreAdapter(/*this,*/ mInnerAdapter);
        //mLoadMoreAdapter = new LoadMoreAdapter2(this, mInnerAdapter);
        mRv.setAdapter(mLoadMoreAdapter);
        mLoadMoreAdapter.setLoadMoreListener(new LoadMoreAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                Log.d("TAG", "onLoadMore() called");
                mRv.postDelayed(new Runnable() {
                    int i = 0;

                    @Override
                    public void run() {
                        if (((i++) & 0x1) == 0x0) {
                            mLoadMoreAdapter.setStateError();
                        } else {
                            mLoadMoreAdapter.setStateEmpty();
                        }
                    }
                }, 1000);
            }
        });

    }
}
