package com.example.mnoer.filmku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.example.mnoer.filmku.MainActivity.EXTRA_Rate;
import static com.example.mnoer.filmku.MainActivity.EXTRA_Release;
import static com.example.mnoer.filmku.MainActivity.EXTRA_Title;
import static com.example.mnoer.filmku.MainActivity.EXTRA_Overview;
import static com.example.mnoer.filmku.MainActivity.EXTRA_URL;

public class DetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String title = intent.getStringExtra(EXTRA_Title);
        String overview = intent.getStringExtra(EXTRA_Overview);
        String release = intent.getStringExtra(EXTRA_Release);
        Double rate = intent.getDoubleExtra(EXTRA_Rate, 0);

        ImageView imageView = findViewById(R.id.image_view_detail);
        ImageView imageBg = findViewById(R.id.image_bg_detail);
        TextView textViewTitle = findViewById(R.id.tv_title_detail);
        TextView textViewOverview = findViewById(R.id.tv_overview_detail);
        TextView textViewRelease = findViewById(R.id.tv_release_detail);
        TextView textViewRate = findViewById(R.id.tv_rate_detail);

        Picasso.with(this).load(imageUrl).fit().centerCrop().into(imageView);
        Picasso.with(this).load(imageUrl).fit().centerCrop().into(imageBg);
        textViewTitle.setText(title);
        textViewOverview.setText(overview);
        textViewRelease.setText(release);
        textViewRate.setText("Rating: "+ rate);


    }
}
