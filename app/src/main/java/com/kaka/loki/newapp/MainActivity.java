package com.kaka.loki.newapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fresco.initialize(this);



        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        myArrayList();

//        Uri uri = Uri.parse("https://raw.githubusercontent.com/facebook/fresco/master/docs/static/logo.png");
//        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
//        draweeView.setImageURI(uri);


    }

    public void myArrayList() {

        List<String> mArrayListOne = new ArrayList<>();
        List<String>mArrayListTwo = new ArrayList<>();
        List<String>mArrayList3 = new ArrayList<>();
        List<String>mArrayList4 = new ArrayList<>();


        String uriStringOne = "http://25.media.tumblr.com/tumblr_mdaws9x5671r3tn9do1_500.gif";
        String uriStringTwo = "https://www.monkeysfightingrobots.co/wp-content/uploads/2018/03/Screen-Shot-2018-03-16-at-12.20.54-PM.png";
        String uriString3 = "https://www.acurax.com/wp-content/themes/acuraxsite/images/inner_page_bnr.jpg?x21789";
        String uriString4 = "https://upload.wikimedia.org/wikipedia/en/9/93/Burj_Khalifa.jpg";
        //String uriString4 = "https://www.monkeysfightingrobots.co/wp-content/uploads/2018/03/Screen-Shot-2018-03-16-at-12.20.54-PM.png";


        for (int i = 0; i < 10; i++) {

            mArrayListOne.add(i, uriStringOne);
            mArrayListTwo.add(i, uriStringTwo);
            mArrayList3.add(i, uriString3);
            mArrayList4.add(i, uriString4);

            RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(mArrayListOne, mArrayListTwo,mArrayList3,mArrayList4);

            recyclerView.setAdapter(recyclerViewAdapter);

        }
    }
}
