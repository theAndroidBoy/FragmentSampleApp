package com.example.asim.fragmentsampleapp.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.asim.fragmentsampleapp.R;
import com.example.asim.fragmentsampleapp.data.AndroidImageAssets;

public class AndroidMeActivity extends AppCompatActivity {

    private final String TAG = "flow";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);
        Log.i(TAG, "onCreate: ");

        if (savedInstanceState == null) {
            Log.i(TAG, "onCreate: if savedInstance is null");
            Log.i(TAG, "onCreate: getSupportFragmentManager");
            FragmentManager fragmentManager = getSupportFragmentManager();
            Log.i(TAG, "onCreate: create BodyPartFragment objects");
            BodyPartFragment headFragment = new BodyPartFragment();
            BodyPartFragment bodyFragment = new BodyPartFragment();
            BodyPartFragment legFragment = new BodyPartFragment();

            headFragment.setImageIds(AndroidImageAssets.getHeads());
            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .commit();

            bodyFragment.setImageIds(AndroidImageAssets.getBodies());
            fragmentManager.beginTransaction()
                    .add(R.id.body_container, bodyFragment)
                    .commit();

            legFragment.setImageIds(AndroidImageAssets.getLegs());
            fragmentManager.beginTransaction()
                    .add(R.id.leg_container, legFragment)
                    .commit();
        }

    }//onCreate closing
}
