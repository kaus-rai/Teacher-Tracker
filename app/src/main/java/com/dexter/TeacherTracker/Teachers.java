package com.dexter.TeacherTracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Teachers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teachers);
        TextView Branch;
        Branch = (TextView) findViewById(R.id.Branch);
        Intent i ;
        i = getIntent();
        String BrancH;
        BrancH = i.getStringExtra("branch");
        Branch.setText(BrancH);
    }
}
