package my.sdlc.billmanager.helpers.dataBase;

import my.sdlc.billmanager.helpers.Constants;

public class SpentTable extends Table{

    private static SpentTable st;

    protected static final String TABLE_NAME = "spent";
    protected static final String ID = "id";
    protected static final String CATEGORY = "category";
    protected static final String AMOUNT = "amount";
    protected static final String IMAGE = "image";
    protected static final String DATE = "date";
    protected static final String MONTH = "date_month";


    public static SpentTable getInstance() {
        if (st == null) {
            st = new SpentTable();
            return st;
        }
        return st;
    }

    private SpentTable(){
        String[] cat = Constants.Categories.getCategories();
    }

    @Override
    boolean write() {
        return false;
    }

    @Override
    void read(DBase db) {


    }
}
