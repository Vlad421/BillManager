package my.sdlc.billmanager.helpers.dataBase;

import android.content.Context;
import android.widget.Toast;

import my.sdlc.billmanager.helpers.Constants;

public class DBManager {

    private DBase dB;
    private Context context;

    private static DBManager dbManager;

    public static DBManager getInstance(Context context) {
        if (dbManager == null) {
            dbManager = new DBManager(context);
            return dbManager;
        }
        return dbManager;
    }

    private DBManager(Context context) {
        this.context = context;
        this.dB = DBase.getInstance(context);
    }

    public void writeEntry(String database, String category, String description, float amount, int year, int month, int day) {


        if (database.equals(Constants.Type.INCOME.toString())) {
            Toast.makeText(context, "Income",Toast.LENGTH_SHORT).show();
            dB.getIncomeTable().writeEntry(category, description, amount, year, month, day);
        } else if (database.equals(Constants.Type.SPENT.toString())) {
            Toast.makeText(context, "Spent",Toast.LENGTH_SHORT).show();
            dB.getSpentTable().writeEntry(category, description, amount, year, month, day);
        }


    }


}
