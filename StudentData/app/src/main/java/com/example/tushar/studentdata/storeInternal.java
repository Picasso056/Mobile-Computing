 package com.example.tushar.studentdata;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

 public class storeInternal extends AppCompatActivity {

    String Filename = "Myfile";
     FileOutputStream outputStream = null;

    private EditText e,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_internal);
        e = (EditText)findViewById(R.id.enterData);
        e2 = (EditText)findViewById(R.id.ShowData);
    }

     public void storeInternalData(View v)
     {
         String content = e.getText().toString();

         try {
             outputStream = openFileOutput(Filename, Context.MODE_APPEND);
             outputStream.write(content.getBytes());
             outputStream.close();
             Toast.makeText(storeInternal.this,"Data Saved Internally",Toast.LENGTH_LONG).show();
         } catch (Exception e){
             e.printStackTrace();
         }
     }

     public void showInternalFile(View v)
     {
         try {
             FileInputStream fin = openFileInput(Filename);
             int c;
             String temp ="";

             while ((c = fin.read()) != -1) {
                 temp = temp + Character.toString((char) c);
             }
             e2.setText(temp);
         }catch (Exception e){

         }
     }
}
