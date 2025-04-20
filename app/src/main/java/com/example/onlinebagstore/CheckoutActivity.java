package com.example.onlinebagstore;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CheckoutActivity extends AppCompatActivity {

    private EditText nameEditText, addressEditText, paymentMethodEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);


        nameEditText = findViewById(R.id.nameEditText);
        addressEditText = findViewById(R.id.addressEditText);
        paymentMethodEditText = findViewById(R.id.paymentMethodEditText);


        Button payButton = findViewById(R.id.payButton);
        payButton.setOnClickListener(v -> {

            String name = nameEditText.getText().toString();
            String address = addressEditText.getText().toString();
            String paymentMethod = paymentMethodEditText.getText().toString();

            if (name.isEmpty() || address.isEmpty() || paymentMethod.isEmpty()) {
                Toast.makeText(CheckoutActivity.this, "\n" +
                        "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(CheckoutActivity.this, "Payment completed successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
