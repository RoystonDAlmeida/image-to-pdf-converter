package com.pdfer.imagetopdfconverter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class CustomAdaptor extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;

    ArrayList<File> arraylist;
    clicked cl;
    public CustomAdaptor(Context context, ArrayList<File> arraylist,clicked cl){

        this.context = context;
      layoutInflater=LayoutInflater.from(context);
        this.arraylist=arraylist;
        this.cl=cl;
    }

    interface clicked{
        void onclick(File file);
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        View view1 = layoutInflater.inflate(R.layout.listcustom,null);
        TextView textView = view1.findViewById(R.id.filename);
textView.setText(arraylist.get(i).getName());
        Button button = view1.findViewById(R.id.sshh);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        cl.onclick(arraylist.get(i));
    }
});

        return view1;
    }
}
