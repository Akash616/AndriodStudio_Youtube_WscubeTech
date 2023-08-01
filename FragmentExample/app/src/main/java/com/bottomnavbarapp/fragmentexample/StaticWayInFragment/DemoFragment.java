package com.bottomnavbarapp.fragmentexample.StaticWayInFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bottomnavbarapp.fragmentexample.R;

public class DemoFragment extends Fragment {
    public DemoFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //LayoutInflater => layout ko view mai convert karna hai.
        View view = inflater.inflate(R.layout.fragment_demo, container, false);
        TextView tvFragOne = view.findViewById(R.id.tvFragOne);
        //Your set of Instruction here



        return view;
    }
}