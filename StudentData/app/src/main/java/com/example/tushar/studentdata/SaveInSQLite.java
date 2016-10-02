package com.example.tushar.studentdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import java.util.jar.Attributes;

public class SaveInSQLite extends AppCompatActivity {

    private EditText courseNo;
    private  EditText subject;
    private EditText marks;

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_save_in_sqlite);

        courseNo = (EditText)findViewById(R.id.course);
        subject = (EditText)findViewById(R.id.subject);
        marks = (EditText)findViewById(R.id.marks);

    }

    public void saved(View v)
    {
      DBHandler db = new DBHandler(this,null,null,1);
        String course = courseNo.getText().toString();
        String sub = subject.getText().toString();
        int maarks = Integer.parseInt(marks.getText().toString());

        Student s = new Student(course,sub,maarks);
         db.addProduct(s);


        courseNo.setText("");
        subject.setText("");
        marks.setText("");
    }
}
