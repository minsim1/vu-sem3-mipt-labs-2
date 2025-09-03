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

        // fetch buttons from activity
        Button buttonFor0 = findViewById(R.id.buttonFor0);
        Button buttonFor1 = findViewById(R.id.buttonFor1);
        Button buttonFor2 = findViewById(R.id.buttonFor2);
        Button buttonFor3 = findViewById(R.id.buttonFor3);
        Button buttonFor4 = findViewById(R.id.buttonFor4);
        Button buttonFor5 = findViewById(R.id.buttonFor5);
        Button buttonFor6 = findViewById(R.id.buttonFor6);
        Button buttonFor7 = findViewById(R.id.buttonFor7);
        Button buttonFor8 = findViewById(R.id.buttonFor8);
        Button buttonFor9 = findViewById(R.id.buttonFor9);

        Button buttonForAddition = findViewById(R.id.buttonForAddition);
        Button buttonForSubtraction = findViewById(R.id.buttonForSubtraction);
        Button buttonForMultiplication = findViewById(R.id.buttonForMultiplication);
        Button buttonForDivision = findViewById(R.id.buttonForDivision);
        Button buttonForSquareRoot = findViewById(R.id.buttonForSquareRoot);

        Button buttonForDot = findViewById(R.id.buttonForDot);

        Button buttonForEquals = findViewById(R.id.equalsButton);
        Button buttonForBackspace = findViewById(R.id.backspaceButton);
        Button buttonForFullClear = findViewById(R.id.buttonFullClear);
        Button buttonForChangePolarity = findViewById(R.id.buttonChangePolarity);

        TextView display = findViewById(R.id.mainTextView);

        CalculatorWrapper calculator = new CalculatorWrapper(
                display,
                getString(R.string.divByZeroErr),
                getString(R.string.sqrtFromNegNum)
        );

        // connect buttons to calculator
        buttonFor0.setOnClickListener(v -> calculator.inputNumber(0));
        buttonFor1.setOnClickListener(v -> calculator.inputNumber(1));
        buttonFor2.setOnClickListener(v -> calculator.inputNumber(2));
        buttonFor3.setOnClickListener(v -> calculator.inputNumber(3));
        buttonFor4.setOnClickListener(v -> calculator.inputNumber(4));
        buttonFor5.setOnClickListener(v -> calculator.inputNumber(5));
        buttonFor6.setOnClickListener(v -> calculator.inputNumber(6));
        buttonFor7.setOnClickListener(v -> calculator.inputNumber(7));
        buttonFor8.setOnClickListener(v -> calculator.inputNumber(8));
        buttonFor9.setOnClickListener(v -> calculator.inputNumber(9));

        buttonForAddition.setOnClickListener(v -> calculator.inputOperand('+'));
        buttonForSubtraction.setOnClickListener(v -> calculator.inputOperand('-'));
        buttonForMultiplication.setOnClickListener(v -> calculator.inputOperand('*'));
        buttonForDivision.setOnClickListener(v -> calculator.inputOperand('/'));
        buttonForSquareRoot.setOnClickListener(v -> calculator.inputSquareRoot());

        buttonForDot.setOnClickListener(v -> calculator.inputDot());

        buttonForEquals.setOnClickListener(v -> calculator.equals());
        buttonForBackspace.setOnClickListener(v -> calculator.backspace());
        buttonForFullClear.setOnClickListener(v -> calculator.fullClear());
        buttonForChangePolarity.setOnClickListener(v -> calculator.switchPolarity());
    }
}