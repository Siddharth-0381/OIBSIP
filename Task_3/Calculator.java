package com.example.android.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Calculator extends AppCompatActivity {

    public TextInputEditText firstNum;
    public TextInputEditText secondNum;
    public TextView result;
    public double fNumber, sNumber;
    public String firstNumber, secondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

    }

    public void getNumber(){
        firstNum = findViewById(R.id.valueOne);
        secondNum = findViewById(R.id.valueTwo);

        firstNumber = firstNum.getText().toString();
        secondNumber = secondNum.getText().toString();

        fNumber = Double.parseDouble(firstNumber);
        sNumber = Double.parseDouble(secondNumber);

    }


    public void addNumbers(View view) {
        getNumber();
        double add = fNumber + sNumber;
        result = findViewById(R.id.result);

        result.setText(Double.toString(add));
    }


    public void substractNumbers(View view) {
        getNumber();
        double sub = fNumber - sNumber;
        result = findViewById(R.id.result);

        result.setText(Double.toString(sub));
    }

    public void multiplyNumbers(View view) {
        getNumber();
        double mul = fNumber * sNumber;
        result = findViewById(R.id.result);

        result.setText(Double.toString(mul));
    }

    public void divideNumbers(View view) {
        getNumber();
        double div = fNumber / sNumber;
        result = findViewById(R.id.result);

        result.setText(Double.toString(div));
    }
}
