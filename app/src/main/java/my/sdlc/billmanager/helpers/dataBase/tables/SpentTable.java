/*
 * Copyright (c) 2024.
 * Vlad421 https://github.com/Vlad421
 */

package my.sdlc.billmanager.helpers.dataBase.tables;

import java.util.Map;

import my.sdlc.billmanager.helpers.Constants;
import my.sdlc.billmanager.helpers.dataBase.DBase;

/**
 * @author Vlad421 <a href="https://github.com/Vlad421">...</a>
 *
 */
public class SpentTable extends EntryTable {
    /**
     * Spend transaction table
     */

    private static SpentTable spentTable;
    private static final String CAT_TYPE = String.valueOf(Constants.Type.SPENT);


   private static final String TABLE_NAME = "spent";

    /**
     * Get instance of SpentTable
     * @param dBase dataBase
     * @return SpentTable
     */
    public static SpentTable getInstance(DBase dBase) {
        if (spentTable == null) {
            spentTable = new SpentTable(dBase);
            return spentTable;
        }
        return spentTable;
    }

    /**
     * Private constructor
     * @param dBase dataBase
     */
    private SpentTable(DBase dBase) {
        super(TABLE_NAME,dBase);
        Map<String, String> cat = Constants.Categories.getDefaultSpentCategories();
    }


    /**
     * Write entry to table
     * @param category Spent category
     * @param description Spent description
     * @param amount Transaction amount
     * @param year Transaction year
     * @param month Transaction month
     * @param day Transaction day
     */
    @Override
    public void writeEntry(String category, String description, float amount, int year, int month, int day) {
        super.writeEntry(category, description, amount, year, month, day);
    }

    @Override
    public void read(DBase db) {


    }

}
