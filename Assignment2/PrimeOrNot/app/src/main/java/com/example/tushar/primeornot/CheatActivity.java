package com.example.tushar.primeornot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);


        TextView txt = (TextView)findViewById(R.id.cheat_box);

        Intent intent = getIntent();
        int val = Integer.parseInt(intent.getStringExtra(MainActivity.outputPassed));

        Boolean cheat = MainActivity.primeOrNot(val);
        if(cheat == false)
                txt.setText(val +" is not a prime number");
        else
                txt.setText(val + " is a prime number");
    }
}
