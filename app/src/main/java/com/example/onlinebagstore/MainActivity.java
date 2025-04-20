
package com.example.onlinebagstore;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText searchEditText;
    private ListView productListView;
    private List<String> productList;
    private List<String> filteredList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchEditText = findViewById(R.id.searchEditText);
        productListView = findViewById(R.id.productListView);

        productList = new ArrayList<>();
        productList.add("YSL - $20 - Quantity: 10");
        productList.add("Coach - $50 - Quantity: 5");
        productList.add("LV - $170 - Quantity: 8");
        productList.add("Gucci - $160 - Quantity: 12");
        productList.add("lacoste - $180 - Quantity: 4");
        productList.add("adidas bag - $200 - Quantity: 6");
        productList.add("Guess - $300 - Quantity: 3");

        filteredList = new ArrayList<>(productList);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, filteredList);
        productListView.setAdapter(adapter);

        productListView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, ItemDetailsActivity.class);
            intent.putExtra("item_name", filteredList.get(position));
            startActivity(intent);
        });

        Button searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(v -> performSearch());

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(v -> {
            String newProduct = "New Brand - $100";
            productList.add(newProduct);
            filteredList.add(newProduct);
            adapter.notifyDataSetChanged();
            Toast.makeText(MainActivity.this, "New product added", Toast.LENGTH_SHORT).show();
        });

        Button goToCartButton = findViewById(R.id.goToCartButton);
        goToCartButton.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void performSearch() {
        String searchQuery = searchEditText.getText().toString().toLowerCase();

        filteredList.clear();

        for (String product : productList) {
            if (product.toLowerCase().contains(searchQuery)) {
                filteredList.add(product);
            }
        }

        adapter.notifyDataSetChanged();
    }
}
