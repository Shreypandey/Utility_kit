package com.example.shukl.utilitykit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class Quiz_Score extends AppCompatActivity {
private Button b1;
    private RatingBar r1;
    private TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz__score);
        t1=(TextView)findViewById(R.id.textView5);
        t1.setText(""+Quiz1.score);
        r1=(RatingBar)findViewById(R.id.ratingBar);
        float r=0;
        if(Quiz1.score==4){r=5;}
        if(Quiz1.score==3){r=4;}
        if(Quiz1.score==2){r=3;}
        if(Quiz1.score==1){r=2;}
        if(Quiz1.score<0){r=1;}
        if(Quiz1.score<-2){r=0;}

        r1.setRating(r);
        b1=(Button)findViewById(R.id.button9);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent i=new Intent(Quiz_Score.this,Homepage.class);
                startActivity(i);
                finish();
            }
        });
    }
}
