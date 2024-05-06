package my.sdlc.billmanager.helpers.dataBase;

import java.util.Map;

import my.sdlc.billmanager.helpers.Constants;

public class SpentTable extends EntityTable {

    private static SpentTable spentTable;
    private static final String CAT_TYPE = String.valueOf(Constants.Type.SPENT);


   private static final String TABLE_NAME = "spent";
/* private static final String ID = "id";
   private static final String CATEGORY = "category";
   private static final String AMOUNT = "amount";
   private static final String IMAGE = "image";
   private static final String DAY = "day";
   private static final String MONTH = "month";
   private static final String YEAR = "year";
*/



    public static SpentTable getInstance() {
        if (spentTable == null) {
            spentTable = new SpentTable();
            return spentTable;
        }
        return spentTable;
    }

    private SpentTable() {
        super(TABLE_NAME);
        Map<String, String> cat = Constants.Categories.getDefaultSpentCategories();
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
