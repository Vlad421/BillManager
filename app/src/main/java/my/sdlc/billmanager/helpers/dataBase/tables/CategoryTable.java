/*
 * Copyright (c) 2024.
 * Vlad421 https://github.com/Vlad421
 */

package my.sdlc.billmanager.helpers.dataBase.tables;

import android.content.ContentValues;

import my.sdlc.billmanager.helpers.dataBase.DBase;
/**
 * @author Vlad421 <a href="https://github.com/Vlad421">...</a>
 */
public class CategoryTable extends Table {
    /**
     * CategoryTable handles categories table in database
     */



    private static IncomeTable incomeTable;

    private static final String TABLE_NAME = "categories";
    private static final String TYPE = "type";
    private static final String CATEGORY = "category_id";
    private static final String CAT_DESC = "category_desc";

    /**
     * CategoryTable constructor
     * @param tableName table name
     * @param dBase database
     */
    CategoryTable(String tableName, DBase dBase) {
        super(tableName,dBase);
    }

    /**
     * Creates table
     * @return string query
     */
    public String createTable() {
        return TABLE_NAME + " (" +
                TYPE + " TEXT, " +
                CATEGORY + " TEXT, " +
                CAT_DESC + " TEXT " +


                ")";
    }

    /**
     * Writes data to database
     * @param dBase database
     * @param type type of category
     * @param category category
     * @param desc description
     */
    void write(DBase dBase, String type, String category, String desc) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(TYPE, type);
        contentValue.put(CATEGORY, category);
        contentValue.put(CAT_DESC, desc);
        dBase.getWritableDatabase().insert(TABLE_NAME, null, contentValue);
    }


    @Override
    void read(DBase db) {

    }
}
