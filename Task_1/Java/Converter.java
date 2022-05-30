package com.example.android.unitconvertor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Converter extends AppCompatActivity {

    public Spinner dropdownFrom, dropdownTo;
    public TextInputEditText input;
    public TextView result;
    public String inputUnit, outputUnit, inputValue;
    public Double inputValueD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        dropdownFrom = findViewById(R.id.spinnerFromDrop);
        dropdownTo = findViewById(R.id.spinnerToDrop);

        ArrayAdapter<CharSequence> arrayAdapterFrom = ArrayAdapter.createFromResource(this, R.array.unitsFrom, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        arrayAdapterFrom.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        dropdownFrom.setAdapter(arrayAdapterFrom);


        ArrayAdapter<CharSequence> arrayAdapterTo = ArrayAdapter.createFromResource(this, R.array.unitsTo, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        arrayAdapterTo.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        dropdownTo.setAdapter(arrayAdapterTo);

    }

    public void getUnits() {
        dropdownFrom = findViewById(R.id.spinnerFromDrop);
        dropdownTo = findViewById(R.id.spinnerToDrop);


        inputUnit = dropdownFrom.getSelectedItem().toString();
        outputUnit = dropdownTo.getSelectedItem().toString();

    }


    public void convertUnits(View view) {
        getUnits();
        input = findViewById(R.id.value);
        result = findViewById(R.id.getResultText);
        inputValue = input.getText().toString();


        if (inputUnit.equalsIgnoreCase("meter") && outputUnit.equalsIgnoreCase("centimeter")) {
            inputValueD = Double.parseDouble(inputValue);
            double convert = inputValueD * 100;
            result.setText(Double.toString(convert) + "cm");
        } else if (inputUnit.equalsIgnoreCase("grams") && outputUnit.equalsIgnoreCase("kilograms")) {
            inputValueD = Double.parseDouble(inputValue);
            double convert = inputValueD * 0.001;
            result.setText(Double.toString(convert) + "kg");
        } else if (inputUnit.equalsIgnoreCase("minutes") && outputUnit.equalsIgnoreCase("seconds")) {
            inputValueD = Double.parseDouble(inputValue);
            double convert = inputValueD * 60;
            result.setText(Double.toString(convert) + "sec");
        } else if (inputUnit.equalsIgnoreCase("seconds") && outputUnit.equalsIgnoreCase("minutes")) {
            inputValueD = Double.parseDouble(inputValue);
            double convert = inputValueD * (1 / 60);
            result.setText(Double.toString(convert) + "mins");
        } else if (inputUnit.equalsIgnoreCase("kilogram") && outputUnit.equalsIgnoreCase("grams")) {
            inputValueD = Double.parseDouble(inputValue);
            double convert = inputValueD * 1000;
            result.setText(Double.toString(convert) + "gms");
        } else if (inputUnit.equalsIgnoreCase("centimeter") && outputUnit.equalsIgnoreCase("meter")) {
            inputValueD = Double.parseDouble(inputValue);
            double convert = inputValueD * (1 / 100);
            result.setText(Double.toString(convert) + "mtrs");
        } else if (inputUnit.equalsIgnoreCase("litres") && outputUnit.equalsIgnoreCase("milli-litres")) {
            inputValueD = Double.parseDouble(inputValue);
            double convert = inputValueD * 1000;
            result.setText(Double.toString(convert) + "sec");
        } else if (inputValue.isEmpty()) {
            Toast.makeText(this, "Enter value to convert !!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Cannot Convert !!", Toast.LENGTH_SHORT).show();
        }
    }
}
