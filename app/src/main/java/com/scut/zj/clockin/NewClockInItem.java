package com.scut.zj.clockin;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewClockInItem extends AppCompatActivity {

    private EditText Name;
    private ClockInDB clockInDB;
    private SQLiteDatabase dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_clock_in_item);

        clockInDB = new ClockInDB(this);
        dbHelper = clockInDB.getWritableDatabase();

        Name = (EditText)findViewById(R.id.clock_in_item_name);
        findViewById(R.id.add_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv = new ContentValues();
                cv.put(ClockInDB.NAME,Name.getText().toString());
                dbHelper.insert(ClockInDB.CLOCK_IN_ITEM,null,cv);
                finish();
            }
        });
    }
}
