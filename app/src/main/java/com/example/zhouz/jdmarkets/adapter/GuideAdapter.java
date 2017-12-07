package com.example.zhouz.jdmarkets.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 引导页的适配器
 * @author zyl
 * @version 1.0
 * @date 2017/11/23
 */

public class GuideAdapter extends FragmentPagerAdapter {
    
    private List<Fragment> mPagers;
    
    private Context mContext;

    public GuideAdapter(FragmentManager fm) {
        super(fm);
    }

    public GuideAdapter(FragmentManager fm, List<Fragment> pagers, Context context) {
        super(fm);
        mPagers = pagers;
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return mPagers.get(position);
    }

    @Override
    public int getCount() {
        return mPagers==null?0:mPagers.size();
    }
}
