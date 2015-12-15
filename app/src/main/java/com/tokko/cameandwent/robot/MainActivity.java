package com.tokko.cameandwent.robot;

import android.os.Bundle;

import roboguice.activity.RoboActionBarActivity;


public class MainActivity extends RoboActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, ToggleLedFragment.newInstance()).commit();
    }



}
