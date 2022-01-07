package com.rachmatwahid.resto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.rachmatwahid.resto.utils.Calculator;

import java.util.HashMap;

public class MenuActivity extends AppCompatActivity {

    private Calculator calculator;

    TextView textViewTotal;

    HashMap<String, Integer> priceList = new HashMap();

    Integer mixedRicePrice = 0, friedRicePrice = 0, noodlePrice = 0, meatballPrice = 0, friedChickenPrice = 0, totalPrice = 0;

    private int[] dishImages;
    private String[] dishNames;
    private int[] dishPrices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        setSupportActionBar(findViewById(R.id.appBar));

        getListDishes();

        // TODO: 16. Menghubungkan RecyclerView dengan Activity
        RecyclerView recyclerView = findViewById(R.id.recyclerViewMenu);

        // TODO: 17. Menghubungkan Adapter dengan Activity
        DishAdapter dishAdapter = new DishAdapter(dishImages, dishNames, dishPrices);

        // TODO: 18. Menghubungkan RecyclerView dengan Adapter
        recyclerView.setAdapter(dishAdapter);

        // TODO: 19. Menentukan LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dishAdapter.setOnItemClickCallback(this::calculatePriceByPrice);

        calculator = new Calculator();

        textViewTotal = findViewById(R.id.textViewTotal);
        textViewTotal.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                showAlertDialog();
                return false;
            }
        });
    }

    private void showAlertDialog() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("Warning");
        alertBuilder.setMessage("Are you sure you want to reset?");
        alertBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                resetTotalPrice();
            }
        });
        alertBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AlertDialog dialog = alertBuilder.create();
        dialog.show();
    }

    public void resetTotalPrice() {
        totalPrice = 0;
        textViewTotal.setText(totalPrice.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_info:
                Intent infoIntent = new Intent(this, InfoActivity.class);
                startActivity(infoIntent);
                return true;
            case R.id.action_history:
                Intent historyIntent = new Intent(this, HistoryActivity.class);
                startActivity(historyIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // TODO: 1. Mengubah perilaku Back button
    @Override
    public void onBackPressed() {
        finishAffinity();
    }

    // TODO: 15. Mempersiapkan data
    private void getListDishes() {

        int[] images = {
                R.drawable.mixedrice,
                R.drawable.friedchicken,
                R.drawable.noodle,
                R.drawable.meatball,
                R.drawable.friedchicken
        };
        this.dishImages = images;

        String[] names = {
              "Mixed Rice",
              "Fried Rice",
              "Noodle",
              "Meatball",
              "Fried Chicken"
        };
        this.dishNames = names;

        int[] prices = {
                15000,
                12500,
                22000,
                18000,
                11000
        };
        this.dishPrices = prices;
    }

    private void calculatePriceByPrice(int price) {
        totalPrice = calculator.add(price, totalPrice);
        textViewTotal.setText(totalPrice.toString());
    }
}