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

public class Bracelet  extends AppCompatActivity {

    ListView listView;
        String [] mName = {"Silver Bracelet", "Gold Bracelet", "No Stone Bracelet"};
        int[] images = {R.drawable.silverbracelet, R.drawable.goldbracelet, R.drawable.nostonebracelet};

        @Override
        protected void onCreate(Bundle savedInstancesState) {
            super.onCreate(savedInstancesState);
            setContentView(R.layout.act_bracelet);

            listView = findViewById(R.id.list_view);

            Bracelet.MyAdapter adapter =  new Bracelet.MyAdapter(this, mName, images);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(parent, view, posiitiion, id) -> {
                if(position==0){
                    startActivity(new Intent Bracelet.this,SilverB.class));
                }else if(position==1){
                    startActivity(new Intent Bracelet.this,GoldB.class));
                }else if(position==2){
                    startActivity(new Intent Bracelet.this,NoStoneB.class));
                }
            });
        }

        class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String [] rName;
        int[] rimg;

        MyAdapter (Context c, String[] name, int[] img) {
            super(c, R.layout.Ring, R.id.textView1, name);
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

