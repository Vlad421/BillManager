package my.sdlc.billmanager.helpers.dataBase;

public abstract class Table {

    public  final String TABLE_NAME;

    public Table(String tableName){
        this.TABLE_NAME = tableName;
    }

    abstract void read(DBase db);

    public String getTableName() {
        return TABLE_NAME;
    }
}
