package com.example.mipt_lab_2;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private List<Currency> currencyList;
    private String currentFilter = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"onCreate called");

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button filterButton = findViewById(R.id.filterButton);
        Button clearButton = findViewById(R.id.clearButton);
        EditText currencyFilterText = findViewById(R.id.filterEditText);

        filterButton.setOnClickListener(v -> {
            Log.i(TAG,"filter button pressed");
            this.currentFilter = currencyFilterText.getText().toString();
            this.showCurrencies();
        });

        clearButton.setOnClickListener(v -> {
            Log.i(TAG,"clear button pressed");
            this.currentFilter = "";
            currencyFilterText.getText().clear();
            this.showCurrencies();
        });

        // Running asyncrhonous operations on the UI is forbidden, a new thread is needed :]
        new Thread(() -> {
            DataLoader loader = new DataLoader();
            String data = loader.fetchData();

            Parser parser = new Parser();
            this.currencyList = parser.parse(data);

            runOnUiThread(this::showCurrencies);
        }).start();
    }

    private void showCurrencies(){
        Log.i(TAG,"showCurrencies called");
        List<Currency> filteredCurrencies = new ArrayList<>();

        if(currentFilter.isBlank()){
            filteredCurrencies = this.currencyList;
        }else{
            // Filter currencies
            for(Currency currency : this.currencyList){
                if(currency.code.startsWith(this.currentFilter.toUpperCase())){
                    filteredCurrencies.add(new Currency(currency.code, currency.value));
                }
            }
        }

        // Display currencies
        ListView currencyList = findViewById(R.id.currencyList);
        CurrencyAdapter currencyAdapter = new CurrencyAdapter(this,filteredCurrencies);
        currencyList.setAdapter(currencyAdapter);

        if(filteredCurrencies.isEmpty()){
            // Would also be "true" if parser didn't give any data at all, but let's hope the data finds it's way to the user by this point :]
            String noCurrenciesMessage = getString(R.string.no_currencies_error);
            Toast.makeText(this, noCurrenciesMessage, Toast.LENGTH_SHORT).show();
        }
    }
}