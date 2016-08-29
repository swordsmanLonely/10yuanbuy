package com.example.administrator.tenbuy.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Jensen on 2016/8/12.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId());
        bind = ButterKnife.bind(this);
        initView();
        initData();
    }
    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
