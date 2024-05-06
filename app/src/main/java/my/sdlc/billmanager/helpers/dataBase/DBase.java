package my.sdlc.billmanager.helpers.dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "manager.db";

    private static DBase db;

    private final SpentTable spentTable;
    private final IncomeTable incomeTable;


    public static DBase getInstance(Context context){
        if (db == null){
            db =  new DBase(context);
            return db;
        }
        return db;
    }



    private DBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.spentTable = SpentTable.getInstance();
        this.incomeTable = IncomeTable.getInstance();



    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        sqLiteDatabase.execSQL("CREATE TABLE " + spentTable.createTable());
        sqLiteDatabase.execSQL("CREATE TABLE " + incomeTable.createTable());

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + spentTable.getTableName());
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + incomeTable.getTableName());
        //onCreate(sqLiteDatabase);
    }


}