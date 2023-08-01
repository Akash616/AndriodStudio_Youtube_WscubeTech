package com.bottomnavbarapp.fragmentexample.StaticWayInFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bottomnavbarapp.fragmentexample.R;

public class DemoTwoFragment extends Fragment {

    public DemoTwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_demo_two, container, false);
        TextView tvFragTwo = view.findViewById(R.id.tvFragTwo);
        //Your set of Instruction here


        return view;
    }
}