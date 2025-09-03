package com.example.mipt_lab_2;

public class Calculator {
    protected StringBuilder currentInput = new StringBuilder();
    public String currentOutput = "";
    private double firstOperand = 0;
    private String pendingOperator = null;
    private final String divBy0ErrMsg;
    private final String sqrtFromNegNumErrMsg;

    Calculator(
            String divBy0ErrMsg,
            String sqrtFromNegNumErrMsg
    ){
        this.divBy0ErrMsg = divBy0ErrMsg;
        this.sqrtFromNegNumErrMsg = sqrtFromNegNumErrMsg;
        updateOutputText("0");
    }

    public void inputNumber(int num){
        currentInput.append(num);
        updateOutputText(currentInput.toString());
    }

    public void inputDot(){
        if (!currentInput.toString().contains(".")) {
            if (currentInput.length() == 0) currentInput.append("0");
            currentInput.append(".");
            updateOutputText(currentInput.toString());
        }
    }

    public void inputOperand(char operand){
        if (currentInput.length() > 0) {
            firstOperand = Double.parseDouble(currentInput.toString());
            currentInput.setLength(0);
        }
        pendingOperator = String.valueOf(operand);
        updateOutputText(firstOperand + " " + pendingOperator);
    }

    public void equals(){
        if (pendingOperator != null && currentInput.length() > 0) {
            double secondOperand = Double.parseDouble(currentInput.toString());
            double result = 0;

            switch (pendingOperator) {
                case "+": result = firstOperand + secondOperand; break;
                case "-": result = firstOperand - secondOperand; break;
                case "*": result = firstOperand * secondOperand; break;
                case "/":
                    if (secondOperand != 0) result = firstOperand / secondOperand;
                    else {
                        updateOutputText(divBy0ErrMsg);
                        return;
                    }
                    break;
            }

            currentInput.setLength(0);
            currentInput.append(result);
            pendingOperator = null;
            updateOutputText(String.valueOf(result));
        }
    }

    public void backspace(){
        if(currentInput.length() == 0) return;

        // Check if the currentInput only has numbers and maybe a '.'
        if (currentInput.toString().matches("\\d*(\\.\\d*)?")) {
            currentInput.deleteCharAt(currentInput.length() - 1);
            updateOutputText(currentInput.length() == 0 ? "0" : currentInput.toString());
        }
        // Otherwise, the number is large and can not be expressed in a single digit
        // It is shortened using the "E" notation
        // If the user tries to backspace now and makes the last character "E"
        // As soon as he attempts an operation the program crashes :[
        // Just do nothing here.
    }

    public void fullClear(){
        currentInput.setLength(0);
        firstOperand = 0;
        pendingOperator = null;
        updateOutputText("0");
    }

    public void switchPolarity(){
        if (currentInput.length() > 0) {
            if (currentInput.charAt(0) == '-') currentInput.deleteCharAt(0);
            else currentInput.insert(0, "-");
            updateOutputText(currentInput.toString());
        }
    }

    public void inputSquareRoot(){
        if (currentInput.length() > 0) {
            double value = Double.parseDouble(currentInput.toString());
            if (value >= 0) {
                double result = Math.sqrt(value);
                currentInput.setLength(0);
                currentInput.append(result);
                updateOutputText(String.valueOf(result));
            } else {
                updateOutputText(sqrtFromNegNumErrMsg);
            }
        }
    }

    private void updateOutputText(String text){
        // Awkward approach does to previous implementation :[
        currentOutput = text;
    }
}
