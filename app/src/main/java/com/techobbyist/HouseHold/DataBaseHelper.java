package com.techobbyist.HouseHold;


/**
 * Created by Acer on 11/26/2017.
 */


import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompatBase;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

import android.widget.ImageView;

public class DataBaseHelper  extends SQLiteOpenHelper {

    private static DataBaseHelper dbh;
    public static final String TAG = "DBHelper";


    //Contacts table
    public static final String TABLE_NAME = "contacts";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASS = "password";
    public static final String COLUMN_SEXE = "sexe";


    // Tasks table
    public static final String TABLE_Task = "tasks";
    public static final String COLUMN_ID_taks = COLUMN_ID;
    public static final String COLUMN_TaskNAME = "ntask";
    public static final String COLUMN_PersonNAME = "nperson";
    public static final String COLUMN_Deadline = "deadline";
    public static final String COLUMN_Equipements = "equipements";
    public static final String COLUMN_Notes = "notes";

    //shopping list table
    public static final String TABLE_ITEM = "shoppingList.db";
    public static final String COLUMN_ITEM_ID = COLUMN_ID;
    public static final String COLUMN_ITEM_NAME = "nameitem";

    private static final String DATABASE_NAME = "contacts.db";
    private static final int DATABASE_VERSION = 1;

    SQLiteDatabase database;

    public static DataBaseHelper getInstance(Context c, SQLiteDatabase.CursorFactory factory, int version) {
        if (dbh == null) {
            dbh = new DataBaseHelper(c, DATABASE_NAME, factory, version);
        }
        return dbh;
    }

    public DataBaseHelper(FragmentActivity context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    //create people table
    private static final String CREATE_TABLE_USERS = "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_EMAIL + " TEXT,"
            + COLUMN_SEXE + " TEXT,"
            + COLUMN_USERNAME + " TEXT,"
            + COLUMN_NAME + " TEXT,"
            + COLUMN_PASS + " TEXT"
            + ");";

    //create task table
    private static final String CREATE_TABLE_TASKS = "CREATE TABLE " + TABLE_Task + "("
            + COLUMN_ID_taks + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_TaskNAME + "TEXT,"
            + COLUMN_PersonNAME + " TEXT,"
            + COLUMN_Deadline + " TEXT,"
            + COLUMN_USERNAME + " TEXT,"
            + COLUMN_Equipements + " TEXT,"
            + COLUMN_Notes + " TEXT"
            + ");";

    //Creat shopping list table
    private static final String CREATE_TABLE_SHOPPING = "CREATE TABLE" + TABLE_ITEM + "("
            + COLUMN_ITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_ITEM_NAME + "TEXT" + ");";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
        db.execSQL(CREATE_TABLE_TASKS);
        //db.execSQL(CREATE_TABLE_SHOPPING);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG, "Upgrading the database from version " + oldVersion + "to " + newVersion);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_Task);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_ITEM);
        //creation of new database
        onCreate(db);

    }

    public void insertContact(Contact c) {
        database = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "Select * from contacts";
        Cursor cursor = database.rawQuery(query, null);
        int count = cursor.getCount();


        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_PASS, c.getPassword());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_SEXE, c.getSexe());
        values.put(COLUMN_USERNAME, c.getUsername());


        long id = database.insert(TABLE_NAME, null, values);
        database.close();

        Log.d(TAG, "user inserted " + id);

    }

    public boolean getUser(String email, String pass) {
        String selectQuery = "select * from  " + TABLE_NAME + " where " +
                COLUMN_EMAIL + " = " + "'" + email + "'" + " and " + COLUMN_PASS + " = " + "'" + pass + "'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor0 = db.rawQuery(selectQuery, null);
        cursor0.moveToFirst();
        if (cursor0.getCount() > 0) {

            return true;
        }
        cursor0.close();
        db.close();

        return false;
    }


    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query1 = "SELECT * FROM" + TABLE_NAME;
        Cursor data = db.rawQuery(query1, null);
        return data;


    }

    public void insertTask(Task t) {
        database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query4 = "Select * from contacts";
        Cursor cursor4 = database.rawQuery(query4, null);
        int count = cursor4.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_TaskNAME, t.gettaskName());
        values.put(COLUMN_PersonNAME, t.getpersonName());
        values.put(COLUMN_Deadline, t.getDeadline());
        values.put(COLUMN_Equipements, t.getRequiredItems());
        values.put(COLUMN_Notes, t.getNote());

        long id = database.insert(TABLE_Task, null, values);
        database.close();

        Log.d(TAG, "Task inserted " + id);

    }

    //insert item in shopping list
    public void insertitem(String item) {
        database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ITEM_NAME, item);
        //database.insertWithOnConflict(COLUMN_ITEM_ID, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        database.close();
        Log.d(TAG, "item inserted ");
    }

    // show all the contacts on people fragment (TAB3FRAGMENT)
    public ArrayList<Contact> getAllContacts() {

        ArrayList<Contact> profiles = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while (!c.isAfterLast()) {
            if ((c.getString(c.getColumnIndex("name")) != null)) {
                String name = c.getString(c.getColumnIndex("name"));
                String sexe= c.getString(c.getColumnIndex("sexe"));
                String email= c.getString(c.getColumnIndex("email"));
                //int nbrOfTask= tasksCounter(name);
                //   byte[] blob=c.getBlob(c.getColumnIndex("image_data"));
                Contact f = new Contact();
                f.setName(name);
                f.setSexe(sexe);
                f.setEmail(email);
                //f.setNbrOfTask(nbrOfTask);
                //  f.setBmp(Utility.getPhoto(blob));
                profiles.add(f);
            }
            c.moveToNext();
        }
        c.close();
        //db.close();
        return profiles;
    }
    public int tasksCounter(String S){
        int nbrOfTasks=0;
        SQLiteDatabase db1=this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE 1 ";
        Cursor cursor = db1.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            if ((cursor.getString(cursor.getColumnIndex("name")) == S)) {
                nbrOfTasks++;

            }
            cursor.moveToNext();

        }
        cursor.close();
        return nbrOfTasks;
    }


    // show all the items on shopping fragment (TAB1FRAGMENT)
    public ArrayList<String> getAllItem() {
        ArrayList<String> items = new ArrayList<String>();
        SQLiteDatabase db11 = getWritableDatabase();
        String query11 = "SELECT * FROM " + TABLE_ITEM ;
        Cursor c11 = db11.rawQuery(query11, null);
        c11.moveToFirst();
        while (!c11.isAfterLast()) {
            if ((c11.getString(c11.getColumnIndex("nameitem")) != null)) {
                String itemName = c11.getString(c11.getColumnIndex("nameitem"));
                items.add(itemName);
            }
            c11.moveToNext();
        }
        c11.close();
        return items;
    }

}
