package com.mvptest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mvptest.view.ScrollListview;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/9/23.
 */
public class ScrollTestActivity extends BaseActivity {
    @Bind(R.id.list)
    ScrollListview list;

    List<String> data;

    @Override
    protected int setContentViewId() {
        return R.layout.activity_scroll_test;
    }

    @Override
    protected void initGetData() {

        data = new ArrayList<>();
        data.add("A");
        data.add("B");
        data.add("C");
        data.add("D");
        data.add("E");
        data.add("F");
    }

    @Override
    protected void initView() {

        list.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return data.size();
            }

            @Override
            public Object getItem(int position) {
                return data.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater.from(ScrollTestActivity.this).inflate(R.layout.item,null);

                return null;
            }
        });

    }

    @Override
    protected void initData() {

    }
}
