package com.example.administrator.tenbuy.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Jensen on 2016/8/12.
 */
public abstract class BaseFragment extends Fragment {
    private Unbinder bind;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container,false);
        bind = ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }
    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayoutId();

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
