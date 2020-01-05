package com.example.last.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.last.view.PhotoListitem;
import com.example.last.view.PhotoListitem;

public class PhotoListAdapter extends BaseAdapter {

    @Override
    public int getCount() {
        return 10000;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PhotoListitem item;
        if(convertView==null)
          item=( PhotoListitem )convertView;
        else
            item= new PhotoListitem(parent.getContext());
        return  item;
    }
}
