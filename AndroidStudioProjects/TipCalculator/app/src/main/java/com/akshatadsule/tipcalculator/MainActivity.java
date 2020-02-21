package com.akshatadsule.tipcalculator;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //TODO on keyboard close/editText change

    //for tipAmount SeekBar
    private SeekBar tipAmount;
    private TextView currentPercent;
    private int retval = 0;
    private int max_tip = 25;


    //for numberOfPeople Seek Bar
    private SeekBar numberOfPeople;
    private TextView currentNumberOfPeople;
    private int peopleRetval = 1;
    private int max_people = 10;

    //other views
    private EditText total;
    private TextView resultPerPerson;
    private TextView resultTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        total = findViewById(R.id.editText_cost);
        resultPerPerson = findViewById(R.id.textView_resultPerPerson);
        resultTotal = findViewById(R.id.textView_resultTotal);

        currentPercent = findViewById(R.id.textView_currentPercent);
        tipAmount = findViewById(R.id.seekBar_tip);
        tipAmount.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                retval = progress;
                currentPercent.setText(""+progress+"%");
                calculateTip();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(tipAmount.getProgress() == max_tip && !(max_tip == 100)){
                    tipAmount.setMax(max_tip+25);
                    max_tip+=25;
                }
                else if(tipAmount.getProgress() == 0 && max_tip >= 25){
                    tipAmount.setMax(max_tip-25);
                    max_tip-=25;
                }
            }
        });

        numberOfPeople = findViewById(R.id.seekBar_numberOfPeople);
        numberOfPeople.setMin(1);
        currentNumberOfPeople = findViewById(R.id.textView_numberOfPeople);

        numberOfPeople.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress == 1){
                    currentNumberOfPeople.setText(progress + " person");
                }
                else{
                    currentNumberOfPeople.setText(progress + " people");
                }
                peopleRetval = progress;
                calculateTip();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (numberOfPeople.getProgress() == max_people){
                    numberOfPeople.setMax(max_people+10);
                    max_people = max_people+10;
                }
                else if (numberOfPeople.getProgress() ==1 && max_people>10){
                    numberOfPeople.setMax(max_people-10);
                    max_people-=10;
                    numberOfPeople.setProgress(max_people/2);
                }
            }
        });

        total.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                calculateTip();
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculateTip();
            }
            @Override
            public void afterTextChanged(Editable s) {
                calculateTip();
            }
        });

    }

    private void calculateTip(){
        if(!(currentNumberOfPeople.equals(0)) && !(total.getText().toString().matches("") && !(total.getText() == null))){
            double cost = Double.parseDouble(total.getText().toString());
            //double numberOfPeople = Double.parseDouble(currentNumberOfPeople.getText().toString());
            double numberOfPeople = peopleRetval;
            double tipAmount = retval;
            double tipPercent = tipAmount/100;
            double result = (cost*(1+tipPercent));
            double tipPerPerson = result/numberOfPeople;

            DecimalFormat df = new DecimalFormat("#0.00");

            resultPerPerson.setText("Total per person is $"+  df.format(tipPerPerson));
            resultTotal.setText("Total is $" + df.format(result));

        }
    }
}
