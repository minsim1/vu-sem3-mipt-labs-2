package com.example.mipt_lab_2;

import android.widget.TextView;

public class CalculatorWrapper extends Calculator {
    private final TextView display;
    CalculatorWrapper(
            TextView display,
            String divBy0ErrMsg,
            String sqrtFromNegNumErrMsg
    ){
        super(
                divBy0ErrMsg,
                sqrtFromNegNumErrMsg
        );
        this.display = display;
        currentOutput = "0";
        this.updateDisplay();
    }

    public void inputNumber(int num){
        super.inputNumber(num);
        this.updateDisplay();
    }

    public void inputDot(){
        super.inputDot();
        this.updateDisplay();
    }

    public void inputOperand(char operand){
        super.inputOperand(operand);
        this.updateDisplay();
    }

    public void equals(){
        super.equals();
        this.updateDisplay();
    }

    public void backspace(){
        super.backspace();
        this.updateDisplay();
    }

    public void fullClear(){
        super.fullClear();
        this.updateDisplay();
    }

    public void switchPolarity(){
        super.switchPolarity();
        this.updateDisplay();
    }

    public void inputSquareRoot(){
        super.inputSquareRoot();
        this.updateDisplay();
    }

    private void updateDisplay(){
        display.setText(this.currentOutput);
    }
}
