package com.example.addcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addBtn = findViewById(R.id.AddButton);
        Button subtractBtn = findViewById(R.id.subtractBtn);
        Button multiplyBtn = findViewById(R.id.multiplyBtn);
        Button divideBtn = findViewById(R.id.divideBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstNumEditText = findViewById(R.id.Num1EditText);
                EditText SecondNumEditText = findViewById(R.id.Num2EditText);
                TextView resultTestView = findViewById(R.id.ResultTextView);

                if (firstNumEditText.getText().toString().matches("") |SecondNumEditText.getText().toString().matches("") ){
                    resultTestView.setText("Invalid inputs");
                }
                else{
                    double num1 = Double.parseDouble(firstNumEditText.getText().toString());
                    double num2 = Double.parseDouble(SecondNumEditText.getText().toString());
                    double result = num1 + num2;
                    resultTestView.setText(result +"");
                }

            }
        });

                subtractBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstNumEditText = findViewById(R.id.Num1EditText);
                EditText SecondNumEditText = findViewById(R.id.Num2EditText);
                TextView resultTestView = findViewById(R.id.ResultTextView);

                if (firstNumEditText.getText().toString().matches("") | SecondNumEditText.getText().toString().matches("") ){
                    resultTestView.setText("Invalid inputs");
                }
                else {
                    double num1 = Double.parseDouble(firstNumEditText.getText().toString());
                    double num2 = Double.parseDouble(SecondNumEditText.getText().toString());
                    double result = num1 - num2;
                    resultTestView.setText(result +"");
                }
                
            }
        });

                multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstNumEditText = findViewById(R.id.Num1EditText);
                EditText SecondNumEditText = findViewById(R.id.Num2EditText);
                TextView resultTestView = findViewById(R.id.ResultTextView);


                if (firstNumEditText.getText().toString().matches("") | SecondNumEditText.getText().toString().matches("") ){
                    resultTestView.setText("Invalid inputs");
                }
                
                else{
                    double num1 = Double.parseDouble(firstNumEditText.getText().toString());
                    double num2 = Double.parseDouble(SecondNumEditText.getText().toString());
                    double result = num1 * num2;
                    resultTestView.setText(result +"");
                }    
            }
        });

                divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    EditText firstNumEditText = findViewById(R.id.Num1EditText);
                    EditText SecondNumEditText = findViewById(R.id.Num2EditText);
                    TextView resultTestView = findViewById(R.id.ResultTextView);

                    if (firstNumEditText.getText().toString().matches("") | SecondNumEditText.getText().toString().matches("") ){
                        resultTestView.setText("Invalid inputs");
                    }

                    else{

                        double num1 = Double.parseDouble(firstNumEditText.getText().toString());
                        double num2 = Double.parseDouble(SecondNumEditText.getText().toString());

                        if (num2 == 0){
                            resultTestView.setText("Undefined");
                        }
                        else{
                            double result = num1 / num2;
                            resultTestView.setText(result +"");
                        }

                }
                }

        });
    }
}
