package com.example.tushar.studentdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class updateSQLite extends AppCompatActivity {

    EditText c;
    EditText marks;

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_update_sqlite);
        c = (EditText)findViewById(R.id.courseupdated);
        marks = (EditText)findViewById(R.id.marksupdated);
    }

    public void updateSQLit(View v)
    {
        DBHandler db = new DBHandler(this,null,null,1);
        String course = c.getText().toString();
        int mark = (Integer.parseInt(marks.getText().toString()));
        db.updatemarks(mark,course);

        Toast.makeText(updateSQLite.this,"Data updated in database",Toast.LENGTH_LONG).show();
        c.setText("");
        marks.setText("");
        db.close();
    }

}
