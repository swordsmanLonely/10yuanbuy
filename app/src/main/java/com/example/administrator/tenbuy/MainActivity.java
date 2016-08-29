package com.example.administrator.tenbuy;

import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.tenbuy.base.BaseActivity;
import com.example.administrator.tenbuy.main.deserve.DeserveFragment;
import com.example.administrator.tenbuy.main.homepage.HomepageFragment;
import com.example.administrator.tenbuy.main.mine.MineFragment;
import com.example.administrator.tenbuy.main.tenbuy.TenbuyFragment;
import com.example.administrator.tenbuy.main.tm.TmFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.frame_fl)
    FrameLayout frameFl;
    @BindView(R.id.home_bg_iv)
    ImageView homeBgIv;
    @BindView(R.id.home_bg_tv)
    TextView homeBgTv;
    @BindView(R.id.home_page_image)
    LinearLayout homePageImage;
    @BindView(R.id.tm_bg_iv)
    ImageView tmBgIv;
    @BindView(R.id.tm_bg_tv)
    TextView tmBgTv;
    @BindView(R.id.tm_image)
    LinearLayout tmImage;
    @BindView(R.id.ten_bg_iv)
    ImageView tenBgIv;
    @BindView(R.id.ten_bg_tv)
    TextView tenBgTv;
    @BindView(R.id.ten_image)
    LinearLayout tenImage;
    @BindView(R.id.deserve_bg_iv)
    ImageView deserveBgIv;
    @BindView(R.id.deserve_bg_tv)
    TextView deserveBgTv;
    @BindView(R.id.deserve_image)
    LinearLayout deserveImage;
    @BindView(R.id.user_bg_iv)
    ImageView userBgIv;
    @BindView(R.id.user_bg_tv)
    TextView userBgTv;
    @BindView(R.id.user_image)
    LinearLayout userImage;
    @BindView(R.id.linear)
    LinearLayout linear;
    private HomepageFragment homepageFragment;
    private TmFragment tmFragment;
    private TenbuyFragment tenbuyFragment;
    private DeserveFragment deserveFragment;
    private MineFragment mineFragment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        homepageFragment = new HomepageFragment();
        tmFragment = new TmFragment();
        tenbuyFragment = new TenbuyFragment();
        deserveFragment = new DeserveFragment();
        mineFragment = new MineFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame_fl, homepageFragment)
                .add(R.id.frame_fl, tmFragment)
                .add(R.id.frame_fl, tenbuyFragment)
                .add(R.id.frame_fl, deserveFragment)
                .add(R.id.frame_fl, mineFragment)
                .hide(tmFragment)
                .hide(tenbuyFragment)
                .hide(deserveFragment)
                .hide(mineFragment)
                .commit();
        homeBgIv.setImageResource(R.mipmap.guide_home_on);
        homeBgTv.setTextColor(Color.rgb(255, 21, 138));
    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.home_page_image, R.id.tm_image, R.id.ten_image, R.id.deserve_image, R.id.user_image})
    public void onClick(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        resetButton();
        switch (view.getId()) {
            case R.id.home_page_image:
                transaction.hide(deserveFragment)
                        .hide(mineFragment)
                        .hide(tenbuyFragment)
                        .hide(tmFragment)
                        .show(homepageFragment);
                homeBgIv.setImageResource(R.mipmap.guide_home_on);
                homeBgTv.setTextColor(Color.rgb(255, 21, 138));
                break;
            case R.id.tm_image:
                transaction.hide(deserveFragment)
                        .hide(mineFragment)
                        .hide(tenbuyFragment)
                        .hide(homepageFragment)
                        .show(tmFragment);
                tmBgIv.setImageResource(R.mipmap.guide_sale_on);
                tmBgTv.setTextColor(Color.rgb(255, 21, 138));
                break;
            case R.id.ten_image:
                transaction.hide(deserveFragment)
                        .hide(mineFragment)
                        .hide(homepageFragment)
                        .hide(tmFragment)
                        .show(tenbuyFragment);
                tenBgIv.setImageResource(R.mipmap.guide_10_on);
                tenBgTv.setTextColor(Color.rgb(255, 21, 138));
                break;
            case R.id.deserve_image:
                transaction.hide(homepageFragment)
                        .hide(mineFragment)
                        .hide(tenbuyFragment)
                        .hide(tmFragment)
                        .show(deserveFragment);
                deserveBgIv.setImageResource(R.mipmap.guide_cart_on);
                deserveBgTv.setTextColor(Color.rgb(255, 21, 138));
                break;
            case R.id.user_image:
                transaction.hide(deserveFragment)
                        .hide(homepageFragment)
                        .hide(tenbuyFragment)
                        .hide(tmFragment)
                        .show(mineFragment);
                userBgIv.setImageResource(R.mipmap.guide_account_on);
                userBgTv.setTextColor(Color.rgb(255, 21, 138));
                break;
        }
        transaction.commit();
    }
    private void resetButton() {
        homeBgIv.setImageResource(R.mipmap.guide_home_nm);
        homeBgTv.setTextColor(Color.rgb(102,102,102));
        tmBgIv.setImageResource(R.mipmap.guide_sale_nm);
        tmBgTv.setTextColor(Color.rgb(102,102,102));
        tenBgIv.setImageResource(R.mipmap.guide_10_nm);
        tenBgTv.setTextColor(Color.rgb(102,102,102));
        deserveBgIv.setImageResource(R.mipmap.guide_cart_nm);
        deserveBgTv.setTextColor(Color.rgb(102,102,102));
        userBgIv.setImageResource(R.mipmap.guide_account_nm);
        userBgTv.setTextColor(Color.rgb(102,102,102));
    }
}
