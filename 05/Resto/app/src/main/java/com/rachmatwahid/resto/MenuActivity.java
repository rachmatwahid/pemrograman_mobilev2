package com.rachmatwahid.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
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
}