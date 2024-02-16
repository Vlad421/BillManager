package my.sdlc.billmanager.helpers.dataBase;

public abstract class Table {


    String DATABASE_NAME;
    String TABLE_NAME;
    String ID;
    String CATEGORY;
    String AMOUNT;
    String IMAGE;
    String DAY;
    String MONTH;
    String YEAR;



Table(){

}

    abstract boolean write();

    abstract void read(DBase db);
}
