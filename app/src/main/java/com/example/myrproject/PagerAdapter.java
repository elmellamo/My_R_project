package com.example.myrproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(@NonNull FragmentManager fm, int NumOfTabs) {
        super(fm, NumOfTabs);
        this.mNumOfTabs = NumOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new Tab_MyR();
            case 1: return new Tab_Recipe();
            case 2: return new Tab_which();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}