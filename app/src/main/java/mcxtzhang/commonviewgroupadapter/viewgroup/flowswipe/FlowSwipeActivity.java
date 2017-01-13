package mcxtzhang.commonviewgroupadapter.viewgroup.flowswipe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mcxtzhang.commonadapter.viewgroup.VGUtil;
import com.mcxtzhang.commonadapter.viewgroup.adapter.base.IViewGroupAdapter;
import com.mcxtzhang.commonadapter.viewgroup.adapter.cache.ViewHolder;
import com.mcxtzhang.commonadapter.viewgroup.adapter.single.SingleAdapter;
import com.mcxtzhang.commonadapter.viewgroup.widget.FlowViewGroup;
import com.mcxtzhang.swipemenulib.SwipeMenuLayout;

import java.util.ArrayList;
import java.util.List;

import mcxtzhang.commonviewgroupadapter.R;

/**
 * 介绍：花式用法 ，自定义的ViewGroup：流式布局。
 * 支持任意ViewGroup的Adapter
 * 搭配
 * 支持任意ViewGroup的侧滑菜单
 * 不一样的酷炫视觉体验
 * <p>
 * <p>
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 16/12/10.
 */
public class FlowSwipeActivity extends AppCompatActivity {
    FlowViewGroup mFlowViewGroup;
    IViewGroupAdapter mAdapter;
    List<FlowBean> mDatas;

    VGUtil mVGUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_menu);
        mFlowViewGroup = (FlowViewGroup) findViewById(R.id.flowLayout);
        mAdapter = new SingleAdapter<FlowBean>(this, mDatas = iniDatas(), R.layout.item_flow) {
            @Override
            public void onBindViewHolder(ViewGroup parent, final ViewHolder holder, final FlowBean data, int pos) {
                TextView tv = holder.getView(R.id.tv);
                tv.setText(data.getTag());
                //点击事件只能在这里设置 因为ItemView是侧滑控件
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(FlowSwipeActivity.this, "点击了:" + data.getTag(), Toast.LENGTH_SHORT).show();
                    }
                });
                //侧滑菜单的事件设置
                holder.setOnClickListener(R.id.btnDel, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mDatas.remove(data);
                        ((SwipeMenuLayout) holder.itemView).quickClose();
                        mVGUtil.bind();
                    }
                });
            }


        };
        mVGUtil = new VGUtil(mFlowViewGroup, mAdapter)
                .bind();

    }

    //没看头
    private List<FlowBean> iniDatas() {
        List<FlowBean> datas = new ArrayList<>();

/*        for (int i=0;i<10;i++){

        }*/
        datas.add(new FlowBean("我也不知道管我什么事的新闻"));
        datas.add(new FlowBean("体育"));

        datas.add(new FlowBean("吃瓜群众喜欢的"));
        datas.add(new FlowBean("军事"));
        datas.add(new FlowBean("娱乐圈"));

        datas.add(new FlowBean("我猜你也许喜欢的吧"));
        datas.add(new FlowBean("八卦"));
        datas.add(new FlowBean("老板让我随便推送的"));
        datas.add(new FlowBean("张旭童的那些事儿"));
        datas.add(new FlowBean("小马可以来了"));
        return datas;
    }
}
