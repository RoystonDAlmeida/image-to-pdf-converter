package com.pdfer.imagetopdfconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private Button button;

Activity activity ;
private EditText editText1;

    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private EditText editText6;
    private EditText editText7;
    private EditText editText8;
    private EditText editText9;

    private File save;

//String[] str = new String[]{"Name:","Company name:","Address:","Phone:","Email:"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = findViewById(R.id.hrbutton);
        button.setOnClickListener(this);
        editText1=findViewById(R.id.namer);

        editText2=findViewById(R.id.address);
        editText3=findViewById(R.id.city);
        editText4=findViewById(R.id.gmail);
        editText5=findViewById(R.id.phone);
        editText6=findViewById(R.id.skills);
        editText7=findViewById(R.id.certificate);
        editText8=findViewById(R.id.sought);
        editText9=findViewById(R.id.emply);
activity = this;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.hrbutton:

               PdfDocument pdfDocument = new PdfDocument();
                Paint paint = new Paint();
                PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(250, 400, 1).create();
                PdfDocument.Page mypage1 = pdfDocument.startPage(pageInfo);
                Canvas canvas = mypage1.getCanvas();
                //   canvas.drawText("First pdf", 40, 50, paint);
                //canvas.drawBitmap(scaledbitmap,40,20,paint);
                paint.setTextAlign(Paint.Align.CENTER);
                paint.setTextSize(13f);

                canvas.drawText("Job Appplication Form",pageInfo.getPageWidth()/2,20,paint);

                paint.setTextAlign(Paint.Align.LEFT);
                paint.setTextSize(11f);

                canvas.drawText("A- Personal Information",10,45,paint);

                paint.setTextSize(8f);

                canvas.drawText("Full Name:",10,60,paint);
                canvas.drawText(editText1.getText().toString(),50,60,paint);

                canvas.drawText("ADDRESS:",10,80,paint);
                canvas.drawText(editText2.getText().toString(),50,80,paint);

                canvas.drawText("CITY:",10,100,paint);
                canvas.drawText(editText3.getText().toString(),50,100,paint);

                canvas.drawText("Gmail:",10,120,paint);
                canvas.drawText(editText4.getText().toString(),50,120,paint);

                canvas.drawText("Phone number:",10,140,paint);
                canvas.drawText(editText5.getText().toString(),80,140,paint);

                paint.setTextSize(11f);

                canvas.drawText("B- Job Skills & Training:",10,180,paint);

                paint.setTextSize(8f);
                canvas.drawText("Skills:",10,200,paint);
                canvas.drawText(editText6.getText().toString(),50,200,paint);
                canvas.drawText("Certifications:",10,240,paint);
                canvas.drawText(editText7.getText().toString(),70,240,paint);

                paint.setTextSize(11f);
                canvas.drawText("C: How did you learn about our company",10,270,paint);
                paint.setTextSize(8f);

                canvas.drawText("POSITION SOUGHT:",10,300,paint);
                canvas.drawText(editText8.getText().toString(),100,300,paint);

                canvas.drawText("Are you currently employed:",10,320,paint);
                canvas.drawText(editText9.getText().toString(),120,320,paint);



                pdfDocument.finishPage(mypage1);

                File file = activity.getExternalFilesDir("Hrforms");
File file1 = new File(file+"/","info.pdf");
save = file1;
try {
    pdfDocument.writeTo(new FileOutputStream(file1));
}catch (Exception e){
    e.printStackTrace();
}
pdfDocument.close();

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
View view1 = getLayoutInflater().inflate(R.layout.bottom,null);
Button button  = view1.findViewById(R.id.sh);

                button.setOnClickListener(new View.OnClickListener() {
               @Override
                public void onClick(View view) {

                    Uri uri = FileProvider.getUriForFile(MainActivity2.this, MainActivity2.this.getApplicationContext().getPackageName() + ".provider", save);
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


break;
        }


    }
//    class BottomSheetDialog extends BottomSheetDialogFragment{
//      //  @Override
//        public View onCreateView(LayoutInflater layoutInflater, ViewGroup cont){
//
//            Button button = new Button(MainActivity2.this);
//
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    Uri uri = FileProvider.getUriForFile(MainActivity2.this, MainActivity2.this.getApplicationContext().getPackageName() + ".provider", save);
//                    Intent intent1 = new Intent(Intent.ACTION_SEND);
//                    intent1.setType("application/pdf");
//                    intent1.putExtra(Intent.EXTRA_SUBJECT, "Shared");
//                    intent1.putExtra(Intent.EXTRA_STREAM, uri);
//                    startActivity(Intent.createChooser(intent1, "Shared doc"));
//                }
//            });
//
//            return  button;
//        }
//
//    }
}


