package com.dexter.TeacherTracker;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class time_table extends AppCompatActivity{
    Intent intent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_table);
        init();
    }

    private void init() {
        intent = getIntent();
        intent.getIntExtra("T1",-1);



    }
}
