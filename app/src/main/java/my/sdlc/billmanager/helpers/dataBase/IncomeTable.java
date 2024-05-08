package my.sdlc.billmanager.helpers.dataBase;

import my.sdlc.billmanager.helpers.Constants;

public class IncomeTable extends EntityTable {

    private static IncomeTable incomeTable;


    private static final String TABLE_NAME = "income";

/*  private static final String ID = "id";
    private static final String CATEGORY = "category";
    private static final String AMOUNT = "amount";
    private static final String IMAGE = "image";
    private static final String DAY = "day";
    private static final String MONTH = "month";
    private static final String YEAR = "year";
*/

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

/*    public String createTable() {
        return TABLE_NAME + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CATEGORY + " TEXT, " +
                AMOUNT + " REAL, SIGNED, " +
                IMAGE + " BLOB, " +
                DAY+ " INTEGER, "+
                MONTH+" INTEGER, "+
                YEAR+" INTEGER, "+
                ")";
    }*/

    @Override
    public void writeEntry(String category, String description, float amount, int year, int month, int day) {
        super.writeEntry(category, description, amount, year, month, day);
    }

    @Override
    void read(DBase db) {

    }
}
