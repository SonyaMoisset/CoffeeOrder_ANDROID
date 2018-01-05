package com.example.android.coffeeorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mQuantity;
    private final static int mPrice = 5;
    private int mTotalPrice;

    TextView mQuantityCounter;
    TextView mPriceCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkQuantityCounter() {
        mQuantityCounter = findViewById(R.id.quantity_counter);
        if (mQuantityCounter != null) {
            mQuantityCounter.setText(Integer.toString(mQuantity));
        }
    }

    public void addCoffee(View view) {
        mQuantity++;
        checkQuantityCounter();
        setPriceCounter(mQuantity);
    }

    public void removeCoffee(View view) {
        if (mQuantity < 1) return;
        mQuantity--;
        checkQuantityCounter();
        setPriceCounter(mQuantity);
    }

    public void calculatePrice(int quantity) {
        mTotalPrice = mPrice * quantity;
    }

    public void setPriceCounter(int quantity) {
        calculatePrice(quantity);
        mPriceCounter = findViewById(R.id.price_counter);
        mPriceCounter.setText(Integer.toString(mTotalPrice) + "$");
    }

    public void resetAll(View view) {
        mQuantity = 0;
        mTotalPrice = 0;
        checkQuantityCounter();
        setPriceCounter(mTotalPrice);
    }
}
