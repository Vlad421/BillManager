package my.sdlc.billmanager.helpers.dataBase;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class EntityTable extends Table{


    DBase sqLiteOpenHelper;
    protected static final String ID = "id";
    protected static final String CATEGORY = "category";
    protected  static final String DESCRIPTION = "description";
    protected static final String AMOUNT = "amount";
    protected static final String IMAGE = "image"; //not implemented
    protected static final String DAY = "day";
    protected static final String MONTH = "month";
    protected static final String YEAR = "year";

    EntityTable(String tableName, DBase dBase) {
        super(tableName,dBase);
    }

    public String createTable() {
        return TABLE_NAME + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CATEGORY + " TEXT, " +
                DESCRIPTION + " TEXT, " +
                AMOUNT + " REAL, SIGNED, " +
                IMAGE + " BLOB, " +
                DAY+ " INTEGER, "+
                MONTH+" INTEGER, "+
                YEAR+" INTEGER"+
                ")";
    }


    protected void writeEntry(String category, String description, float amount, int year,int month ,int day){

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = dBase.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(CATEGORY, category);
        values.put(DESCRIPTION, description);
        float roundedAmount;
        BigDecimal bd = new BigDecimal(Float.toString(amount));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        //return bd.floatValue();
        values.put(AMOUNT,bd.floatValue());
        values.put(YEAR, year);
        values.put(MONTH, month);
        values.put(DAY, day);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();

    }




}
