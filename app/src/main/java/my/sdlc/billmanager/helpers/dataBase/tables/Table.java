package my.sdlc.billmanager.helpers.dataBase.tables;

import my.sdlc.billmanager.helpers.dataBase.DBase;

public abstract class Table {

    protected   final String TABLE_NAME;
    protected   final DBase dBase;

    public Table(String tableName,DBase dBase){
        this.TABLE_NAME = tableName;
        this.dBase = dBase;
    }

    abstract void read(DBase db);

    public String getTableName() {
        return TABLE_NAME;
    }
}
