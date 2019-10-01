package com.example.dell.simpleapp.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.dell.simpleapp.Fragments.OverDueFragment;
import com.example.dell.simpleapp.Fragments.PatientsFragment;
import com.example.dell.simpleapp.Fragments.ProgressFragment;

/**
 * Created by DELL on 17/09/2019.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int numberOfTabs;
    public PagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new PatientsFragment();
            case 1:
                return new OverDueFragment();
            case 2:
                return new ProgressFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Patients";
            case 1:
                return "Over Due";
            case 2:
                return "Progress";
            default:
                return super.getPageTitle(position);
        }
    }
}
