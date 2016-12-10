package mcxtzhang.commonviewgroupadapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mcxtzhang.commonviewgroupadapter.linearlayout.LinearLayoutActivity;
import mcxtzhang.commonviewgroupadapter.multype.MulTypeActivity;
import mcxtzhang.commonviewgroupadapter.multype.MulTypeMulBeanActivity;
import mcxtzhang.commonviewgroupadapter.scrollview.ScrollViewDemoActivity;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

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


    }
}
