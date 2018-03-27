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
        Intent i ;
        i = getIntent();
        Branch = findViewById(R.id.Branch);
        String BrancH;
        BrancH = i.getStringExtra("name");
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
                int b=1;
                Intent intent1 = new Intent (this,time_table.class);
                intent1.putExtra("T1",b);
                startActivity(intent1);
                break;
            case R.id.button2:
                int b2=1;
                Intent intent2 = new Intent (this,time_table.class);
                intent2.putExtra("T1",b2);
                startActivity(intent2);

                break;
            case R.id.button3:
                int b3=1;
                Intent intent3 = new Intent (this,time_table.class);
                intent3.putExtra("T1",b3);
                startActivity(intent3);

                break;
            case R.id.button4:
                int b4=1;
                Intent intent4 = new Intent (this,time_table.class);
                intent4.putExtra("T1",b4);
                startActivity(intent4);

                break;
            case R.id.button5:
                int b5=1;
                Intent intent5 = new Intent (this,time_table.class);
                intent5.putExtra("T1",b5);
                startActivity(intent5);

                break;
            case R.id.button6:
                int b6=1;
                Intent intent6 = new Intent (this,time_table.class);
                intent6.putExtra("T1",b6);
                startActivity(intent6);

                break;
            case R.id.button7:
                int b7=1;
                Intent intent7 = new Intent (this,time_table.class);
                intent7.putExtra("T1",b7);
                startActivity(intent7);

                break;

            case R.id.button8:
                int b8=1;
                Intent intent8 = new Intent (this,time_table.class);
                intent8.putExtra("T1",b8);
                startActivity(intent8);

                break;
            case R.id.button9:
                int b9=1;
                Intent intent9 = new Intent (this,time_table.class);
                intent9.putExtra("T1",b9);
                startActivity(intent9);

                break;
            case R.id.button10:
                int b10=1;
                Intent intent10 = new Intent (this,time_table.class);
                intent10.putExtra("T1",b10);
                startActivity(intent10);

                break;

        }
    }
}
