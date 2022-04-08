package com.thiago.conversordetemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    EditText mEditText;
    TextView mTextView;
    Button mButton;
    RadioButton mRadioButtonFahrenheit, mRadioButtonKelvin;

    private boolean isEmptyValeu(){
        return TextUtils.isEmpty(mEditText.getText().toString());
    }

    private double calculateFahrenheit(){
        double tempC = Double.parseDouble(mEditText.getText().toString());
        double tempF = (tempC * 9/5) + 32;
        return tempF;
    }

    private double calculateKelvin(){
        double tempC = Double.parseDouble(mEditText.getText().toString());
        double tempK = tempC + 273.15;
        return tempK;
    }

    public String getResult(){
        String result = "0";
        if(mRadioButtonKelvin.isChecked()){
            result = Double.toString(calculateKelvin()) + "K";
        } else {
            result = Double.toString(calculateFahrenheit()) + "F";
        }
        return result;
    }

    private void showResult(){
        if(isEmptyValeu()){
            Toast.makeText(this,"Digite algo", Toast.LENGTH_SHORT).show();
            return;
        }
        mTextView.setText(getResult());
        mEditText.setText("");
    }

    public class ClickMyButton implements View

            .OnClickListener{

        @Override
        public void onClick(View view) {
            showResult();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.editTextInput);
        mTextView = findViewById(R.id.textViewOutput);
        mButton = findViewById(R.id.buttonCalculate);
        mButton.setOnClickListener(new ClickMyButton());

        mRadioButtonFahrenheit=findViewById(R.id.radioButtonFahrenheit);
        mRadioButtonFahrenheit.setChecked(true);

        mRadioButtonKelvin=findViewById(R.id.radioButtonKelvin);

    }
}