package com.pdfer.imagetopdfconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
TextView edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
edt=findViewById(R.id.textView14);
String s="P D F -  C O N V E R T E R";
StringTokenizer str= new StringTokenizer(s);
//String[] strarray=new String[str.countTokens()];
        new Thread(){

            public void run() {

                try {
                    while(str.hasMoreTokens()){
                    edt.append(str.nextToken());
                            Thread.sleep(200);
                    }
                    Intent intent = new Intent(MainActivity.this, Second.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }.start();


    }
}