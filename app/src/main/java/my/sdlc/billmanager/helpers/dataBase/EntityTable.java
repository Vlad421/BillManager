package my.sdlc.billmanager.helpers.dataBase;

public abstract class EntityTable extends Table{


    protected static final String ID = "id";
    protected static final String CATEGORY = "category";
    protected static final String AMOUNT = "amount";
    protected static final String IMAGE = "image";
    protected static final String DAY = "day";
    protected static final String MONTH = "month";
    protected static final String YEAR = "year";

    EntityTable(String tableName) {
        super(tableName);
    }

    public String createTable() {
        return TABLE_NAME + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CATEGORY + " TEXT, " +
                AMOUNT + " REAL, SIGNED, " +
                IMAGE + " BLOB, " +
                DAY+ " INTEGER, "+
                MONTH+" INTEGER, "+
                YEAR+" INTEGER, "+
                ")";
    }





}
