package com.example.shukl.utilitykit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Quiz1 extends AppCompatActivity {
    RadioButton r1,r2,r3,r4;
    Button b1;
    static int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
        r1=(RadioButton)findViewById(R.id.radioButton3);
        r2=(RadioButton)findViewById(R.id.radioButton4);
        r3=(RadioButton)findViewById(R.id.radioButton5);
        r4=(RadioButton)findViewById(R.id.radioButton6);
        b1=(Button)findViewById(R.id.button14);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score=0;
                if(r2.isChecked())
                    score++;
                else
                    score--;
                Intent i=new Intent(Quiz1.this,Quiz2.class);
                startActivity(i);



            }
        });

    }}
