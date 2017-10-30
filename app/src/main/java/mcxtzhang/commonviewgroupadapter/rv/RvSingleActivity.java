package mcxtzhang.commonviewgroupadapter.rv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mcxtzhang.commonadapter.rv.CommonAdapter;
import com.mcxtzhang.commonadapter.rv.ViewHolder;

import java.util.List;

import mcxtzhang.commonviewgroupadapter.R;
import mcxtzhang.commonviewgroupadapter.TestBean;

import static mcxtzhang.commonviewgroupadapter.TestBean.initDatas;

public class RvSingleActivity extends AppCompatActivity {
    private static final String TAG = "zxt";
    private List<TestBean> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_single);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.activity_rv_single);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CommonAdapter<TestBean>(this, mDatas = initDatas(), R.layout.item_test) {
            @Override
            public void convert(ViewHolder holder, TestBean testBean) {
                Glide.with(RvSingleActivity.this)
                        .load(testBean.getAvatar())
                        .into((ImageView) holder.itemView.findViewById(R.id.ivAvatar));
                ((TextView) holder.itemView.findViewById(R.id.tvName)).setText(testBean.getName());
            }
        });


        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                View childAt = recyclerView.getChildAt(0);
                int childLayoutPosition = recyclerView.getChildLayoutPosition(childAt);
                Log.d(TAG, "onTouch() called with: childLayoutPosition = [" + childLayoutPosition );
                Log.d(TAG, "onTouch() called with: top = [" + childAt.getTop() );
                if (childLayoutPosition==0 && childAt.getTop()==recyclerView.getPaddingTop()){
                    Log.e(TAG, "onTouch: 下拉刷新" );
                }else {
                    Log.w(TAG, "onTouch: 不刷新" );
                }


                //Log.d(TAG, "onTouch() called with: recyclerView = [" + recyclerView.get() );
/*                LinearLayoutManager lm = (LinearLayoutManager) recyclerView.getLayoutManager();
                lm.getItemCount();
                lm.getchild*/

                return false;
            }
        });
    }
}
