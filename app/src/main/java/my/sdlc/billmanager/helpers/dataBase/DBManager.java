/*
 * Copyright (c) 2024.
 * Vlad421 https://github.com/Vlad421
 */

package my.sdlc.billmanager.helpers.dataBase;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

import my.sdlc.billmanager.entity.flow.Entry;
import my.sdlc.billmanager.helpers.Constants;
/**
 * @author Vlad421 <a href="https://github.com/Vlad421">...</a>
 */
public class DBManager {
    /**
     * Data base manager class
     */

    private DBase dB;
    private Context context;

    private static DBManager dbManager;

    /**
     *
     * @param context app context
     * @return DBManager
     */
    public static DBManager getInstance(Context context) {
        if (dbManager == null) {
            dbManager = new DBManager(context);
            return dbManager;
        }
        return dbManager;
    }

    private DBManager(Context context) {
        this.context = context;
        this.dB = DBase.getInstance(context);
    }

    /**
     * Write entry to database
     * @param database database name
     * @param category entry category
     * @param description entry description
     * @param amount transaction amount
     * @param year transaction year
     * @param month transaction month
     * @param day transaction day
     */
    public void writeEntry(String database, String category, String description, float amount, int year, int month, int day) {


        if (database.equals(Constants.Type.INCOME.toString())) {
            Toast.makeText(context, "Income",Toast.LENGTH_SHORT).show();
            dB.getIncomeTable().writeEntry(category, description, amount, year, month, day);
        } else if (database.equals(Constants.Type.SPENT.toString())) {
            Toast.makeText(context, "Spent",Toast.LENGTH_SHORT).show();
            dB.getSpentTable().writeEntry(category, description, amount, year, month, day);
        }


    }

    /**
     * Read entries from database
     * @return ArrayList<Entry>
     */
    public ArrayList<Entry> readEntries() {
        return dB.getIncomeTable().read();
    }
}
