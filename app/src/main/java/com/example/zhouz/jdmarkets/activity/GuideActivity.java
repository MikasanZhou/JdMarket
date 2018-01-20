package com.example.zhouz.jdmarkets.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.commonlib.BaseActivity;
import com.example.commonlib.constants.Constants;
import com.example.zhouz.jdmarkets.R;
import com.example.zhouz.jdmarkets.adapter.GuideAdapter;
import com.example.zhouz.jdmarkets.fragment.GuideFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 引导页
 */
public class GuideActivity extends BaseActivity {

    @BindView(R.id.vp_guide_view_pager)
    ViewPager mGuideViewPager;
    
    private List<Fragment> mPagers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {
        mPagers = new ArrayList<>();
        GuideFragment guideZero = GuideFragment.get(Constants.PAGER_ZERO);
        GuideFragment guideOne = GuideFragment.get(Constants.PAGER_ONE);
        GuideFragment guideTwo = GuideFragment.get(Constants.PAGER_TWO);
        
        mPagers.add(guideZero);
        mPagers.add(guideOne);
        mPagers.add(guideTwo);
        
        
    }

    @Override
    protected void initEvent() {
        
        
        GuideAdapter guideAdapter = new GuideAdapter(getSupportFragmentManager(),mPagers,mContext);
        mGuideViewPager.setAdapter(guideAdapter);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_guide;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        ButterKnife.bind(this);

    }
}
