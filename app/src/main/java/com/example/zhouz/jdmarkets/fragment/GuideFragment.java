package com.example.zhouz.jdmarkets.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhouz.jdmarkets.R;
import com.example.zhouz.jdmarkets.activity.login.LoginActivity;

/**
 * @author
 * @version 1.0
 * @date 2017/11/23
 */

public class GuideFragment extends Fragment {

    private static final String PAGER_TYPE = "pager_type";
    private Context mContext;
    private int mCurrentPager;


    public static GuideFragment get(int switchPage) {
        GuideFragment guideFragment = new GuideFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(PAGER_TYPE, switchPage);
        guideFragment.setArguments(arguments);
        return guideFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null != getArguments()) {
            mCurrentPager = getArguments().getInt(PAGER_TYPE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = null;
        switch (mCurrentPager) {
            case 0:
                view = inflater.inflate(R.layout.guide_pager_zero_layout, container, false);
                break;
            case 1:
                view = inflater.inflate(R.layout.guide_pager_one_layout, container, false);

                break;
            case 2:
                view = inflater.inflate(R.layout.guide_pager_two_layout, container, false);
                view.findViewById(R.id.tv_begin).setOnClickListener(view1 -> {
                    startActivity(new Intent(mContext, LoginActivity.class));
                    getActivity().finish();
                });
                break;
            default:
                break;
        }

        return view;
    }


}
