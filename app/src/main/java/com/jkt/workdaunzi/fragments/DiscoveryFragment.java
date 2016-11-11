package com.jkt.workdaunzi.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jkt.workdaunzi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoveryFragment extends Fragment {


    public DiscoveryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_descovery, container, false);
        return inflate;
    }

}
