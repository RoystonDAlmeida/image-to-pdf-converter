package com.pdfer.imagetopdfconverter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.spec.ECField;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Second extends AppCompatActivity implements View.OnClickListener {

    private Button button;
private Activity activity;
private EditText editText;
   // private Button buttonr;

private FloatingActionButton floatingActionButton;
    //private FloatingActionButton floatingActionButton1;
    private FloatingActionButton floatingActionButton2;

private Bitmap bitmap,scaledbitmap;
private  PdfDocument pdfDocument;
private String value;
private File file4;
    private Button button1;
    private Button down;

//private ImageView imageView1;
  //  private ImageView ima;

//private HorizontalScrollView horizontalScrollView;
private LinearLayout linearLayout;
private  File imgpth;
float max1=0f,max2=0f;
boolean turn=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button = findViewById(R.id.create);
        editText = findViewById(R.id.name);
button.setOnClickListener(this);
floatingActionButton=findViewById(R.id.selectfromgall);
        floatingActionButton2=findViewById(R.id.camera);
        floatingActionButton2.setOnClickListener(this);
button1=findViewById(R.id.button);
button1.setOnClickListener(this);
floatingActionButton.setOnClickListener(this);
linearLayout = findViewById(R.id.allimages);
       // floatingActionButton1=findViewById(R.id.share);
        //floatingActionButton1.setOnClickListener(this);
//imageView = findViewById(R.id.imageView);
        //imageView1 = findViewById(R.id.customform);
        //ima = findViewById(R.id.imageView3);
        //ima.setOnClickListener(this);
//imageView1.setOnClickListener(this);
activity = Second.this;
down = findViewById(R.id.download);
//buttonr=findViewById(R.id.rot);
//buttonr.setOnClickListener(this);
down.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.create:
                if (ActivityCompat.checkSelfPermission(Second.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(Second.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

                } else {
                    if (!editText.getText().toString().equals("") && bitmap != null) {


                        if (!editText.getText().toString().equals(value)) {
                            pdfDocument = new PdfDocument();
                            value = editText.getText().toString();
                        }
                        //  pdfDocument = new PdfDocument();
//                        new Thread() {
//                            @Override
//                            public void run() {
//                                // findViewById(R.id.anime).setVisibility(View.VISIBLE);
//
//                                ProgressDialog progressDialog = new ProgressDialog(Second.this);
//                                progressDialog.show();
//                                try {
//                                    Thread.sleep(2000);
//                                    progressDialog.dismiss();
//                                  //  findViewById(R.id.anime).setVisibility(View.INVISIBLE);
//
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//
//
//                        }.start();
                        if(turn) {
                            Paint paint = new Paint();
                            PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder((int) max1, 1300, 1).create();
                            PdfDocument.Page mypage1 = pdfDocument.startPage(pageInfo);
                            Canvas canvas = mypage1.getCanvas();
                            //   canvas.drawText("First pdf", 40, 50, paint);
                            scaledbitmap = Bitmap.createScaledBitmap(bitmap, (int) max1, 1300, true);

                            canvas.drawBitmap(scaledbitmap, 2, 1, paint);
                            pdfDocument.finishPage(mypage1);
                        }
                        if(!turn){
                            Paint paint = new Paint();
                            PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder((int) max1, (int)max2, 1).create();
                            PdfDocument.Page mypage1 = pdfDocument.startPage(pageInfo);
                            Canvas canvas = mypage1.getCanvas();
                            //   canvas.drawText("First pdf", 40, 50, paint);
                            scaledbitmap = Bitmap.createScaledBitmap(bitmap, (int) max1, (int)max2, true);

                            canvas.drawBitmap(scaledbitmap, 2, 1, paint);
                            pdfDocument.finishPage(mypage1);

                        }
                        File file = activity.getExternalFilesDir("mypdfs");
                        File file1 = new File(file + "/" + editText.getText().toString() + ".pdf");
                        file4 = file1;
                        try {
                            pdfDocument.writeTo(new FileOutputStream(file1));
                          //  progressDialog.dismiss();
                            Toast.makeText(this, "Created successfully", Toast.LENGTH_LONG).show();

                        } catch (IOException e) {
                            e.printStackTrace();
                            Toast.makeText(this, "There was some isssue", Toast.LENGTH_LONG).show();

                        }



                        // pdfDocument.close();

                    } else {
                        Toast.makeText(this, "Please enter file name first!", Toast.LENGTH_LONG).show();

                    }

                }
                break;
            case R.id.selectfromgall:
                if (ActivityCompat.checkSelfPermission(Second.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(Second.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 200);

                } else {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 300);
                }
                break;
           /* case R.id.customform:
                Intent intent = new Intent(Second.this, MainActivity2.class);
                startActivity(intent);
                break;

            case R.id.share:
                try {

                    sharefile();

                }
        catch (Exception e){
                    e.printStackTrace();
        }
                break;*/

            case R.id.camera:

                if (ActivityCompat.checkSelfPermission(Second.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(Second.this, new String[]{Manifest.permission.CAMERA}, 300);

                }else{

                    Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if(intent2.resolveActivity(getPackageManager())!=null){

                        File photo = null;
                        try{
                            photo=createimage();

                        }catch (Exception e){
                            e.printStackTrace();
                        }if(photo!=null){

                            Uri uri = FileProvider.getUriForFile(Second.this, Second.this.getApplicationContext().getPackageName() + ".provider", photo);
                           // Intent intent1 = new Intent(Intent.ACTION_SEND);
                           // intent1.setType("application/pdf");
                            intent2.putExtra(MediaStore.EXTRA_OUTPUT,uri);
                            //intent1.putExtra(Intent.EXTRA_STREAM, uri);
                            startActivityForResult(intent2, 600);
                        }

                    }

                }
break;
            case R.id.button:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Create New Pdf");
                builder.setMessage("After creating new file you will not be able to edit this file anymore Click clear and share");

                builder.setPositiveButton("Clear and share", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                        sharefile();

                        if(linearLayout.getChildCount()>0){
                            linearLayout.removeAllViews();
                        }
                        bitmap=null;
                        button.setText("CREATE PDF");
                        value="";
                        editText.setText("");


                    }
                });

                builder.setNegativeButton("Create New", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
dialogInterface.dismiss();
                        if(linearLayout.getChildCount()>0){
                            linearLayout.removeAllViews();
                        }
                        bitmap=null;
                        button.setText("CREATE PDF");
                        value="";
                        editText.setText("");
                    }
                });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();


            break;

            case R.id.download:

      Intent intent5 = new Intent(Second.this,Downloads.class);

      startActivity(intent5);

      break;


           /* case R.id.imageView3:


                Intent intent6 = new Intent(Second.this,Resume.class);

                startActivity(intent6);

                break;*/

           // case R.id.rot:

             //   rotateimg();
               // break;
        }
    }

    private void sharefile() {

try {
    Uri uri = FileProvider.getUriForFile(Second.this, Second.this.getApplicationContext().getPackageName() + ".provider", file4);
    Intent intent1 = new Intent(Intent.ACTION_SEND);
    intent1.setType("application/pdf");
    intent1.putExtra(Intent.EXTRA_SUBJECT, "Shared");
    intent1.putExtra(Intent.EXTRA_STREAM, uri);
    startActivity(Intent.createChooser(intent1, "Shared doc"));

}catch (Exception e){
    e.printStackTrace();
}

}

    private File createimage() throws IOException {

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imagefilename = "JPEG_"+timestamp+"_";
        File storagedir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imagefilename,".jpg",storagedir);

        //imgpth = image.getAbsolutePath();
imgpth=image;
        return image;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==300 && resultCode==RESULT_OK && data!=null) {
            Uri uri = data.getData();

            try {
//String[] filepath = {MediaStore.Images.Media.RELATIVE_PATH};
//Cursor cursor = getContentResolver().query(uri,filepath,null,null,null);
//cursor.moveToFirst();
//int column = cursor.getColumnIndex(filepath[0]);
//String mypath = cursor.getString(column);
//cursor.close();
                bitmap= MediaStore.Images.Media.getBitmap(activity.getContentResolver(),uri);
                max1=Math.max(bitmap.getWidth(),max1);
                max2=Math.max(bitmap.getHeight(),max2);
turn=false;
//                BitmapFactory.Options options = new BitmapFactory.Options();
//                options.inScaled=false;
//                int width=bitmap.getWidth();
//                int height = bitmap.getHeight();

//float ratio = Math.min((float)525/bitmap.getWidth(),(float)525/bitmap.getHeight());

              //  height=Math.round((float)ratio*bitmap.getHeight());


          //      scaledbitmap=BitmapFactory.decodeResource(activity.getResources(),path,options);
                //imageView.setImageBitmap(bitmap);

                if(linearLayout.getChildCount()>0){
                    linearLayout.removeAllViews();
                }
                ImageView imageView = new ImageView(Second.this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(640,640);
                imageView.setLayoutParams(layoutParams);
                imageView.setImageBitmap(bitmap);
                linearLayout.addView(imageView);
               // if(buttonr.getVisibility()==View.GONE) {
                 //   buttonr.setVisibility(View.VISIBLE);
                //}
                button.setText("Add image to "+editText.getText().toString()+" pdf");
                findViewById(R.id.anime).setVisibility(View.VISIBLE);


            } catch (Exception e) {
e.printStackTrace();
            }

        }

       else if(requestCode == 600 && resultCode==RESULT_OK){

            try{

                Uri uri = Uri.fromFile(imgpth);

                BitmapFactory.Options options= new BitmapFactory.Options();
                options.inJustDecodeBounds=true;
                BitmapFactory.decodeFile(imgpth.getAbsolutePath(),options);

                options.inSampleSize=calsample(options);
                options.inJustDecodeBounds=false;


                bitmap=BitmapFactory.decodeFile(imgpth.getAbsolutePath(),options);

                max1=options.outWidth;
                max2=options.outHeight;
                        //MediaStore.Images.Media.getBitmap(activity.getContentResolver(),uri);


turn=true;
                if(linearLayout.getChildCount()>0){
                    linearLayout.removeAllViews();
                }
                ImageView imageView = new ImageView(Second.this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(640,640);
                imageView.setLayoutParams(layoutParams);
                imageView.setImageBitmap(bitmap);
                linearLayout.addView(imageView);
                button.setText("Add image to "+editText.getText().toString()+" pdf");

              //  if(buttonr.getVisibility()==View.GONE) {
                //    buttonr.setVisibility(View.VISIBLE);
                //}
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this,"cant",Toast.LENGTH_LONG).show();

            }


        }
    }

    private void rotateimg() {

        if (bitmap != null) {

            Matrix matrix = new Matrix();
            matrix.postRotate(90);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, (int) max1, (int) max2, matrix, true);
            if (linearLayout.getChildCount() > 0) {
                linearLayout.removeAllViews();
            }
            ImageView imageView = new ImageView(Second.this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(640, 640);
            imageView.setLayoutParams(layoutParams);
            imageView.setImageBitmap(bitmap);
            linearLayout.addView(imageView);
//buttonr.setVisibility(View.GONE);
        }
        else{
            Toast.makeText(this,"No image selected",Toast.LENGTH_LONG).show();

        }
    }

    private int calsample(BitmapFactory.Options options) {
        int scalesize=1;
        int photowidth=options.outWidth;
        int photoheight=options.outHeight;

        int reqwidth=620;
        int reqheight=420;
        if(photowidth>reqheight || photoheight>reqheight){
            int haftheight=photoheight/2;
            int halfwidthj=photowidth/2;


            while(halfwidthj/scalesize>=reqwidth && haftheight/scalesize>=reqheight){
                scalesize*=2;
            }
        }
       return scalesize;


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        if(requestCode==100 && grantResults[0]==PackageManager.PERMISSION_GRANTED){

            Toast.makeText(this,"Permission granted",Toast.LENGTH_LONG).show();

        }else if(requestCode==200 && grantResults[0]==PackageManager.PERMISSION_GRANTED){

            Toast.makeText(this,"Permission granted",Toast.LENGTH_LONG).show();

        }else if(requestCode==300 && grantResults[0]==PackageManager.PERMISSION_GRANTED){

            Toast.makeText(this,"Camera Permission granted",Toast.LENGTH_LONG).show();

        }


    }
}
