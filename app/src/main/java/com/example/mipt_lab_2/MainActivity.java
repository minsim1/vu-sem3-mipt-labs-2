package com.example.mipt_lab_2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        Button changeColorButton = findViewById(R.id.changeColorButton);
        Button revealButton = findViewById(R.id.mainButton);
        TextView mainTextView = findViewById(R.id.mainTextView);

        revealButton.setOnClickListener(v ->
                mainTextView.setText(getString(R.string.textOnButtonClick))
        );

        changeColorButton.setOnClickListener(v ->
            mainTextView.setTextColor(getColor(R.color.blue))
        );
    }
}