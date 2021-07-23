package com.example.madpractical;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class DBHandler extends SQLiteOpenHelper {
    public static int DATABASE_VERSION = 1;
    public static String DATABASE_NAME = "practical6.db";

    public static String TABLE_USER = "User";
    public static String COLUMN_USERID = "UserID";
    public static String COLUMN_NAME = "Name";
    public static String COLUMN_DESC = "Description";
    public static String COLUMN_FOLLOWED = "Followed";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER +
                "(" + COLUMN_USERID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NAME+ " TEXT NOT NULL," + COLUMN_DESC + " TEXT NOT NULL," +
                COLUMN_FOLLOWED + " INTEGER NOT NULL)";
        db.execSQL(CREATE_USER_TABLE);
    }

    public void populateData() {
        for(int i = 0; i<20; i++) {
            int randomName = new Random().nextInt();
            int randomDesc = new Random().nextInt();
            boolean randomFollow = new Random().nextBoolean();

            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME,"NAME"+randomName);
            values.put(COLUMN_DESC,"Description "+randomDesc);
            values.put(COLUMN_FOLLOWED,randomFollow);
            SQLiteDatabase db = this.getWritableDatabase();
            db.insert(TABLE_USER,null,values);
        }
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> userArrayList = new ArrayList<User>();
        String query = "SELECT * FROM " +TABLE_USER;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Integer userID = cursor.getInt(0);
                String name = cursor.getString(1);
                String desc = cursor.getString(2);
                int followed = cursor.getInt(3);
                User u = new User();
                u.setId(userID);
                u.setName(name);
                u.setDesc(desc);
                if (followed == 0) {
                    u.setFollowed(false);
                } else if(followed == 1) {
                    u.setFollowed(true);
                }
                userArrayList.add(u);
                cursor.moveToNext();
            }
        }
        return userArrayList;
    }

    public void updateUser(User u) {
        String updateQuery = "UPDATE " +TABLE_USER +" SET "+COLUMN_FOLLOWED+ " = " + (u.getFollowed() ? 1:0)
                +" WHERE " +COLUMN_USERID +" = "+u.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(updateQuery);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS User");
            onCreate(db);
        }
    }


}
