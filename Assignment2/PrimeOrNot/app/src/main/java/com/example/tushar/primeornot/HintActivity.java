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

public class HintActivity extends AppCompatActivity {

    TextView txtview;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
        txtview = (TextView)findViewById(R.id.texthint);

        Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity.numberPassed);


        int value = Integer.parseInt(msg);
       get_hint(value);


    }

    public void get_hint(int number)
    {
        int upperLimit = (int)Math.sqrt(number);
        txtview.setText("Check for divisibility of number between 2 and "+ upperLimit );
    }



}
