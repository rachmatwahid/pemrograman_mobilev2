package com.rachmatwahid.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class MenuActivity extends AppCompatActivity {

    TextView
            textViewMixedRice,
            textViewFriedRice,
            textViewNoodle,
            textViewMeatball,
            textViewFriedChicken,
            textViewTotal;

    HashMap<String, Integer> price = new HashMap();

    Integer mixedRicePrice = 0, friedRicePrice = 0, noodlePrice = 0, meatballPrice = 0, friedChickenPrice = 0, totalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        price.put("Mixed Rice", 10000);
        price.put("Fried Rice", 12000);
        price.put("Noodle", 9500);
        price.put("Meatball", 14000);
        price.put("Fried Chicken", 13500);

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
                mixedRicePrice += price.get("Mixed Rice");
                totalPrice = countTotalPrice(mixedRicePrice);
                break;
            case R.id.textViewFriedRice:
                friedRicePrice += price.get("Fried Rice");
                totalPrice += countTotalPrice(friedRicePrice);
                break;
            case R.id.textViewNoodle:
                noodlePrice += price.get("Noodle");
                totalPrice += countTotalPrice(noodlePrice);
                break;
            case R.id.textViewMeatball:
                meatballPrice += price.get("Meatball");
                totalPrice += countTotalPrice(meatballPrice);
                break;
            case R.id.textViewFriedChicken:
                friedChickenPrice += price.get("Fried Chicken");
                totalPrice += countTotalPrice(friedChickenPrice);
                break;
        }
        textViewTotal.setText(totalPrice.toString());
    }

    private Integer countTotalPrice(Integer dishPrice) {
        totalPrice += dishPrice;
        return totalPrice;
    }

    public void resetTotalPrice(View view) {
        totalPrice = 0;
        textViewTotal.setText(totalPrice.toString());
    }
}