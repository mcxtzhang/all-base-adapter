package mcxtzhang.commonviewgroupadapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mcxtzhang.commonviewgroupadapter.databinding.rv.multype.DBMultypeSingleItemActivity;
import mcxtzhang.commonviewgroupadapter.databinding.rv.multype.mulbean.DBMulTypeMulBeanActivity;
import mcxtzhang.commonviewgroupadapter.databinding.rv.single.DBSingleActivity;
import mcxtzhang.commonviewgroupadapter.databinding.viewgroup.DBFlowSwipeActivity;
import mcxtzhang.commonviewgroupadapter.lvgv.GridViewActivity;
import mcxtzhang.commonviewgroupadapter.lvgv.ListViewSingleActivity;
import mcxtzhang.commonviewgroupadapter.rv.RvSingleActivity;
import mcxtzhang.commonviewgroupadapter.rv.header.RvHeaderFooterActivity;
import mcxtzhang.commonviewgroupadapter.rv.header.RvHeaderMulTypeActivity;
import mcxtzhang.commonviewgroupadapter.rv.mul.RvMulTypeMulBeanActivity;
import mcxtzhang.commonviewgroupadapter.viewgroup.fakergrid.FakerGridViewActivity;
import mcxtzhang.commonviewgroupadapter.viewgroup.flowswipe.FlowSwipeActivity;
import mcxtzhang.commonviewgroupadapter.viewgroup.linearlayout.LinearLayoutActivity;
import mcxtzhang.commonviewgroupadapter.viewgroup.multype.MulTypeActivity;
import mcxtzhang.commonviewgroupadapter.viewgroup.multype.mulbean.MulTypeMulBeanActivity;
import mcxtzhang.commonviewgroupadapter.viewgroup.scrollview.ScrollViewDemoActivity;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        //Viewgroup
        findViewById(R.id.btnLinearLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LauncherActivity.this, LinearLayoutActivity.class));
            }
        });

        findViewById(R.id.btnScrollView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LauncherActivity.this, ScrollViewDemoActivity.class));
            }
        });

        findViewById(R.id.btnMulType).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LauncherActivity.this, MulTypeActivity.class));
            }
        });

        findViewById(R.id.btnMulTypeMulBean).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LauncherActivity.this, MulTypeMulBeanActivity.class));
            }
        });

        findViewById(R.id.btnFlowSwipe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LauncherActivity.this, FlowSwipeActivity.class));
            }
        });


        //rv
        findViewById(R.id.btnRvSingle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LauncherActivity.this, RvSingleActivity.class));
            }
        });

        findViewById(R.id.btnRvMulTypeMulBean).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LauncherActivity.this, RvMulTypeMulBeanActivity.class));
            }
        });
        findViewById(R.id.btnRvHeaderFooter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LauncherActivity.this, RvHeaderFooterActivity.class));
            }
        });
        findViewById(R.id.btnRvMulTypeHeaderFooter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LauncherActivity.this, RvHeaderMulTypeActivity.class));
            }
        });


        //lvgv
        findViewById(R.id.btnLvSingle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LauncherActivity.this, ListViewSingleActivity.class));
            }
        });

        findViewById(R.id.btnGvSingle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LauncherActivity.this, GridViewActivity.class));
            }
        });


        findViewById(R.id.btnDBSingle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LauncherActivity.this, DBSingleActivity.class));
            }
        });
        findViewById(R.id.btnDBMulTypeSingleBean).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LauncherActivity.this, DBMultypeSingleItemActivity.class));
            }
        });

        findViewById(R.id.btnDBMulTypeMulBean).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LauncherActivity.this, DBMulTypeMulBeanActivity.class));
            }
        });
        findViewById(R.id.btnDBFlowSwipe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LauncherActivity.this, DBFlowSwipeActivity.class));
            }
        });

        findViewById(R.id.btnFakerGrid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LauncherActivity.this, FakerGridViewActivity.class));
            }
        });


    }
}
