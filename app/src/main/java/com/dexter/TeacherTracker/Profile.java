package com.dexter.TeacherTracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name=(TextView) findViewById(R.id.name1);
        String username=getIntent().getExtras().getString("name");
        name.setText(username);
    }
}
