package com.scut.zj.clockin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zj on 2016/1/17.
 */
public class ClockInDB extends SQLiteOpenHelper{

    public static final String CLOCK_IN_ITEM = "clock_in_item";
    public static final String CLOCK_IN_RECORD = "clock_in_record";
    public static final String CLOCK_IN_ITEM_RECORD = "clock_in_item_record";
    public static final String DAY_EVALUATION_RECORD = "day_evaluation_record";

    public static final String ID = "id";
    public static final String RECORD_ID = "record_id";

    //table clock_in_item
    public static final String NAME = "name";
    public static final String REMINDING_TIME = "reminding_time";
    public static final String PRESET_HOUR = "preset_hour";

    //table clock_in_record
    public static final String CLOCK_DATE = "clock_date";
    public static final String RATE = "rate";
    public static final String CLOCK_HOUR = "clock_hour";

    //table clock_in_item_record
    public static final String ITEM_ID = "item_id";

    //table day_evaluation_record
    public static final String EVALUATION = "evaluation";

    public ClockInDB(Context context) {
        super(context, "clock_in.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+CLOCK_IN_ITEM+"("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +NAME+" TEXT NOT NULL,"
                +REMINDING_TIME+" TEXT,"
                +PRESET_HOUR+" INTEGER);");
        db.execSQL("CREATE TABLE "+CLOCK_IN_RECORD+"("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +RATE+" INTEGER NOT NULL,"
                +CLOCK_DATE+" TEXT NOT NULL,"
                +CLOCK_HOUR+" INTEGER);");
        db.execSQL("CREATE TABLE "+CLOCK_IN_ITEM_RECORD+"("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +ITEM_ID+" INTEGER NOT NULL,"
                +RECORD_ID+" INTEGER NOT NULL,"
                +"FOREIGN KEY("+ITEM_ID+") REFERENCES "+CLOCK_IN_ITEM+"("+ID+"),"
                +"FOREIGN KEY("+RECORD_ID+") REFERENCES "+CLOCK_IN_RECORD+"("+ID+"));");
        db.execSQL("CREATE TABLE "+DAY_EVALUATION_RECORD+"("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +EVALUATION+" TEXT NOT NULL,"
                +RECORD_ID+" INTEGER NOT NULL,"
                +"FOREIGN KEY("+RECORD_ID+") REFERENCES "+CLOCK_IN_RECORD+"("+ID+"));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
