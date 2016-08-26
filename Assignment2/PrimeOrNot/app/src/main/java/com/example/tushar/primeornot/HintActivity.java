package com.example.tushar.primeornot;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.util.Log;

public class HintActivity extends AppCompatActivity {

    TextView txtview;
    public final static String Message = "Android : ";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
        txtview = (TextView)findViewById(R.id.texthint);

        Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity.numberPassed);

        int value = Integer.parseInt(msg);
        Log.d(Message,"Inside Cheat Activity");
        Log.d(Message,"Data received is "+ value);
         get_hint(value);


    }

    public void get_hint(int number)
    {
        int upperLimit = (int)Math.sqrt(number);
        Log.d(Message,"Inside get_hint function");
        Log.d(Message,"Number received is "+ number);
        txtview.setText("Check for divisibility of number between 2 and "+ upperLimit );
    }



}
