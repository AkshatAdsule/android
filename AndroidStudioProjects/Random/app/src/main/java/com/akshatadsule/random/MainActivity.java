package com.akshatadsule.random;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_generate = findViewById(R.id.button_generate);


        button_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView editText_result = findViewById(R.id.textView_result);
                EditText editText_numberOfSides = findViewById(R.id.editText_sides);

                if (editText_numberOfSides.getText().toString().matches("")){
                    editText_result.setText("Invalid");
                }
                else {
                    int sides = Integer.parseInt(editText_numberOfSides.getText().toString());

                    Random rand = new Random();
                    int diceRoll = rand.nextInt(sides);
                    diceRoll++;
                    String strRoll = String.valueOf(diceRoll);
                    editText_result.setText(strRoll);
                }
            }
        });
    }
}
