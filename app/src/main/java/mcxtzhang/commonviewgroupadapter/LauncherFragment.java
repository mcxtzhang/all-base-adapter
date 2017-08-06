package mcxtzhang.commonviewgroupadapter;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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


/**
 * A simple {@link Fragment} subclass.
 */
public class LauncherFragment extends Fragment {
    View rootView;


    public LauncherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.activity_launcher, container, false);
        //Viewgroup
        findViewById(R.id.btnLinearLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LinearLayoutActivity.class));
            }
        });

        findViewById(R.id.btnScrollView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ScrollViewDemoActivity.class));
            }
        });

        findViewById(R.id.btnMulType).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MulTypeActivity.class));
            }
        });

        findViewById(R.id.btnMulTypeMulBean).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MulTypeMulBeanActivity.class));
            }
        });

        findViewById(R.id.btnFlowSwipe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), FlowSwipeActivity.class));
            }
        });


        //rv
        findViewById(R.id.btnRvSingle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), RvSingleActivity.class));
            }
        });

        findViewById(R.id.btnRvMulTypeMulBean).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), RvMulTypeMulBeanActivity.class));
            }
        });
        findViewById(R.id.btnRvHeaderFooter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), RvHeaderFooterActivity.class));
            }
        });
        findViewById(R.id.btnRvMulTypeHeaderFooter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), RvHeaderMulTypeActivity.class));
            }
        });


        //lvgv
        findViewById(R.id.btnLvSingle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ListViewSingleActivity.class));
            }
        });

        findViewById(R.id.btnGvSingle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), GridViewActivity.class));
            }
        });


        findViewById(R.id.btnDBSingle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), DBSingleActivity.class));
            }
        });
        findViewById(R.id.btnDBMulTypeSingleBean).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), DBMultypeSingleItemActivity.class));
            }
        });

        findViewById(R.id.btnDBMulTypeMulBean).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), DBMulTypeMulBeanActivity.class));
            }
        });
        findViewById(R.id.btnDBFlowSwipe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), DBFlowSwipeActivity.class));
            }
        });

        findViewById(R.id.btnFakerGrid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), FakerGridViewActivity.class));
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

    public View findViewById(int resId) {
        return rootView.findViewById(resId);
    }

}
