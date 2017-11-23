package com.example.commonlib.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author
 * @version 1.0
 * @date 2017/11/23
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    private List<T> mData;
    
    private Context mContext;
    
    private LayoutInflater mLayoutInflater;


    public BaseAdapter(List<T> data, Context context) {
        mData = data;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(getLayoutId(),parent,false);
        BaseViewHolder viewHolder = getViewHolder(view);
        return  viewHolder;
    }



    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        convert(holder,mData.get(position),position);
    }


    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    /**
     * 获取布局
     */
    protected abstract int getLayoutId();

    /**
     * 获取ViewHolder
     */
    protected abstract BaseViewHolder getViewHolder(View view);

    /**
     * binder 数据
     */
    protected abstract void convert(BaseViewHolder holder, T t, int position);

}
