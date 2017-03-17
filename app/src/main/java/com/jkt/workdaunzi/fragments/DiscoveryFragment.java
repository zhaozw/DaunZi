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
public class DiscoveryFragment extends Fragment implements TabLayout.OnTabSelectedListener {


    private TabLayout mTabLayout;
    private ViewPager viewPager;
    private int mPosition;

    public DiscoveryFragment() {
        // Required empty public constructor
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_descovery, container, false);
        initViews(inflate);
        initTabLayout();
        initViewPager();
        setListener();
        return inflate;

    }


    private void initTabLayout() {
        String[] tabs = {"头条", "娱乐",  "体育", "财经", "科技"
        ,"历史"};
        for (int i = 0; i < tabs.length; i++) {
            TabLayout.Tab tab = mTabLayout.newTab();
            tab.setText(tabs[i]);
            mTabLayout.addTab(tab);
        }
    }

    private void initViewPager() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HeadlineFragment());
        fragments.add(new FunFragment());
        fragments.add(new SportsFragment());
        fragments.add(new FinanceFragment());
        fragments.add(new TechnologyFragment());
        fragments.add(new HistoryFragment());
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getChildFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(6);
    }

    private void initViews(View inflate) {
        mTabLayout = ((TabLayout) inflate.findViewById(R.id.discovery_fragment_tabLayout));
        viewPager = ((ViewPager) inflate.findViewById(R.id.discovery_fragment_viewPager));
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