package com.example.tushar.studentdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Tushar on 01-10-2016.
 */

public class DBHandler extends SQLiteOpenHelper
{

    private static final int VERSION = 1;
    private static final String DATABASENAME = "StudentMarks.db";
    private static final String TABLE_MARKS = "studentmarks";

    private static final String SUBJECTMARKS ="SUBJECT";
    private static final String SUBMARKS = "marksSE";
    private static final String COURSENOS = "coursSE";
    private static final String ID ="id";
    Context context;

    public DBHandler(Context context, String name,
                     SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context,DATABASENAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {


        String CREATE_TABLE = "CREATE TABLE " + TABLE_MARKS + "("  +
                COURSENOS + " TEXT PRIMARY KEY," +
                SUBJECTMARKS + " TEXT," +
                SUBMARKS + " INTEGER" + ")";


        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MARKS);
        onCreate(db);
    }

    // add marks of a course
    public void addProduct(Student subject) {

        ContentValues values = new ContentValues();
        values.put(COURSENOS, subject.getCourseno());
        values.put(SUBJECTMARKS, subject.getSubject());
        values.put(SUBMARKS, subject.getMarks());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_MARKS, null, values);

        db.close();



    }

    public Student findSubjectMarks(String subject) {
        String query = "Select * FROM " + TABLE_MARKS + " WHERE " + COURSENOS + " =  \"" + subject + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Student marks = new Student();
        cursor.moveToFirst();



        if (cursor.getCount() !=0) {

            marks.setCourseno(cursor.getString(0));
            marks.setSubject(cursor.getString(1));
            marks.setMarks(Integer.parseInt(cursor.getString(2)));
            cursor.close();
        } else {
            marks = null;
        }
       db.close();
        return marks;
    }

    public boolean deleteSubjectMarks(String subject) {

        boolean result = false;

        String query = "Select * FROM " + TABLE_MARKS + " WHERE " + COURSENOS + " = \"" + subject + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Student marks = new Student();

        if(cursor.getCount() == 0)
            return true;
        if (cursor.moveToFirst()) {
            marks.setCourseno(cursor.getString(0));
            db.delete(TABLE_MARKS, COURSENOS + " = ?",new String[] { String.valueOf(marks.getCourseno()) });
            cursor.close();
            result = true;
        }
        db.close();
        return true;
    }

    public void updatemarks(int marks, String coursed)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues datas = new ContentValues();
        String filter = "coursSE = ?" ;

            Student stud = findSubjectMarks(coursed);

            if(stud == null)
                    return;

        datas.put(COURSENOS,stud.getCourseno());
       datas.put(SUBMARKS, marks);
        datas.put(SUBJECTMARKS,stud.getSubject());


        db.update(TABLE_MARKS, datas, filter, new String[]{coursed +""});

        Log.d("Android :","true");
        db.close();
    }


}



