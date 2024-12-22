package com.pdfer.imagetopdfconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Resume extends AppCompatActivity {


    private Button button;


    private EditText editText1;

    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private EditText editText6;
    private EditText editText7;
    private EditText editText8;
    private EditText editText9;
    private EditText editText10;
    private EditText editText11;
    private EditText editText12;
    private EditText editText13;
    private EditText editText14;
    private EditText editText15;
 //   private EditText editText13;

Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        button = findViewById(R.id.res);
        editText1=findViewById(R.id.nam);
        editText2=findViewById(R.id.prof);
        editText3=findViewById(R.id.ml);
        editText4=findViewById(R.id.editTextPhone);
        editText5=findViewById(R.id.ad);
        editText6=findViewById(R.id.linked);
        editText7=findViewById(R.id.s1);
        editText8=findViewById(R.id.s2);
        editText9=findViewById(R.id.s3);
        editText10=findViewById(R.id.e1);
        editText11=findViewById(R.id.e2);
        editText12=findViewById(R.id.e3);
        editText13=findViewById(R.id.c1);
        editText14=findViewById(R.id.c2);
        editText15=findViewById(R.id.c3);

        activity=this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                PdfDocument pdfDocument = new PdfDocument();
                Paint paint = new Paint();
                PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(250, 400, 1).create();
                PdfDocument.Page mypage1 = pdfDocument.startPage(pageInfo);
                Canvas canvas = mypage1.getCanvas();
                paint.setTextAlign(Paint.Align.LEFT);
                paint.setTextSize(13f);
paint.setColor(Color.rgb(21,52,80));
                canvas.drawText(editText1.getText().toString(),10,15,paint);


                paint.setTextSize(10f);
                canvas.drawText(editText2.getText().toString(),10,35,paint);
                paint.setColor(Color.rgb(21,52,80));

                canvas.drawText("Email-address:",10,55,paint);
                paint.setColor(Color.rgb(0,0,0));

                canvas.drawText(editText3.getText().toString(),90,55,paint);

                paint.setColor(Color.rgb(21,52,80));

                canvas.drawText("Phone no.:",10,75,paint);

                canvas.drawText(editText4.getText().toString(),65,75,paint);
                paint.setColor(Color.rgb(21,52,80));

                canvas.drawText("Address:",10,95,paint);
                paint.setColor(Color.rgb(0,0,0));

                canvas.drawText(editText5.getText().toString(),65,95,paint);
                paint.setColor(Color.rgb(21,52,80));

                canvas.drawText("linked in:",10,115,paint);
                paint.setColor(Color.rgb(0,0,0));

                canvas.drawText(editText6.getText().toString(),65,115,paint);

                paint.setColor(Color.rgb(21,52,80));

                canvas.drawText("Skills:",10,135,paint);

                paint.setColor(Color.rgb(0,0,0));

                canvas.drawText(editText7.getText().toString(),10,145,paint);

                canvas.drawText(editText8.getText().toString(),10,160,paint);

                canvas.drawText(editText9.getText().toString(),10,175,paint);
                paint.setColor(Color.rgb(21,52,80));

                canvas.drawText("Work Experiences:",10,185,paint);
                paint.setColor(Color.rgb(0,0,0));

                canvas.drawText("1- "+editText10.getText().toString(),10,200,paint);
                canvas.drawText("2- "+editText11.getText().toString(),10,215,paint);
                canvas.drawText("3- "+editText12.getText().toString(),10,230,paint);
                paint.setColor(Color.rgb(21,52,80));

                canvas.drawText("Education:",10,240,paint);
                paint.setColor(Color.rgb(0,0,0));

                canvas.drawText(editText13.getText().toString(),65,240,paint);

                paint.setColor(Color.rgb(21,52,80));


                canvas.drawText("Certifications:",10,260,paint);
                paint.setColor(Color.rgb(0,0,0));

                canvas.drawText("1- "+editText13.getText().toString(),10,280,paint);
                canvas.drawText("2- "+editText14.getText().toString(),10,295,paint);
                canvas.drawText("3- "+editText15.getText().toString(),10,310,paint);



                pdfDocument.finishPage(mypage1);


                File file = activity.getExternalFilesDir("Resume");
                final File file1 = new File(file+"/","resume.pdf");

                try {
                    pdfDocument.writeTo(new FileOutputStream(file1));
                } catch (IOException e) {
                    e.printStackTrace();
                }
pdfDocument.close();

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Resume.this);
                View view1 = getLayoutInflater().inflate(R.layout.bottom,null);
                Button button  = view1.findViewById(R.id.sh);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Uri uri = FileProvider.getUriForFile(Resume.this, Resume.this.getApplicationContext().getPackageName() + ".provider", file1);
                        Intent intent1 = new Intent(Intent.ACTION_SEND);
                        intent1.setType("application/pdf");
                        intent1.putExtra(Intent.EXTRA_SUBJECT, "Shared");
                        intent1.putExtra(Intent.EXTRA_STREAM, uri);
                        startActivity(Intent.createChooser(intent1, "Shared doc"));
                    }
                });

                //     Button button = new Button(MainActivity2.this);
                bottomSheetDialog.setContentView(view1);
                bottomSheetDialog.show();

            }
        });



    }
}