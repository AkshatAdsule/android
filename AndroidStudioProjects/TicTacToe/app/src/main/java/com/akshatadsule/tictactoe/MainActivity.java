package com.akshatadsule.tictactoe;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button [][] buttons = new Button[3][3];

    private boolean player1Turn = true;

    private int roundCount;

    private int player1Points;
    private int player2Points;

    private TextView textViewPlayer1;
    private TextView textViewPlayer2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPlayer1 = findViewById(R.id.text_view_p1);
        textViewPlayer2 = findViewById(R.id.text_view_p2);

        for(int i = 0; i < 3;i++){
            for(int j = 0; j<3; j++){
                String buttonID = "button_" + i+ j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }
        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });

        Button buttonClear = findViewById(R.id.button_clear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearGame();
            }
        });

    }

    //for game-play buttons
    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")){
            return;
        }

        if (player1Turn){
            ((Button) v).setText("X");
        }
        else{
            ((Button) v).setText("O");
        }

        roundCount++;

        if(checkForWin()){
            if(player1Turn) {
                player1Wins();
            } else{
                player2Wins();
            }
        } else if(roundCount == 9){
            draw();
        } else{
            player1Turn = !player1Turn;
        }
    }

    private boolean checkForWin() {
        String[][] field = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && !field[i][0].equals("")) {
                buttons[i][0].setBackgroundColor(Color.RED);
                buttons[i][1].setBackgroundColor(Color.RED);
                buttons[i][2].setBackgroundColor(Color.RED);
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && !field[0][i].equals("")) {
                buttons[0][i].setBackgroundColor(Color.RED);
                buttons[1][i].setBackgroundColor(Color.RED);
                buttons[2][i].setBackgroundColor(Color.RED);
                return true;
            }
        }

        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && !field[0][0].equals("")) {
            buttons[0][0].setBackgroundColor(Color.RED);
            buttons[1][1].setBackgroundColor(Color.RED);
            buttons[2][2].setBackgroundColor(Color.RED);
            return true;

        }

        if (field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                && !field[0][2].equals("")) {
            buttons[0][2].setBackgroundColor(Color.RED);
            buttons[1][1].setBackgroundColor(Color.RED);
            buttons[2][0].setBackgroundColor(Color.RED);
            return true;
        }
        return false;
    }
    private void player1Wins(){
        player1Points++;
        Toast.makeText(this,"X wins!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                resetBoard();
            }
        }, 500);
    }

    private void player2Wins(){
        player2Points++;
        Toast.makeText(this,"O wins!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                resetBoard();
            }
        }, 500);
    }

    private void draw(){
        Toast.makeText(this,"Draw!", Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private void updatePointsText(){
        textViewPlayer1.setText("X: " + player1Points);
        textViewPlayer2.setText("O: " + player2Points);
    }

    private void resetBoard(){
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
            buttons[i][j].setText("");
                resetButton(buttons[i][j]);
            }
        }
        roundCount = 0;
        player1Turn = true;
    }

    private void resetGame(){
        player1Points = 0;
        player2Points = 0;
        updatePointsText();
        resetBoard();
        Toast.makeText(this, "Reseted!", Toast.LENGTH_SHORT).show();
    }

    private void clearGame(){
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                buttons[i][j].setText("");
            }
        roundCount = 0;
        player1Turn = true;
        Toast.makeText(this,"Cleared!", Toast.LENGTH_SHORT).show();
        }
    }

    private void resetButton(Button btn) {
        Button defBtn = new Button(this);
        btn.setBackground(defBtn.getBackground());
    }
}