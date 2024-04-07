package my.sdlc.billmanager.helpers.dataBase;

import android.content.Context;

public class DBManager {

    static DBManager dbManager;
    private  DBase dataBase;
    private Context context;


    public static  DBManager getDbManager(Context c){
        if (dbManager == null) {
            dbManager = new DBManager(c);
            return dbManager;
        }
        return dbManager;
    }
    private DBManager(Context context){
        this.context = context;
    }


}
