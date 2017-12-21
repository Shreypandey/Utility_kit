package com.example.shukl.utilitykit;



import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Locale;


public class Login extends AppCompatActivity {
    private EditText mPhoneView;
    private EditText mPasswordView;
    private Button b1,b2;
    String p, ph;
    static String s43;
    TextToSpeech t1;
    boolean check = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mPhoneView = (EditText) findViewById(R.id.phone);
        mPasswordView = (EditText) findViewById(R.id.editText2);
        b1 = (Button) findViewById(R.id.button2);
        b2 = (Button) findViewById(R.id.button4);
        p = mPasswordView.getText().toString();
        ph = mPhoneView.getText().toString();


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Login.this, Signup.class);
                startActivity(i);
                finish();
            }
        });

        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        p = mPasswordView.getText().toString();
                        ph = mPhoneView.getText().toString();

                        check = true;
                        if (TextUtils.isEmpty(ph)) {
                            mPhoneView.setError("This field is required");
                            mPhoneView.requestFocus();
                            check = false;
                        }


                           if (TextUtils.isEmpty(p)) {
                            mPasswordView.setError("This field is required");
                            mPasswordView.requestFocus();
                            check = false;
                        }


                            if (check) {
                            SQLiteDatabase data = openOrCreateDatabase("utility2", MODE_PRIVATE, null);
                            String s4 = "select * from profile where phone= '" + ph + "'and password='" + p + "'";
                            Cursor cursor = data.rawQuery(s4, null);
                            String s5 = "select * from profile where phone='" + ph + "'";
                            Cursor cursor2=data.rawQuery(s5,null);

                            if (cursor.getCount() == 1)
                            {Intent i1 = new Intent(Login.this, Homepage.class);
                                startActivity(i1);
                                finish();
                                if(cursor.moveToFirst()){
                                    {
                                         s43=cursor.getString(0);

                                        t1.speak("Welcome "+s43,TextToSpeech.QUEUE_FLUSH,null);
                                    }
                                }

                            }
                            else
                            {
                                if (cursor2.getCount() == 0)
                                {
                                    mPhoneView.setError("no user exist");
                                    mPhoneView.requestFocus();

                                }
                                else
                                {
                                    mPasswordView.setError("password incorrect");
                                    mPasswordView.requestFocus();
                                }
                            }

                        }


                    }
                    }  );
        t1=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                t1.setLanguage(Locale.ENGLISH);
                t1.setSpeechRate(0.4f);
            }
        });



}}



