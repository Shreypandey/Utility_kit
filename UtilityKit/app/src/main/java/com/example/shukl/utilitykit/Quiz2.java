package com.example.shukl.utilitykit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Quiz2 extends AppCompatActivity {
    RadioButton r1,r2,r3,r4;
    Button b1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
        r1=(RadioButton)findViewById(R.id.radioButton7);
        r2=(RadioButton)findViewById(R.id.radioButton8);
        r3=(RadioButton)findViewById(R.id.radioButton9);
        r4=(RadioButton)findViewById(R.id.radioButton10);
        b1=(Button)findViewById(R.id.button15);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(r2.isChecked())
                   Quiz1.score++;
                else
                    Quiz1.score--;
                Intent i=new Intent(Quiz2.this,Quiz3.class);
                startActivity(i);
            }
        });
    }}
