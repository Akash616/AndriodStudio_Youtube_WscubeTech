package com.fragexample.fragmentexample.DynamicWayInFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bottomnavbarapp.fragmentexample.R;
public class DynamicDemoTwoFragment extends Fragment {
    public DynamicDemoTwoFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dynamic_demo_two, container, false);
        TextView tv_FragFour = view.findViewById(R.id.tv_FragFour);


        return view;
    }
}