/*
 * Copyright (c) 2024.
 * Vlad421 https://github.com/Vlad421
 */

package my.sdlc.billmanager.helpers.dataBase.tables;

import my.sdlc.billmanager.helpers.dataBase.DBase;

/**
 * @author Vlad421 <a href="https://github.com/Vlad421">...</a>
 */
public class IncomeTable extends EntryTable {
    /**
     * The income table
     */
    private static IncomeTable incomeTable;


    private static final String TABLE_NAME = "income";


    /**
     * Get the income table
     *
     * @param dBase the database
     * @return the income table instance
     */
    public static IncomeTable getInstance(DBase dBase) {
        if (incomeTable == null) {
            incomeTable = new IncomeTable(dBase);
            return incomeTable;
        }
        return incomeTable;
    }

    private IncomeTable(DBase dBase) {
        super(TABLE_NAME, dBase);

    }


    /**
     * Write an entry to the database
     *
     * @param category    Entry category
     * @param description Entry description
     * @param amount      Transaction amount
     * @param year        Transaction year
     * @param month       Transaction month
     * @param day         Transaction day
     */
    @Override
    public void writeEntry(String category, String description, float amount, int year, int month, int day) {
        super.writeEntry(category, description, amount, year, month, day);
    }


    @Override
    void read(DBase db) {

    }
}
