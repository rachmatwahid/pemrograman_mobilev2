package com.rachmatwahid.resto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.rachmatwahid.resto.utils.Calculator;

import java.util.HashMap;

public class MenuActivity extends AppCompatActivity {

    private Calculator calculator;

    TextView
            textViewMixedRice,
            textViewFriedRice,
            textViewNoodle,
            textViewMeatball,
            textViewFriedChicken,
            textViewTotal;

    HashMap<String, Integer> priceList = new HashMap();

    Integer mixedRicePrice = 0, friedRicePrice = 0, noodlePrice = 0, meatballPrice = 0, friedChickenPrice = 0, totalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // TODO: 2. Menghubungkan App Bar ke Activity
        setSupportActionBar(findViewById(R.id.appBar));

        calculator = new Calculator();

        priceList.put("Mixed Rice", 10000);
        priceList.put("Fried Rice", 12000);
        priceList.put("Noodle", 9500);
        priceList.put("Meatball", 14000);
        priceList.put("Fried Chicken", 13500);

        textViewMixedRice = findViewById(R.id.textViewMixedRice);
        textViewFriedRice = findViewById(R.id.textViewFriedRice);
        textViewNoodle = findViewById(R.id.textViewNoodle);
        textViewMeatball = findViewById(R.id.textViewMeatball);
        textViewFriedChicken = findViewById(R.id.textViewFriedChicken);
        textViewTotal = findViewById(R.id.textViewTotal);

        textViewTotal.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                showAlertDialog();
                return false;
            }
        });
    }

    // TODO: 6. Menampilkan AlertDialog
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

    public void selectDishes(View view) {
        switch (view.getId()) {
            case R.id.textViewMixedRice:
                mixedRicePrice += priceList.get("Mixed Rice");
                totalPrice = calculator.add(totalPrice, mixedRicePrice);
                break;
            case R.id.textViewFriedRice:
                friedRicePrice += priceList.get("Fried Rice");
                totalPrice = calculator.add(totalPrice, friedRicePrice);
                break;
            case R.id.textViewNoodle:
                noodlePrice += priceList.get("Noodle");
                totalPrice = calculator.add(totalPrice, noodlePrice);
                break;
            case R.id.textViewMeatball:
                meatballPrice += priceList.get("Meatball");
                totalPrice = calculator.add(totalPrice, meatballPrice);
                break;
            case R.id.textViewFriedChicken:
                friedChickenPrice += priceList.get("Fried Chicken");
                totalPrice = calculator.add(totalPrice, friedChickenPrice);
                break;
        }
        textViewTotal.setText(totalPrice.toString());
    }

    public void resetTotalPrice() {
        totalPrice = 0;
        textViewTotal.setText(totalPrice.toString());
    }

    // TODO: 4. Menampilkan Options Menu di Activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    // TODO: 5. Menerima pilihan user di Options Menu
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
}