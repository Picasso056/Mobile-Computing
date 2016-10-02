package com.example.tushar.studentdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void StoreSqlite(View v)
    {
        Intent i = new Intent(MainActivity.this, MarksDatabase.class);
        startActivity(i);
    }

    public void savePreference(View v)
    {
        Intent i = new Intent(MainActivity.this, SavePreference.class);
        startActivity(i);
    }

    public void StoreInternal(View v)
    {
        Intent i = new Intent(MainActivity.this, storeInternal.class);
        startActivity(i);
    }

    public void StoreExternal(View v)
    {
        Intent i = new Intent(MainActivity.this, storeExternal.class);
        startActivity(i);
    }
}
