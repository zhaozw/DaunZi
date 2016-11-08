package com.jkt.workdaunzi.fragments;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jkt.workdaunzi.R;
import com.jkt.workdaunzi.adpaters.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements TabLayout.OnTabSelectedListener {


    private TabLayout mTabLayout;
    private ViewPager viewPager;
    private int mPosition;

    public HomeFragment() {
        // Required empty public constructor
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        initViews(inflate);
        initTabLayout();
        initViewPager();
        setListener();
        return inflate;

    }


    private void initTabLayout() {
        String[] tabs = {"直播", "推荐", "视频", "图片", "段子", "精华"};
        for (int i = 0; i < tabs.length; i++) {
            TabLayout.Tab tab = mTabLayout.newTab();
            tab.setText(tabs[i]);
            mTabLayout.addTab(tab);
        }
    }

    private void initViewPager() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new LiveFragment());
        fragments.add(new RecommendFragment());
        fragments.add(new VideoFragment());
        fragments.add(new PictureFragment());
        fragments.add(new duanzifragment());
        fragments.add(new NiceFragment());
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getChildFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(6);
    }

    private void initViews(View inflate) {
        mTabLayout = ((TabLayout) inflate.findViewById(R.id.one_fragment_tabLayout));
        viewPager = ((ViewPager) inflate.findViewById(R.id.one_fragment_viewPager));
    }

    private void setListener() {
        mTabLayout.addOnTabSelectedListener(this);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mPosition = tab.getPosition();
        viewPager.setCurrentItem(mPosition, false);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onResume() {
        super.onResume();
        viewPager.setCurrentItem(mPosition);
    }

}