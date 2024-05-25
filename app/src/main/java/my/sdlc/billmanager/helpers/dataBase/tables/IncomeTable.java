package my.sdlc.billmanager.helpers.dataBase.tables;

import my.sdlc.billmanager.helpers.dataBase.DBase;

public class IncomeTable extends EntryTable {

    private static IncomeTable incomeTable;


    private static final String TABLE_NAME = "income";



    public static IncomeTable getInstance(DBase dBase) {
        if (incomeTable == null) {
            incomeTable = new IncomeTable(dBase);
            return incomeTable;
        }
        return incomeTable;
    }

    private IncomeTable(DBase dBase){
        super(TABLE_NAME, dBase);

    }



    @Override
    public void writeEntry(String category, String description, float amount, int year, int month, int day) {
        super.writeEntry(category, description, amount, year, month, day);
    }


    @Override
    void read(DBase db) {

    }
}
