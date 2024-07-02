package com.example.instragram;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    ImageView love,message,home,search,add_buton,video,porfile;
    RelativeLayout top_layout;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        top_layout = findViewById(R.id.top_layout);
        love = findViewById(R.id.love);
        message = findViewById(R.id.message);
        home = findViewById(R.id.home);
        search = findViewById(R.id.search);
        add_buton = findViewById(R.id.add_buton);
        video = findViewById(R.id.video);
        porfile = findViewById(R.id.porfile);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment,new Home());
        fragmentTransaction.commit();
        home.setImageResource(R.drawable.home_);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setImageResource(R.drawable.home_);
                search.setImageResource(R.drawable.search);
                add_buton.setImageResource(R.drawable.add);
                video.setImageResource(R.drawable.video);
                top_layout.setVisibility(View.VISIBLE);

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragment,new Home());
                fragmentTransaction.commit();
            }
        });



        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setImageResource(R.drawable.home);
                search.setImageResource(R.drawable.search_);
                add_buton.setImageResource(R.drawable.add);
                video.setImageResource(R.drawable.video);
                top_layout.setVisibility(View.GONE);

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragment,new Search());
                fragmentTransaction.commit();
            }
        });



        add_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setImageResource(R.drawable.home);
                search.setImageResource(R.drawable.search);
                add_buton.setImageResource(R.drawable.add_);
                video.setImageResource(R.drawable.video);
                top_layout.setVisibility(View.GONE);



            }
        });



        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setImageResource(R.drawable.home);
                search.setImageResource(R.drawable.search);
                add_buton.setImageResource(R.drawable.add);
                video.setImageResource(R.drawable.video_);
                top_layout.setVisibility(View.GONE);


                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragment,new Video());
                fragmentTransaction.commit();
            }
        });


        porfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setImageResource(R.drawable.home);
                search.setImageResource(R.drawable.search);
                add_buton.setImageResource(R.drawable.add);
                video.setImageResource(R.drawable.video);
                top_layout.setVisibility(View.GONE);


                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragment,new Profile());
                fragmentTransaction.commit();
            }
        });




    }
}