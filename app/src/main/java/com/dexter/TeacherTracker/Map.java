package com.dexter.TeacherTracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import es.situm.sdk.SitumSdk;

public class Map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SitumSdk.init(this);
        setContentView(R.layout.activity_map);

    }
}
