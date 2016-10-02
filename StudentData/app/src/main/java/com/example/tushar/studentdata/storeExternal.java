package com.example.tushar.studentdata;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class storeExternal extends AppCompatActivity {

    private EditText e;
    FileOutputStream outputStream = null;
    String Filename = "Extdata.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_external);
        e = (EditText)findViewById(R.id.enterExtData);
    }

    public  void storeExternalData(View v)
    {
        String content = e.getText().toString();
        File file;


        try {

            file = new File(getExternalFilesDir(null),Filename);

            Log.v("name",String.valueOf(file));
            outputStream = new FileOutputStream(file);
            outputStream.write(content.getBytes());
            outputStream.close();
            Toast.makeText(storeExternal.this,"Data Saved Externally",Toast.LENGTH_LONG).show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
