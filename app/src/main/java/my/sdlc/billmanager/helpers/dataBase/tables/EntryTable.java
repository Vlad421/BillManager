/*
 * Copyright (c) 2024.
 * Vlad421 https://github.com/Vlad421
 */

package my.sdlc.billmanager.helpers.dataBase.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.util.Calendar;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import my.sdlc.billmanager.entity.flow.Earn;
import my.sdlc.billmanager.entity.flow.Entry;
import my.sdlc.billmanager.entity.flow.Spent;
import my.sdlc.billmanager.helpers.Constants;
import my.sdlc.billmanager.helpers.dataBase.DBase;

/**
 * @author Vlad421 <a href="https://github.com/Vlad421">...</a>
 */
public abstract class EntryTable extends Table {
    /**
     * Abstract class for Entry table
     */

    protected static final String ID = "id";
    protected static final String CATEGORY = "category";
    protected static final String DESCRIPTION = "description";
    protected static final String AMOUNT = "amount";
    protected static final String IMAGE = "image"; //not implemented
    protected static final String DAY = "day";
    protected static final String MONTH = "month";
    protected static final String YEAR = "year";

    EntryTable(String tableName, DBase dBase) {
        super(tableName, dBase);
    }

    /**
     * This method is used to create table in database.
     *
     * @return String query
     */
    public String createTable() {
        return TABLE_NAME + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CATEGORY + " TEXT, " +
                DESCRIPTION + " TEXT, " +
                AMOUNT + " REAL SIGNED, " +
                IMAGE + " BLOB, " +
                DAY + " INTEGER, " +
                MONTH + " INTEGER, " +
                YEAR + " INTEGER" +
                ")";
    }

    /**
     * This method is used to write data in our database.
     *
     * @param category    Entry category
     * @param description Entry description
     * @param amount      Transaction amount
     * @param year        Transaction year
     * @param month       Transaction month
     * @param day         Transaction day
     */
    protected void writeEntry(String category, String description, float amount, int year, int month, int day) {

        // Creating writable database.
        SQLiteDatabase db = dBase.getWritableDatabase();

        // Creating content values.
        ContentValues values = new ContentValues();

        // put data in content values
        values.put(CATEGORY, category);
        values.put(DESCRIPTION, description);
        float roundedAmount;
        BigDecimal bd = new BigDecimal(Float.toString(amount));
        bd = bd.setScale(2, RoundingMode.HALF_UP);

        values.put(AMOUNT, bd.floatValue());
        values.put(YEAR, year);
        values.put(MONTH, month);
        values.put(DAY, day);

        // inserting our values in database.
        db.insert(TABLE_NAME, null, values);

        // closing database.
        db.close();

    }

    /**
     * This method is used to read data from our database.
     *
     * @return ArrayList<Entry> list of entries
     */
    public ArrayList<Entry> read() {
        ArrayList<Entry> entries = new ArrayList<>();


        //creating a readable database
        SQLiteDatabase db = dBase.getReadableDatabase();

        // getting cursor for data base
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        //reading data from cursor
        if (cursor.moveToFirst()) {
            do {
                Entry entry;
                if (TABLE_NAME.equals(Constants.Type.SPENT.toString())) {
                    entry = new Spent();
                } else {
                    entry = new Earn();
                }

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, cursor.getInt(7));
                calendar.set(Calendar.MONTH, cursor.getInt(6));
                calendar.set(Calendar.DAY_OF_MONTH, cursor.getInt(5));

                entry.setDate(calendar.getTime());
                entry.setId(cursor.getInt(0));
                entry.setCategory(cursor.getString(1));
                entry.setDescription(cursor.getString(2));
                entry.setAmount(cursor.getFloat(3));
                entries.add(entry);
            } while (cursor.moveToNext());

        }

        cursor.close();

        return entries;
    }


}
