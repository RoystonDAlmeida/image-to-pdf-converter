package com.pdfer.imagetopdfconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;
import java.io.File;
import java.util.ArrayList;

public class Downloads extends AppCompatActivity implements CustomAdaptor.clicked {

  private   ArrayList<File> arrayList = new ArrayList<>();
   private File[] files;
   private ListView listView;
   private CustomAdaptor arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloads);
        Activity activity = this;
listView = findViewById(R.id.list);
        File file = activity.getExternalFilesDir("mypdfs");
        files = file.listFiles();

        arrayAdapter = new CustomAdaptor(this,arrayList,this);
        listView.setAdapter(arrayAdapter);

for (int i=0;i<files.length;i++){

    arrayList.add(files[i]);
arrayAdapter.notifyDataSetChanged();

}

    }

    @Override
    public void onclick(File file) {


        try {
            Uri uri = FileProvider.getUriForFile(Downloads.this, Downloads.this.getApplicationContext().getPackageName() + ".provider", file);
            Intent intent1 = new Intent(Intent.ACTION_SEND);
            intent1.setType("application/pdf");
            intent1.putExtra(Intent.EXTRA_SUBJECT, "Shared");
            intent1.putExtra(Intent.EXTRA_STREAM, uri);
            startActivity(Intent.createChooser(intent1, "Shared doc"));


        }catch (Exception e){
            e.printStackTrace();
        }


    }
}