package com.tablayoutapp.tablayoutexample;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerMessengerAdapter extends FragmentPagerAdapter {
    //    Tab Layout(ViewPager - slide wala option milta hai)
    //    ViewPager - jab bhi viewpager ko setup karna hai, apko tab ak Adapter banana hoga.

    //ViewPager Adapter
    public ViewPagerMessengerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        //FragmentManager apko Activity Class mai hi milaga.

    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ChatFragment();
        } else if (position == 1) {
            return new StatusFragment();
        } else { //2
            return new CallsFragment();
        }
    }

    @Override
    public int getCount() {
        return 3; //no. of tabs
    }

    //TAB ka upar title set karna
    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0){
            return "Chats";
        } else if (position==1) {
            return "Status";
        }else {
            return "Calls";
        }
    }

}
