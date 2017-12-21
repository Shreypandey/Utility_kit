package com.example.shukl.utilitykit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Quiz3 extends AppCompatActivity {
    RadioButton r1,r2,r3,r4;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);
        r1=(RadioButton)findViewById(R.id.radioButton11);
        r2=(RadioButton)findViewById(R.id.radioButton12);
        r3=(RadioButton)findViewById(R.id.radioButton13);
        r4=(RadioButton)findViewById(R.id.radioButton14);
        b1=(Button)findViewById(R.id.button16);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(r1.isChecked())
                    Quiz1.score++;
                else
                    Quiz1.score--;
                Intent i=new Intent(Quiz3.this,Quiz4.class);
                startActivity(i);



            }
        });
    }
}
