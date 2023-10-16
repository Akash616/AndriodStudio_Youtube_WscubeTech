package com.bottomnavapp.bottomnavexample.noCustomBottomNavViewTwo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bottomnavapp.bottomnavexample.R;

public class SearchTwoFragment extends Fragment {

    public SearchTwoFragment() {
        // Required empty public constructor
    }@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_two, container, false);
    }
}