/*
 * Copyright (c) 2024.
 * Vlad421 https://github.com/Vlad421
 */

package my.sdlc.billmanager.helpers.dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import my.sdlc.billmanager.helpers.dataBase.tables.IncomeTable;
import my.sdlc.billmanager.helpers.dataBase.tables.SpentTable;

/**
 * @author Vlad421 <a href="https://github.com/Vlad421">...</a>
 */
public class DBase extends SQLiteOpenHelper {
    /**
     * Database Version
     */

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "manager.db";

    private static DBase db;

    private final SpentTable spentTable;
    private final IncomeTable incomeTable;

    /**
     *
     * @param context app context
     * @return DBase instance
     */
    public static DBase getInstance(Context context){
        if (db == null){
            db =  new DBase(context);
            return db;
        }
        return db;
    }


    /**
     * Constructor
     * @param context app context
     */
    private DBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.spentTable = SpentTable.getInstance(this);
        this.incomeTable = IncomeTable.getInstance(this);



    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        sqLiteDatabase.execSQL("CREATE TABLE " + spentTable.createTable());
        sqLiteDatabase.execSQL("CREATE TABLE " + incomeTable.createTable());

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + spentTable.getTableName());
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + incomeTable.getTableName());
        onCreate(sqLiteDatabase);
    }

    public SpentTable getSpentTable() {
        return spentTable;
    }

    public IncomeTable getIncomeTable() {
        return incomeTable;
    }
}