package com.rachmatwahid.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    public void resetTotalPrice(View view) {
        totalPrice = 0;
        textViewTotal.setText(totalPrice.toString());
    }
}