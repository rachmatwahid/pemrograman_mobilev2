package com.rachmatwahid.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class MenuActivity extends AppCompatActivity {

    TextView textViewMixedRice, textViewFriedRice, textViewNoodle, textViewMeatball, textViewFriedChicken, textViewTotal;

    HashMap<String, Integer> price = new HashMap();

    Integer totalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        price.put("mixedRice", 10000);
        price.put("friedRice", 12000);
        price.put("noodle", 9500);
        price.put("meatball", 14000);
        price.put("friedChicken", 13500);

        textViewMixedRice = findViewById(R.id.textViewMixedRice);
        textViewFriedRice = findViewById(R.id.textViewFriedRice);
        textViewNoodle = findViewById(R.id.textViewNoodle);
        textViewMeatball = findViewById(R.id.textViewMeatball);
        textViewFriedChicken = findViewById(R.id.textViewFriedChicken);
        textViewTotal = findViewById(R.id.textViewTotal);

    }

    public void launchInstagram(View view) {
        Uri uri = Uri.parse("https://www.instagram.com");
        Intent instagramIntent = new Intent(Intent.ACTION_VIEW, uri);
        Intent chooserIntent = Intent.createChooser(instagramIntent, "Follow on Instagram");

        if (instagramIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooserIntent);
        }
    }

    public void launchTwitter(View view) {
        Uri uri = Uri.parse("https://www.twitter.com");
        Intent twitterIntent = new Intent(Intent.ACTION_VIEW, uri);

        if (twitterIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(twitterIntent);
        }
    }

    public void selectDishes(View view) {
        switch (view.getId()) {
            case R.id.textViewMixedRice:
                totalPrice += price.get("mixedRice");
            case R.id.textViewFriedRice:
                totalPrice += price.get("friedRice");
            case R.id.textViewNoodle:
                totalPrice += price.get("noodle");
            case R.id.textViewMeatball:
                totalPrice += price.get("meatball");
            case R.id.textViewFriedChicken:
                totalPrice += price.get("friedChicken");
        }
        textViewTotal.setText(totalPrice);
    }
}