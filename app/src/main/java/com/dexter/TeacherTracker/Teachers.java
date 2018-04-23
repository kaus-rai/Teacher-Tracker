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
        Branch = (TextView) findViewById(R.id.Branch);
        String BrancH;
        BrancH = i.getStringExtra("name");
        Branch.setText(BrancH);
        button1= (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2= (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3= (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4= (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button5= (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);
        button6= (Button) findViewById(R.id.button6);
        button6.setOnClickListener(this);
        button7= (Button) findViewById(R.id.button7);
        button7.setOnClickListener(this);
        button8= (Button) findViewById(R.id.button8);
        button8.setOnClickListener(this);
        button9= (Button) findViewById(R.id.button9);
        button9.setOnClickListener(this);
        button10= (Button) findViewById(R.id.button10);
        button10.setOnClickListener(this);

}

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.button1:
                Intent intent1 = new Intent (this,time_table.class);
                intent1.putExtra("T1",1);
                startActivity(intent1);
                break;
            case R.id.button2:
                Intent intent2 = new Intent (this,time_table.class);
                intent2.putExtra("T1",2);
                startActivity(intent2);

                break;
            case R.id.button3:
                Intent intent3 = new Intent (this,time_table.class);
                intent3.putExtra("T1",3);
                startActivity(intent3);

                break;
            case R.id.button4:
                Intent intent4 = new Intent (this,time_table.class);
                intent4.putExtra("T1",4);
                startActivity(intent4);

                break;
            case R.id.button5:
                Intent intent5 = new Intent (this,time_table.class);
                intent5.putExtra("T1",5);
                startActivity(intent5);
                break;
            case R.id.button6:
                Intent intent6 = new Intent (this,time_table.class);
                intent6.putExtra("T1",6);
                startActivity(intent6);
                break;
            case R.id.button7:
                Intent intent7 = new Intent (this,time_table.class);
                intent7.putExtra("T1",7);
                startActivity(intent7);
                break;
            case R.id.button8:
                Intent intent8 = new Intent (this,time_table.class);
                intent8.putExtra("T1",8);
                startActivity(intent8);
                break;
            case R.id.button9:
                Intent intent9 = new Intent (this,time_table.class);
                intent9.putExtra("T1",9);
                startActivity(intent9);
                break;
            case R.id.button10:
                Intent intent10 = new Intent (this,time_table.class);
                intent10.putExtra("T1",10);
                startActivity(intent10);
                break;

        }
    }
}
