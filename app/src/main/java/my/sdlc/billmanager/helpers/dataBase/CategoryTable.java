package my.sdlc.billmanager.helpers.dataBase;

import android.content.ContentValues;

public class CategoryTable extends Table {




    private static IncomeTable incomeTable;

    private static final String TABLE_NAME = "categories";
    private static final String TYPE = "type";
    private static final String CATEGORY = "category_id";
    private static final String CAT_DESC = "category_desc";

    CategoryTable(String tableName) {
        super(tableName);
    }


    public String createTable() {
        return TABLE_NAME + " (" +
                TYPE + " TEXT, " +
                CATEGORY + " TEXT, " +
                CAT_DESC + " TEXT " +


                ")";
    }

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
