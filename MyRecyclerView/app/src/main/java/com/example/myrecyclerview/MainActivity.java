package com.example.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView rec;
    static String names[];
    String location[];
    int poster[];
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rec=findViewById(R.id.rv);
        names=getResources().getStringArray(R.array.titles);
        location=getResources().getStringArray(R.array.subtitle);


        poster=new int[]{

                /*<item>AA </item>
        <item>Bahubali</item>
        <item>Chirutha</item>
        <item>Dookudu</item>
        <item>Eega</item>
        <item>Fidha</item>
        <item>GabbarSing</item>
        <item>Hello</item>
        <item>I</item>
        <item>Jayam</item>*/

                R.drawable.aa,
                R.drawable.bahubali,
                R.drawable.chirutha,
                R.drawable.dookudu,
                R.drawable.eega,
                R.drawable.fidha,
                R.drawable.gabbarsingh,
                R.drawable.hello,
                R.drawable.i,
                R.drawable.jayam
        };
        adapter=new MyAdapter(this,names,location,poster);
        rec.setLayoutManager(new LinearLayoutManager(this));
        rec.setAdapter(adapter);
        //4->507(p),518,538,579,591
    }
}