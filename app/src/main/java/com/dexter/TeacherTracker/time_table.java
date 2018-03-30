package com.dexter.TeacherTracker;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class time_table extends AppCompatActivity{
    Intent intent;
    ImageView image;
    TextView text;
    public int var;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_table);
        image = findViewById(R.id.image);
        text = findViewById(R.id.text);
        init();
    }

    private void init() {
        intent = getIntent();
        var =intent.getIntExtra("T1",-1);
        text.setText(Integer.toString(var));

    }

}
