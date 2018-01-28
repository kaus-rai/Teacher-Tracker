package com.dexter.TeacherTracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    TextView name;
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        sp=findViewById(R.id.spinner);
        String[] status={"Available","Busy",};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, status);
        sp.setAdapter(adapter);
        //  name=findViewById(R.id.name1);
       // String username=getIntent().getExtras().getString("name");
        //name.setText(username);
    }
}
