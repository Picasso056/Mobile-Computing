package com.example.tushar.studentdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class searchSqlite extends AppCompatActivity {

    private EditText e,e2;

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_search_sqlite);
        e = (EditText)findViewById(R.id.courseNo);
        e2 = (EditText)findViewById(R.id.searchdatas);
    }

    public void searchSql(View v)
    {
        DBHandler db = new DBHandler(this,null,null,1);
        String course = e.getText().toString();
        Student marks = db.findSubjectMarks(course);
        String s = "Course : "+marks.getCourseno() + ", Subject :"+ marks.getSubject() +" ,Marks :" + marks.getMarks();

        e2.setText(s);


    }


}
