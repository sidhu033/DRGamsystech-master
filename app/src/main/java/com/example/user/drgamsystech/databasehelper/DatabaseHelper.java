package com.example.user.drgamsystech.databasehelper;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.user.drgamsystech.pojo.Doctor;
import com.example.user.drgamsystech.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 4;

    SQLiteDatabase data= this.getWritableDatabase();

    Context ctx;
    User user;
    // Database Name
    private static final String DATABASE_NAME = "UserManager.db";

    // User table name
    private static final String TABLE_USER = "user";
    private static final String TABLE_DOC = "doc";

    // User Table Columns names
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_MOBILE = "user_mobile";
    private static final String COLUMN_USER_ALMOBILE = "user_almobile";
    private static final String COLUMN_USER_HOUSENO = "user_houseno";
    private static final String COLUMN_USER_STREET = "user_street";
    private static final String COLUMN_USER_AREA = "user_area";
    private static final String COLUMN_USER_CITY = "user_city";
    private static final String COLUMN_USER_STATE = "user_state";


    // Doctor Table Columns names
    private static final String COLUMN_DOC_NAME = "doc_name";
    private static final String COLUMN_DOC_PASS = "doc_pass";

    // create table  for doctor sql query
    private String CREATE_DOC_TABLE = "CREATE TABLE " + TABLE_DOC + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_DOC_NAME + " TEXT,"
            + COLUMN_DOC_PASS + " TEXT," + ")";


    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_MOBILE + " TEXT," + COLUMN_USER_ALMOBILE +
            "TEXT," + COLUMN_USER_HOUSENO + "TEXT," + COLUMN_USER_STREET +
            "TEXT," + COLUMN_USER_AREA + "TEXT," + COLUMN_USER_CITY + "TEXT," + COLUMN_USER_STATE + ")";

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;


    /*Constructor*/
    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newversion)
    {
        //Drop User Table if exist
        sqLiteDatabase.execSQL(DROP_USER_TABLE);

        // Create tables again
        onCreate(sqLiteDatabase);

    }

    /**
     * This method is to create user record
     *
     * @param user*/

    //open Sqlite Database
    public void open() throws SQLException
    {
        DatabaseHelper db1 = new DatabaseHelper(ctx);
        data = db1.getWritableDatabase();
    }

    //close sqlite Database
    public void close()
    {
        data.close();
    }
    public void login(Doctor doctor)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        //cv.put();

    }
    //adding values of user
    public void addUser(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_ID,user.getId());
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_MOBILE, user.getMobile());
        values.put(COLUMN_USER_ALMOBILE, user.getAlmobile());
        values.put(COLUMN_USER_HOUSENO, user.getHouseno());
        values.put(COLUMN_USER_STREET, user.getStreetaddress());
        values.put(COLUMN_USER_AREA, user.getArea());
        values.put(COLUMN_USER_CITY, user.getCiy());
        values.put(COLUMN_USER_STATE, user.getState());


        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    /*getting single contact User*/
    public  User getuser(User userid)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_USER+"";
        Cursor cv =db.rawQuery(query,null);

        if(cv!=null && cv.moveToFirst())
        {
            user = new User();
            user.setId(Integer.parseInt(cv.getString(0)));
            user.setName(cv.getString(1));
            user.setEmail(cv.getString(2));
            user.setMobile(cv.getString(3));
            user.setAlmobile(cv.getString(4));
            user.setHouseno(cv.getString(5));
            user.setStreetaddress(cv.getString(6));
            user.setArea(cv.getString(7));
            user.setState(cv.getString(8));

        }
        return  user;
    }


    public ArrayList<User> getRedoxerUser()
    {
        ArrayList<User> users = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM "+TABLE_USER+";";

        Cursor cv =db.rawQuery(query,null);
        cv.moveToFirst();
        //when not moving to not last
        while (!cv.isAfterLast())
        {
            if(cv.getString(cv.getColumnIndex("productname"))!=null)
            {
                User user1 =  new User(Integer.parseInt(cv.getString(cv.getColumnIndex(COLUMN_USER_ID))));
                users.add(user1);
            }
            cv.moveToNext();
        }
        return  users;
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<User> getAllUser() {
        // array of columns to fetch
        String[] columns =
                {
                        COLUMN_USER_ID,
                        COLUMN_USER_EMAIL,
                        COLUMN_USER_NAME,
                        COLUMN_USER_MOBILE,
                        COLUMN_USER_ALMOBILE,
                        COLUMN_USER_HOUSENO,
                        COLUMN_USER_STREET,
                        COLUMN_USER_AREA,
                        COLUMN_USER_CITY,
                        COLUMN_USER_STATE
                };

        // sorting orders
        String sortOrder = COLUMN_USER_NAME + " ASC";

        List<User> userList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        Cursor cursor = db.query(TABLE_USER,             //Table to query
                columns,                 //columns to return
                null,               //columns for the WHERE clause
                null,            //The values for the WHERE clause
                null,                //group the rows
                null,                   //filter by redoxerusers groups
                sortOrder);                    //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst())
        {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)));
                user.setMobile(cursor.getString(cursor.getColumnIndex(COLUMN_USER_MOBILE)));
                user.setAlmobile(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ALMOBILE)));
                user.setHouseno(cursor.getString(cursor.getColumnIndex(COLUMN_USER_HOUSENO)));
                user.setStreetaddress(cursor.getString(cursor.getColumnIndex(COLUMN_USER_STREET)));
                user.setArea(cursor.getString(cursor.getColumnIndex(COLUMN_USER_AREA)));
                user.setCiy(cursor.getString(cursor.getColumnIndex(COLUMN_USER_CITY)));
                user.setState(cursor.getString(cursor.getColumnIndex(COLUMN_USER_STATE)));


                // Adding user record to list
                userList.add(user);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return userList;               // return user list
    }

    /**
     * This method to update user record
     *
     * @param user
     */
    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_MOBILE, user.getMobile());
        values.put(COLUMN_USER_ALMOBILE, user.getAlmobile());

        values.put(COLUMN_USER_HOUSENO, user.getHouseno());
        values.put(COLUMN_USER_STREET, user.getStreetaddress());
        values.put(COLUMN_USER_AREA, user.getArea());
        values.put(COLUMN_USER_CITY, user.getCiy());
        values.put(COLUMN_USER_STATE, user.getState());

        // updating redoxerusers
        db.update(TABLE_USER, values, COLUMN_USER_ID + " = ?", new String[]{String.valueOf(user.getId())});
        db.close();

    }

    /**
     * This method is to delete user record
     *
     * @param user
     */
    public void deleteUser(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        // delete user record by id
        db.delete(TABLE_USER, COLUMN_USER_ID + " = ?", new String[]
                {
                        String.valueOf(user.getId())
                });
        db.close();
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @return true/false
     */


    public boolean checkUser(String email) {

        // array of columns to fetch
        String[] columns =
                {
                        COLUMN_USER_ID
                };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by redoxerusers groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }


}

/* *//**
 * This method to check user exist or not
 *
 * @param email
 * @param password
 * @return true/false
 *//*
    public boolean checkUser(String email, String password)
    {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query user table with conditions
        *//**
 * Here query function is used to fetch records from user table this function works like we use sql query.
 * SQL query equivalent to this query function is
 * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
 *//*
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by redoxerusers groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }*/

