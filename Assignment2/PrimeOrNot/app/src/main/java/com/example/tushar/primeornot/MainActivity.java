package com.example.tushar.primeornot;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final static String statusField = "Status field value";
    private final static String numField = "Number field value";
    private final static String color_value = "background color";
    private final static String cheatValue = "Boolean value of cheat";
    private final static String hintValue = "Boolena hint value";
    private final static String outputValue ="value whether true or false";
    public final static String numberPassed = " Number to be passed to other activities";
    public final static String outputPassed = " Output to be passed to other activities";
    public final static String Message = "Android : ";

    private RelativeLayout mrelativelayout ;
    private int number;
    private int mcolor;
    private int backgroundColor = Color.WHITE;
    private Boolean status = false;
    private Boolean cheatButtonStatus = false;
    private Boolean hintButtonStatus = false;
    private Boolean value ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtview = (TextView) findViewById(R.id.textView);
        mrelativelayout = (RelativeLayout)findViewById(R.id.relativelayout);

        Log.d(Message,"Inside onCreate");


        if(savedInstanceState == null)
        {
            number = generateRandomNumbers();
            txtview.setText("Is the number "+number + " prime ?");
            mrelativelayout.setBackgroundColor(Color.WHITE);
            Log.d(Message,"Loading values ");
        }

        else
        {
            number = savedInstanceState.getInt(numField);
            status = savedInstanceState.getBoolean(statusField);
            cheatButtonStatus = savedInstanceState.getBoolean(cheatValue);
            hintButtonStatus = savedInstanceState.getBoolean(hintValue);
            value = savedInstanceState.getBoolean(outputValue);
            backgroundColor = savedInstanceState.getInt(color_value);
            mrelativelayout.setBackgroundColor(backgroundColor);
            txtview.setText("Is the number "+number + " prime ?");

            Log.d(Message,"Loading old values of instances ");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState)
    {
        saveInstanceState.putInt(numField,number);
        saveInstanceState.putBoolean(statusField,status);
        saveInstanceState.putBoolean(hintValue,hintButtonStatus);
        saveInstanceState.putBoolean(cheatValue,cheatButtonStatus);
        saveInstanceState.putBoolean(outputValue,value);
        saveInstanceState.putInt(color_value,backgroundColor);

       Log.d(Message,"Inside OnsaveInstanceState ");
       Log.d(Message,"Android : Saving values");

        super.onSaveInstanceState(saveInstanceState);
    }

    public int generateRandomNumbers()
    {
        Random r = new Random();
        int x = r.nextInt(1000);

        Log.d(Message,"Inside generateRandomNumber");
        Log.d(Message,"Random number generated is : " + x );

        return x;

    }

    public static Boolean primeOrNot(int number)
    {
        Log.d(Message,"Inside primeOrNot");
        Log.d(Message,"Checking if prime or not for variable" + number);

        int root = (int)Math.sqrt(number);

        for(int i = 2; i <= root; i++)
        {
            if(number % i == 0)
            {
                Log.d(Message,"Output from primeOrNot is false");
                return false;
            }
        }
        Log.d(Message,"Output from primeOrNot is true");
        return true;
    }

    public void click_cheat(View v)
    {
        Log.d(Message,"Cheat button pressed");

        if(cheatButtonStatus == true)
        {
            Toast.makeText(this,"Cheat taken.Please select the next question",Toast.LENGTH_SHORT).show();
            status = true;
            Log.d(Message,"Cheat already taken");
            return;

        }

        Intent intent = new Intent(this,CheatActivity.class);
        value = primeOrNot(number);
        String msg = Integer.toString(number);
        intent.putExtra(outputPassed,msg);
        cheatButtonStatus = true;
        status = true;
        Log.d(Message,"Calling another Cheat Activity");
        Log.d(Message,"Data passed is "+ msg);
        startActivity(intent);
    }


    public void click_hint(View v)
    {
        Log.d(Message,"Hint button pressed");
        if(hintButtonStatus == true || cheatButtonStatus == true) {
            Log.d(Message,"Click button already pressed");
            Toast.makeText(this, "Help already Taken", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this,HintActivity.class);
        String message = Integer.toString(number);
        intent.putExtra(numberPassed,message);
        hintButtonStatus = true;
        Log.d(Message,"Calling another Hint Activity");
        Log.d(Message,"Data passed is "+ message);
        startActivity(intent);

    }

    public void generateQuestion(View v)
    {
        Log.d(Message,"Inside generateQuestion");

        if(status == false)
        {
            Toast.makeText(this,"Please answer the question",Toast.LENGTH_SHORT).show();
            return;
        }

        status = false;
        cheatButtonStatus = false;
        hintButtonStatus = false;
        backgroundColor = Color.WHITE;
        mrelativelayout.setBackgroundColor(backgroundColor);
        TextView txtview = (TextView) findViewById(R.id.textView);
        number = generateRandomNumbers();
        Log.d(Message,"Generated Number is "+number);
        txtview.setText("Is the number "+number + " prime ?");

    }

    public void checkAnswer(View v) {

         value = primeOrNot(number);
        Log.d(Message,"Inside checkAnswer");

    switch(v.getId())
    {
        case R.id.correctAnswer :
                                     Log.d(Message,"Yes button pressed");
                                    if(status == true)
                                    {
                                        Toast.makeText(this,"Please try the next question",Toast.LENGTH_SHORT).show();

                                    }
                                    if(value == true && status == false)
                                    {
                                        Log.d(Message,"Correct Answer");
                                        status = true;
                                        backgroundColor = Color.rgb(76,153,0);
                                        mrelativelayout.setBackgroundColor(backgroundColor);
                                        Toast.makeText(this,"Congratulation,this is correct",Toast.LENGTH_SHORT).show();

                                    }

                                    else if(value == false && status == false)
                                    {
                                        Log.d(Message,"Wrong Answer");
                                        status = true;
                                        backgroundColor = Color.rgb(255,102,102);
                                        mrelativelayout.setBackgroundColor(backgroundColor);
                                        Toast.makeText(this,"Sorry,this is wrong",Toast.LENGTH_SHORT).show();

                                    }



                                    break;

        case R.id.incorrectAnswer :

                                     if(status == true)
                                    {

                                       Toast.makeText(this,"Please try the next question",Toast.LENGTH_SHORT).show();


                                    }

                                    if(value == false && status == false)
                                    {
                                        Log.d(Message,"Correct Answer");
                                        status = true;
                                        backgroundColor = Color.rgb(76,153,0);
                                        mrelativelayout.setBackgroundColor(backgroundColor);
                                        Toast.makeText(this,"Congratulation,this is correct",Toast.LENGTH_SHORT).show();

                                    }


                                    else if(value == true && status == false )
                                    {
                                        Log.d(Message,"Wrong Answer");
                                        status = true;
                                        backgroundColor = Color.rgb(255,102,102);
                                        mrelativelayout.setBackgroundColor(backgroundColor);
                                        Toast.makeText(this,"Sorry,this is wrong",Toast.LENGTH_SHORT).show();
                                    }


                                    break;

        case R.id.next :
                            break;


    }

}
}
