package com.example.shukl.utilitykit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class Browser extends AppCompatActivity {
    private EditText e1;
    private Button b1;
    private WebView v1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        b1=(Button)findViewById(R.id.GO);
        e1=(EditText)findViewById(R.id.editText);
        v1=(WebView)findViewById(R.id.webView);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                v1.loadUrl(s1);
            }
        });
    }
}
