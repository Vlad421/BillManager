package my.sdlc.billmanager.helpers.dataBase;

public class CategoryTable extends Table{

    private static IncomeTable incomeTable;

    private static final String TABLE_NAME = "categories";
    private static final String TYPE = "type";
    private static final String CATEGORY = "category_id";
    private  static final String CAT_DESC = "category_desc";




    public String createTable() {
        return TABLE_NAME + " (" +
                TYPE + " TEXT, " +
                CATEGORY + " TEXT, " +
                CAT_DESC + " TEXT " +


                ")";
    }
    @Override
    boolean write() {
        return false;
    }

    @Override
    void read(DBase db) {

    }
}
