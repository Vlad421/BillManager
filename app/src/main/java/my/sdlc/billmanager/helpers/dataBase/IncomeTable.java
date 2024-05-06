package my.sdlc.billmanager.helpers.dataBase;

import my.sdlc.billmanager.helpers.Constants;

public class IncomeTable extends EntityTable {

    private static IncomeTable incomeTable;
    private static final String CAT_TYPE = String.valueOf(Constants.Type.INCOME);

    private static final String TABLE_NAME = "income";

/*  private static final String ID = "id";
    private static final String CATEGORY = "category";
    private static final String AMOUNT = "amount";
    private static final String IMAGE = "image";
    private static final String DAY = "day";
    private static final String MONTH = "month";
    private static final String YEAR = "year";
*/

    public static IncomeTable getInstance() {
        if (incomeTable == null) {
            incomeTable = new IncomeTable();
            return incomeTable;
        }
        return incomeTable;
    }

    private IncomeTable(){
        super(TABLE_NAME);

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
    void read(DBase db) {

    }
}
