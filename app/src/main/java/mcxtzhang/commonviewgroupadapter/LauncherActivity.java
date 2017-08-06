package mcxtzhang.commonviewgroupadapter;

import android.support.v4.app.Fragment;

import com.mcxtzhang.commob_lib.base.BaseActivity;

public class LauncherActivity extends BaseActivity {


    @Override
    public Fragment getFragment() {
        return new LauncherFragment();
    }
}
