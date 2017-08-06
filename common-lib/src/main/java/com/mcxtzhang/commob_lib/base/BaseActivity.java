package com.mcxtzhang.commob_lib.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.mcxtzhang.commob_lib.R;

/**
 * 介绍：最顶层的Activity
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 2017/8/6.
 */
public abstract class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        getSupportFragmentManager().beginTransaction().replace(R.id.baseFragmentContainer, getFragment()).commitAllowingStateLoss();
    }

    public int getLayoutId() {
        return R.layout.base_activity;
    }

    public abstract Fragment getFragment();
}
