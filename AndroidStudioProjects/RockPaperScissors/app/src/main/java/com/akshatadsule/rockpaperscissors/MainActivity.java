package com.akshatadsule.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btn_rock = findViewById(R.id.imageButton_rock);
        ImageButton btn_paper = findViewById(R.id.imageButton_paper);
        ImageButton btn_scissor = findViewById(R.id.imageButton_scissor);

        btn_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            TextView textView_result = findViewById(R.id.textView_result);
            TextView textView_compChoice = findViewById(R.id.textView_computerChose);
            String compChoice = computerChoice();
            String result;

            if (compChoice.equals("rock")){
                result = "Tie!";
            }
            else if (compChoice.equals("paper")){
                result = "You lost!";
            }
            else {
                result = "You won!";
            }

            textView_result.setText(result);
            textView_compChoice.setText("The computer chose: "+ compChoice + ".");

        }
        });

        btn_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            TextView textView_result = findViewById(R.id.textView_result);
            TextView textView_compChoice = findViewById(R.id.textView_computerChose);
            String compChoice = computerChoice();
            String result;

            if (compChoice.equals("rock")){
                result = "You Won";
            }
            else if (compChoice.equals("paper")){
                result = "Tie!";
            }
            else {
                result = "You lost!";
            }

            textView_result.setText(result);
            textView_compChoice.setText("The computer chose: "+ compChoice + ".");

            }
        });

        btn_scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            TextView textView_result = findViewById(R.id.textView_result);
            TextView textView_compChoice = findViewById(R.id.textView_computerChose);
            String compChoice = computerChoice();
            String result;

            if (compChoice.equals("rock")){
                result = "You lost";
            }
            else if (compChoice.equals("paper")){
                result = "You Won!";
            }
            else {
                result = "Tie!";
            }

            textView_result.setText(result);
            textView_compChoice.setText("The computer chose: "+ compChoice + ".");
            }
        });
        }
        private String computerChoice(){
        Random rand = new Random();
        int choice = rand.nextInt(2);

        if (choice==0){
            return "rock";
        }
        else if (choice==1){
            return "paper";
        }
        else {
            return "scissor";
        }
        }
    }

