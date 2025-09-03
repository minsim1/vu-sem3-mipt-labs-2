package com.example.mipt_lab_2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n") // man nepatinka kai raso erorus >:[[
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button mainButton = findViewById(R.id.mainButton);
        Spinner countTypeSelector = findViewById(R.id.countTypeSelector);
        TextView outputText = findViewById(R.id.outputTextView);
        EditText inputTextBox = findViewById(R.id.mainTextInput);

        mainButton.setOnClickListener(v -> {
            String inputString = inputTextBox.getText().toString();

            if (inputString.isEmpty()) {
                Toast.makeText(
                        getApplicationContext(),
                        getString(R.string.noChars),
                        Toast.LENGTH_LONG
                ).show();
                outputText.setText("");
            } else {
                if (countTypeSelector.getSelectedItem().toString().equals("Count words")) {
                    int numOfWords = StringCounter.countWords(inputString);
                    if (numOfWords == 0) {
                        Toast.makeText(
                                getApplicationContext(),
                                getString(R.string.noWords),
                                Toast.LENGTH_LONG
                        ).show();
                        outputText.setText("");
                    } else {
                        outputText.setText(getString(R.string.foundWords) + numOfWords);
                    }
                } else {
                    int numOfChars = StringCounter.countChars(inputString);
                    if (numOfChars == 0) {
                        // Redundant but whatever
                        Toast.makeText(
                                getApplicationContext(),
                                getString(R.string.noChars),
                                Toast.LENGTH_LONG
                        ).show();
                        outputText.setText("");
                    } else {
                        outputText.setText(getString(R.string.foundChars) + numOfChars);
                    }
                }
            }
        });
    }
}