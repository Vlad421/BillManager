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



    public static SpentTable getInstance(DBase dBase) {
        if (spentTable == null) {
            spentTable = new SpentTable(dBase);
            return spentTable;
        }
        return spentTable;
    }

    private SpentTable(DBase dBase) {
        super(TABLE_NAME,dBase);
        Map<String, String> cat = Constants.Categories.getDefaultSpentCategories();
    }


    @Override
    public void writeEntry(String category, String description, float amount, int year, int month, int day) {
        super.writeEntry(category, description, amount, year, month, day);
    }

    @Override
    void read(DBase db) {


    }

}
