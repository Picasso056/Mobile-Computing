package com.example.tushar.studentdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class DeleteSQLite extends AppCompatActivity {

    private EditText courseno;
    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_delete_sqlite);
        courseno = (EditText)findViewById(R.id.course);
    }

    public void delete(View v)
    {
        DBHandler db = new DBHandler(this,null,null,1);
        String course = courseno.getText().toString();
        Boolean res = db.deleteSubjectMarks(course);

        if(res == true)
        {
            courseno.setText("");
            Toast.makeText(DeleteSQLite.this,"Data removed from database",Toast.LENGTH_LONG).show();
        }

        else
        {
            courseno.setText("");
            Toast.makeText(DeleteSQLite.this,"No data found",Toast.LENGTH_LONG).show();
        }
        db.close();
    }
}
