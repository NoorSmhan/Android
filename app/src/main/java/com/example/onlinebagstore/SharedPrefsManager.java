
package com.example.onlinebagstore;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SharedPrefsManager {

    private static final String PREFS_NAME = "OnlineBagStorePrefs";
    private static SharedPreferences sharedPreferences;

    public static void init(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public static void saveToCart(String itemName) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String existingItemsJson = sharedPreferences.getString("cartItems", "[]");
        Gson gson = new Gson();
        Type type = new TypeToken<List<String>>(){}.getType();
        List<String> cartItems = gson.fromJson(existingItemsJson, type);

        cartItems.add(itemName);

        String updatedItemsJson = gson.toJson(cartItems);
        editor.putString("cartItems", updatedItemsJson);
        editor.apply();
    }

    public static List<String> getFromCart() {
        String existingItemsJson = sharedPreferences.getString("cartItems", "[]");
        Gson gson = new Gson();
        Type type = new TypeToken<List<String>>(){}.getType();
        return gson.fromJson(existingItemsJson, type);
    }
}

