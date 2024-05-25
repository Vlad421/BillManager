package my.sdlc.billmanager.helpers.dataBase.tables;

import java.util.Map;

import my.sdlc.billmanager.helpers.Constants;
import my.sdlc.billmanager.helpers.dataBase.DBase;

public class SpentTable extends EntryTable {

    private static SpentTable spentTable;
    private static final String CAT_TYPE = String.valueOf(Constants.Type.SPENT);


   private static final String TABLE_NAME = "spent";


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
    public void read(DBase db) {


    }

}
