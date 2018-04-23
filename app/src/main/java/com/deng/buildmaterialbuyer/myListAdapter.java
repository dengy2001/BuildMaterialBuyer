package com.deng.buildmaterialbuyer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Dengyong on 2017-11-26.
 */

public class myListAdapter extends BaseAdapter {

    private List<String> mMyList;
    private LayoutInflater mInflater;


    public myListAdapter(Context context,List<String> myList) {
        mMyList = myList;
        // 使用当前要使用的界面对象context去初始化布局装载器对象mInflater
        mInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return mMyList.size();
    }

    @Override
    public Object getItem(int i) {
        return mMyList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = mInflater.inflate(R.layout.fragment_tab_content, null);

        return view;

    }
}
