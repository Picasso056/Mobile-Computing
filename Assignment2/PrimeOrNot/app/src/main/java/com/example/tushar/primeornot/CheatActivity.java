package com.example.tushar.primeornot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    public final static String Message = "Android : ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        TextView txt = (TextView)findViewById(R.id.cheat_box);

        Intent intent = getIntent();
        int val = Integer.parseInt(intent.getStringExtra(MainActivity.outputPassed));
        Log.d(Message,"Inside hint activity onCreate");
        Log.d(Message,"Value received is " + val);

        Boolean cheat = MainActivity.primeOrNot(val);
        if(cheat == false)
                txt.setText(val +" is not a prime number");
        else
                txt.setText(val + " is a prime number");
    }
}
