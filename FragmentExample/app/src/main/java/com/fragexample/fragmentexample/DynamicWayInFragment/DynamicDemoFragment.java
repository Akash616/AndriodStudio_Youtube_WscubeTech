package com.fragexample.fragmentexample.DynamicWayInFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bottomnavbarapp.fragmentexample.R;
public class DynamicDemoFragment extends Fragment {

    public static final String ARG1 = "argument1";
    public static final String ARG2 = "argument2";

    public DynamicDemoFragment() {
        // Required empty public constructor
    }

    //------calling this method from Activity class------------------------------------
    public static DynamicDemoFragment getInstance(String value1, int value2){

        DynamicDemoFragment dynamicDemoFragment = new DynamicDemoFragment();

        Bundle bundle = new Bundle();
        bundle.putString(ARG1, value1);
        bundle.putInt(ARG2, value2);

        dynamicDemoFragment.setArguments(bundle);

        return dynamicDemoFragment;
    }
    //-------------------------------------------------------------------------------------

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //----------Getting bundle Data in fragment------------------------------------------------
        if(getArguments()!=null){ //!=null : NullPointerException - crash the APP
            String name = getArguments().getString(ARG1);
            int age = getArguments().getInt(ARG2);

            Log.d("Values from Activity ","Name : "+name+",Age : "+age);

            //--------Calling Activity method from Fragment-----------------------------------------
            ((SecondMainActivity)getActivity()).CallFromFragment();
            //--------------------------------------------------------------------------------------

        }

        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_dynamic_demo, container, false);
        TextView tv_FragThree = view.findViewById(R.id.tv_FragThree);

        return view;
    }
}