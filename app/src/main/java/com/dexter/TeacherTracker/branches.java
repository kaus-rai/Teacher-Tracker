package com.dexter.TeacherTracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;


public class branches extends AppCompatActivity implements View.OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.branches);
        init();
 }

    private void init() {
        ImageButton b1,b2,b3,b4,b5,b6;
        b1= findViewById(R.id.but1);
        b2= findViewById(R.id.but2);
        b3= findViewById(R.id.but3);
        b4= findViewById(R.id.but4);
        b5= findViewById(R.id.but5);
        b6= findViewById(R.id.but6);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
       //Integer i;
        switch(view.getId())
        {
            case R.id.but1:
              //  i=0;
                Intent intent1 = new Intent (this,Teachers.class);
                intent1.putExtra("name","CSE");
                startActivity(intent1);
                break;
            case R.id.but2:
              //  i=1;
                Intent intent2 = new Intent (this,Teachers.class);
                intent2.putExtra("name","Mechanical Engineering");
                startActivity(intent2);
                break;
            case R.id.but3:
              //  i=3;
                Intent intent3 = new Intent (this,Teachers.class);
                intent3.putExtra("name","BCA");
                startActivity(intent3);
                break;
            case R.id.but4:
             //  i=4;
                Intent intent4 = new Intent (this,Teachers.class);
                intent4.putExtra("name","Civil Engineering");
                startActivity(intent4);
                break;
            case R.id.but5:
              // i=4;
                Intent intent5 = new Intent (this,Teachers.class);
                intent5.putExtra("name","ECE");
                startActivity(intent5);
                break;
            case R.id.but6:
             // i=5;
                Intent intent6 = new Intent (this,Teachers.class);
                intent6.putExtra("name","IT");
                startActivity(intent6);
                break;
        }
    }
}

