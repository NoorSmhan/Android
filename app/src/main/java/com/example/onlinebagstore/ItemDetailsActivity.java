
package com.example.onlinebagstore;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);


        TextView itemName = findViewById(R.id.itemName);
        Button addToCartButton = findViewById(R.id.btnAddToCart);



        String itemNameText = getIntent().getStringExtra("item_name");
        itemName.setText(itemNameText);


        addToCartButton.setOnClickListener(v -> {
            SharedPrefsManager.saveToCart(itemNameText);

            Toast.makeText(ItemDetailsActivity.this, "Item added to cart\n", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(ItemDetailsActivity.this, CartActivity.class);
            startActivity(intent);
        });

    }
}

