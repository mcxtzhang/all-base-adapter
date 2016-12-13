package mcxtzhang.commonviewgroupadapter.databinding.rv.multype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mcxtzhang.commonadapter.databinding.rv.mul.BaseMulTypeBindingAdapter;

import mcxtzhang.commonviewgroupadapter.databinding.ActivityDbBinding;


public class DBMultypeItemActivity extends AppCompatActivity {
    private ActivityDbBinding mBinding;

    private BaseMulTypeBindingAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityDbBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());


    }
}
