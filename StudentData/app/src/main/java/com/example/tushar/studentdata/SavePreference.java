package com.example.tushar.studentdata;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SavePreference extends AppCompatActivity {

    private EditText NAME;
    private EditText ROLL;

    public static final String MYPREFERENCE = "mypref";
    public static final String name ="nameKey";
    public static final String rollnum = "rollkey";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_preference);

        NAME = (EditText)findViewById(R.id.name);
        ROLL = (EditText)findViewById(R.id.RollNo);
        sharedPreferences = getSharedPreferences(MYPREFERENCE, Context.MODE_PRIVATE);
    }

    public void saveSharedPreference(View v)
    {
        String e = NAME.getText().toString();
        String x = ROLL.getText().toString();

        SharedPreferences.Editor editor = getSharedPreferences(MYPREFERENCE,MODE_PRIVATE).edit();
        editor.putString(name,e);
        editor.putString(rollnum,x);
        editor.commit();

        Toast.makeText(SavePreference.this,"Data Saved Using shared Preference",Toast.LENGTH_LONG).show();
    }

    public void fetchdata(View v)
    {
        SharedPreferences preferences = getSharedPreferences(MYPREFERENCE,MODE_PRIVATE);
        String data = preferences.getString(name,"");
        String data2 = preferences.getString(rollnum,"");
        NAME.setText(data);
        ROLL.setText(data2);
        Toast.makeText(SavePreference.this,"Data Retrieved Using shared Preference",Toast.LENGTH_LONG).show();
    }
}
