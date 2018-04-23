package com.dexter.TeacherTracker;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class time_table extends AppCompatActivity implements View.OnClickListener {
    Intent intent;
    ImageView image;
    TextView text;
    public int var;
    String value;
    Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_table);
        image = (ImageView) findViewById(R.id.image);
        text = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        init();
    }

    private void init() {
        intent = getIntent();
        var =intent.getIntExtra("T1",-1);
        value = Integer.toString(var);
        if(value.equals("1"))
        {
            image.setImageResource(R.drawable.t1);
        }
        else if(value.equals("2"))
        {
            image.setImageResource(R.drawable.t2);
        }
        else if(value.equals("3"))
        {
            image.setImageResource(R.drawable.t3);
        }
        else if(value.equals("4"))
        {
            image.setImageResource(R.drawable.t4);
        }
        else if(value.equals("5"))
        {
            image.setImageResource(R.drawable.t5);
        }
        else if(value.equals("6"))
        {
            image.setImageResource(R.drawable.t6);
        }
        else if(value.equals("7"))
        {
            image.setImageResource(R.drawable.t7);
        }
        else if(value.equals("8"))
        {
            image.setImageResource(R.drawable.t8);
        }
        else if(value.equals("9"))
        {
            image.setImageResource(R.drawable.t1);
        }
        else if(value.equals("10"))
        {
            image.setImageResource(R.drawable.t2);
        }

    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this,MapActivity.class);
        startActivity(i);
    }
}
