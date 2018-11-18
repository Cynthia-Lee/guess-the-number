package com.example.cynth.guessthenumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Win extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
    }

    public void newGame(View view) {
        Intent i = new Intent(getApplicationContext(), MainActivity.class); // forwards us to Pick.class
        startActivity(i);
    }
}
