package com.dexter.TeacherTracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Teachers extends AppCompatActivity implements View.OnClickListener {
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button10;

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
        button1=findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2=findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3=findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4=findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button5=findViewById(R.id.button5);
        button5.setOnClickListener(this);
        button6=findViewById(R.id.button6);
        button6.setOnClickListener(this);
        button7=findViewById(R.id.button7);
        button7.setOnClickListener(this);
        button8=findViewById(R.id.button8);
        button8.setOnClickListener(this);
        button9=findViewById(R.id.button9);
        button9.setOnClickListener(this);
        button10=findViewById(R.id.button10);
        button10.setOnClickListener(this);
}

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.button1:

                break;
            case R.id.button2:

                break;
            case R.id.button3:

                break;
            case R.id.button4:

                break;
            case R.id.button5:

                break;
            case R.id.button6:

                break;
            case R.id.button7:

                break;

            case R.id.button8:

                break;
            case R.id.button9:

                break;
            case R.id.button10:

                break;

        }


    }
}
