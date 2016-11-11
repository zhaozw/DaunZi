package com.jkt.workdaunzi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.jkt.workdaunzi.fragments.CountFragment;
import com.jkt.workdaunzi.fragments.DiscoveryFragment;
import com.jkt.workdaunzi.fragments.HomeFragment;
import com.jkt.workdaunzi.tool.CustomToast;

import cn.sharesdk.framework.ShareSDK;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private Fragment beforeFragment;
    private RadioGroup mRadioGroup;
    private HomeFragment mHomeFragment;
    private DiscoveryFragment mDescoveryFragment;
    private CountFragment mCountFragment;
    private long mTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ShareSDK.initSDK(getApplicationContext());
        initViews();
        initFragments();
        initChoose();
        initListeners();
    }

    private void initFragments() {
        mHomeFragment = new HomeFragment();
        mDescoveryFragment = new DiscoveryFragment();
        mCountFragment = new CountFragment();
    }

    private void initChoose() {
        changeFragment(mHomeFragment);
    }

    private void initListeners() {
        mRadioGroup.setOnCheckedChangeListener(this);
    }


    private void initViews() {
        setContentView(R.layout.activity_main);
        mRadioGroup = (RadioGroup) findViewById(R.id.m_radio);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.m_button0:
                changeFragment(mHomeFragment);
                break;
            case R.id.m_button1:
                changeFragment(mDescoveryFragment);
                break;
            case R.id.m_button2:
                changeFragment(mCountFragment);
                break;
        }
    }

    private void changeFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragment.isAdded()) {
            if (beforeFragment != null) {
                transaction.hide(beforeFragment);
            }
            transaction.show(fragment);
        } else {
            if (beforeFragment != null) {
                transaction.hide(beforeFragment);
            }
            transaction.add(R.id.m_container, fragment);
            transaction.show(fragment);
        }
        transaction.commit();
        beforeFragment = fragment;
    }

    @Override
    public void onBackPressed() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - mTime > 2000) {
            CustomToast.getToast(this, "再按一次退出").show();
            mTime = currentTimeMillis;
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ShareSDK.stopSDK(getApplicationContext());
    }
}