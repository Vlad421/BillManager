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

public abstract class EntryTable extends Table {


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


    protected void writeEntry(String category, String description, float amount, int year, int month, int day) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = dBase.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(CATEGORY, category);
        values.put(DESCRIPTION, description);
        float roundedAmount;
        BigDecimal bd = new BigDecimal(Float.toString(amount));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        //return bd.floatValue();
        values.put(AMOUNT, bd.floatValue());
        values.put(YEAR, year);
        values.put(MONTH, month);
        values.put(DAY, day);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();

    }

    public ArrayList<Entry> read() {
        ArrayList<Entry> entries = new ArrayList<>();


        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = dBase.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.


        // moving our cursor to first position.
        if (cursor.moveToFirst()) {
            do {
                Entry entry;
                if (TABLE_NAME.equals(Constants.Type.SPENT.toString())) {
                    entry = new Spent();
                } else {
                    entry = new Earn();
                }
                // on below line we are adding the data from cursor to our array list.
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
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursor.close();

        return entries;
    }


}
