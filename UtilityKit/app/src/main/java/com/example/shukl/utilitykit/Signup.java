package com.example.shukl.utilitykit;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
       Button b1;
       EditText e1,e2,e3,e4,e5;
       RadioButton m,n;
       RadioGroup g;
       DatePicker d1;
       Boolean check=true;
    int y,mo,d;
       String nam,ph1,mail,pass,cpass,gender,dob,s4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        b1 = (Button)findViewById(R.id.sign);
        e1 = (EditText) findViewById(R.id.name);nam=e1.getText().toString();
        e2 = (EditText) findViewById(R.id.phone1);ph1=e2.getText().toString();
        e3 = (EditText) findViewById(R.id.email);mail=e3.getText().toString();
        e4 = (EditText) findViewById(R.id.password);pass=e4.getText().toString();
        e5 = (EditText) findViewById(R.id.cpassword);cpass=e5.getText().toString();
        m = (RadioButton)findViewById(R.id.radioButton);
        n = (RadioButton)findViewById(R.id.radioButton2);
        d1 = (DatePicker)findViewById(R.id.datePicker);
        g = (RadioGroup)findViewById(R.id.rg1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1 = (EditText) findViewById(R.id.name);
                nam = e1.getText().toString();
                e2 = (EditText) findViewById(R.id.phone1);
                ph1 = e2.getText().toString();
                e3 = (EditText) findViewById(R.id.email);
                mail = e3.getText().toString();
                e4 = (EditText) findViewById(R.id.password);
                pass = e4.getText().toString();
                e5 = (EditText) findViewById(R.id.cpassword);
                cpass = e5.getText().toString();

                check = true;
                if (m.isSelected()) {
                    gender = "Male";
                } else {
                    gender = "Female";
                }

                d = d1.getDayOfMonth();
                mo = d1.getMonth();
                y = d1.getYear();
                dob = "" + d + "" + mo + "" + y + "";
                if (TextUtils.isEmpty(nam)) {
                    e1.setError("This Field is Required");
                    e1.requestFocus();
                    check = false;
                }
                if (TextUtils.isEmpty(ph1)) {
                    e2.setError("This Field is Required");
                    e2.requestFocus();
                    check = false;
                }
                if (TextUtils.isEmpty(mail)) {
                    e3.setError("This Field is Required");
                    e3.requestFocus();
                    check = false;
                }
                if (TextUtils.isEmpty(pass)) {
                    e4.setError("This Field is Required");
                    e4.requestFocus();
                    check = false;
                }
                if (TextUtils.isEmpty(cpass)) {
                    e5.setError("This Field is Required");
                    e5.requestFocus();
                    check = false;
                }
                if (!TextUtils.isEmpty(pass) && pass.length() < 4) {
                    e4.setError("Password is too short");
                    e4.requestFocus();
                    check = false;
                }
                if (!mail.contains("@")) {
                    e3.setError("Invalid Email");
                    e3.requestFocus();
                    check = false;
                }
                if (!pass.equals(cpass)) {
                    e5.setError("Password not matched");
                    e5.requestFocus();
                    check = false;
                }


             if(check) {

                    SQLiteDatabase data1 = openOrCreateDatabase("utility2", MODE_PRIVATE, null);

                 String s6;
                   s6="create table if not exists profile(name varchar, phone varchar, email varchar, dob varchar, gender varchar, password varchar)";
                   data1.execSQL(s6);



                    String s9="select * from profile where phone='"+ph1+"'";

                    Cursor cursor=data1.rawQuery(s9,null);

                    if (cursor.getCount()==0)
                    {
                        String s50="insert into profile values('" + nam + "','" + ph1 + "','" + mail + "','" + dob + "','" + gender + "','" + pass + "')";

                        data1.execSQL(s50);
                        Toast.makeText(Signup.this, "Sign  Completed", Toast.LENGTH_SHORT).show();
                       Intent i = new Intent(Signup.this,Login.class);
                        startActivity(i);
                        finish();
                    }

                   else if (cursor.getCount()>0){Toast.makeText(Signup.this,"Account already exists. !!",Toast.LENGTH_SHORT).show();}

                }


            }
             });

    }
}
