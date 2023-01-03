package com.demo.forevergems;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Ring  extends AppCompatActivity {

    ListView listView;
    String [] mName = {"Silver Ring", "Gold Ring", "No Stone Ring"};
    int[] images = {R.drawable.silverring, R.drawable.goldring, R.drawable.nostonering};

    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.act_ring);

        listView = findViewById(R.id.list_view);

        MyAdapter adapter =  new MyAdapter(this, mName, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(parent, view, posiitiion, id) -> {
            if(position==0){
                startActivity(new Intent Ring.this,SilverR.class));
            }else if(position==1){
                startActivity(new Intent Ring.this,GoldR.class));
            }else if(position==2){
                startActivity(new Intent Ring.this,NoStoneR.class));
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String [] rName;
        int[] rimg;

        MyAdapter (Context c, String[] name, int[] img) {
            super(c, R.layout.ring, R.id.textView1, name);
            this.context = c;
            this.rName = name;
            this.rimg = img;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View ring = layoutInflater.inflate(R.layout.ring, parent, false);
            ImageView images = ring.findViewById(R.id.images);
            TextView myTitle = ring.findViewById(R.id.textView1);

            images.setImageResource(rimg[position]);
            myTitle.setText(rName[position]);

            return ring;
        }
    }
}