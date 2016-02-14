package com.example.yo_mu_000.signin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="customer.db";
    private static final String TABLE_NAME="customer";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_FNAME="fname";
    private static final String COLUMN_DOB="dob";
    private static final String COLUMN_PHONENO="phoneNo";
    private static final String COLUMN_ADDRESS="address";
    private static final String COLUMN_UNAME="uname";
    private static final String COLUMN_PASSWORD="password";
    SQLiteDatabase db;

    private static final String TABLE_CREATE="create table customer (id integer primary key not null ," +
            "fname text not null , " +
            "dob text not null , " +
            "phoneNo integer not null , " +
            "address text not null , " +
            "uname text not null , " +
            "password text not null);";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db=db;
    }

    public void insertCustomer(CustomerDB cdb){
        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        String query="select * from customer";
        Cursor cursor=db.rawQuery(query,null);
        int count=cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_FNAME,cdb.getFname());
        values.put(COLUMN_DOB, cdb.getDob());
        values.put(COLUMN_PHONENO,cdb.getPhoneNo());
        values.put(COLUMN_ADDRESS,cdb.getAddress());
        values.put(COLUMN_UNAME,cdb.getUname());
        values.put(COLUMN_PASSWORD, cdb.getPassword());

        db.insert(TABLE_NAME, null, values);
        db.close();

    }

    public String searchPass(String uname){
        db=this.getWritableDatabase();
        String query="select uname, password from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        String a,b;
        b="Not found!";
        if(cursor.moveToFirst()){
            do{
                a=cursor.getString(0);

                if (a.equals(uname)){
                    b=cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }

        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query="DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);

    }
}
