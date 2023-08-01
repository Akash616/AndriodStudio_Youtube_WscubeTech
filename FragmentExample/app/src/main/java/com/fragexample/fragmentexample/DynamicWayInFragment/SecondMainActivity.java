package com.fragexample.fragmentexample.DynamicWayInFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.bottomnavbarapp.fragmentexample.R;

public class SecondMainActivity extends AppCompatActivity {

    //--------This is just an example how dynamic way will use--------------------
    //-------Use instead Tab Layout----------------------------------------------

    Button btnFragOne, btnFragTwo, btnFragThree;
    String ROOT_FRAGMENT_TAG = "root_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);

        btnFragOne = findViewById(R.id.btnFragOne);
        btnFragTwo = findViewById(R.id.btnFragTwo);
        btnFragThree = findViewById(R.id.btnFragThree);

        //----------------By default one fragment will open----------------------------------------
        loadFrag(new DynamicDemoFragment(), 0); //root fragment
        //------------------------------------------------------------------------------------------

        btnFragOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                FragmentManager fragmentManager = getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.add(R.id.frameLayout_one, new DynamicDemoFragment());
                  // .remove(), .replace()
//                fragmentTransaction.commit();
                //loadFrag(new DynamicDemoFragment(), 0);
                loadFrag(DynamicDemoFragment.getInstance("Akash Gupta", 25), 0);

            }
        });

        btnFragTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadFrag(new DynamicDemoTwoFragment(), 1);

            }
        });

        btnFragThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadFrag(new DynamicDemoThreeFragment(), 1);

            }
        });

    }

    public void loadFrag(Fragment fragment, int flag){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //---------Data Passing in Fragment----------------------------------------------------------
        //-----Universal Data : bec. we did not set flag value---------------------------------------
//        Bundle bundle = new Bundle();
//        bundle.putString("Name","Akash");
//        bundle.putInt("Age",24);
//        fragment.setArguments(bundle);
        //---------------------------------------------------------------------------------------------

        if(flag == 0) {
            fragmentTransaction.add(R.id.frameLayout_one, fragment);
            //----Jitna bhi Frag. Stack ka andar phele say Frag. hai, Usko pop out karna hai.---------------
            fragmentManager.popBackStack(ROOT_FRAGMENT_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            fragmentTransaction.addToBackStack(ROOT_FRAGMENT_TAG);
            //----------------------------------------------------------------------------------------------
        }
        else {
            fragmentTransaction.replace(R.id.frameLayout_one, fragment);
            //------Managing Fragment BackStack------------------------------------------------------
            fragmentTransaction.addToBackStack(null);
            //---------------------------------------------------------------------------------------
        }

        fragmentTransaction.commit();
    }

    //---Access Activity class method in frag.---------------------------------------
    public void CallFromFragment(){
        Log.d("inAct", "fromFragment");
    }

}