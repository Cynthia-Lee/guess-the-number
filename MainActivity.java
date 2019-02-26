package com.example.cynth.guessthenumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lowerb = (EditText)this.findViewById(R.id.lowerb);
        upperb = (EditText)this.findViewById(R.id.upperb);
        inputNum = (EditText)this.findViewById(R.id.inputNum);
        checkWrong = (TextView)this.findViewById(R.id.checkWrong);
        hintText = (TextView)this.findViewById(R.id.hintText);
        printRange = (TextView)this.findViewById(R.id.printRange);
    }

    EditText lowerb;
    EditText upperb;
    EditText inputNum;
    TextView checkWrong;
    TextView hintText;
    TextView printRange;
    private int answer;
    int min;
    int max;

    public void setUpGame(View view) {
        String minS = lowerb.getText().toString();
        String maxS = upperb.getText().toString();
        min = Integer.parseInt(minS);
        max = Integer.parseInt(maxS);
        printRange.setText("The range is " + min + "- " + max);
        // for a given range
        // (Math.random() * ((max - min) + 1)) + min
        // int answer;
        answer = (int)(Math.random()*((max - min) + 1) + min);
        // debug
        // printRange.setText(answer + "");
    }

    public void checkGuess(View view) {
        int guessNum;
        guessNum = Integer.parseInt(inputNum.getText().toString());
        checkWrong.setText("");
        hintText.setText("");
        if (guessNum == answer) {
            // go to "You win!" screen
            Intent i = new Intent(getApplicationContext(), Win.class); // forwards us to Pick.class
            startActivity(i);
        } else if (guessNum < min || guessNum > max) {
            checkWrong.setText("Your guess was not in range!");
        } else {
            checkWrong.setText("Wrong number! Try again!");
        }
    }

    public void giveHint(View view){
        int guessNum;
        guessNum = Integer.parseInt(inputNum.getText().toString());
        if(guessNum < answer) { // less than
            hintText.setText("The answer is greater than your guess!");
        } else { // greater than
            hintText.setText("The answer is less than your guess!");
        }
    }
}
