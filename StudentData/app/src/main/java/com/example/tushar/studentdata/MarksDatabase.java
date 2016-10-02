package com.example.tushar.studentdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MarksDatabase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marks_database);
    }

    public void addmarks(View v)
    {
        Intent i = new Intent(MarksDatabase.this, SaveInSQLite.class);
        startActivity(i);
    }

    public void deletemarks(View v)
    {
        Intent i = new Intent(MarksDatabase.this, DeleteSQLite.class);
        startActivity(i);
    }

    public void updatemarks(View v)
    {
        Intent i = new Intent(MarksDatabase.this, updateSQLite.class);
        startActivity(i);

    }

    public void searchmarks(View v)
    {
        Intent i = new Intent(MarksDatabase.this, searchSqlite.class);
        startActivity(i);

    }

}

