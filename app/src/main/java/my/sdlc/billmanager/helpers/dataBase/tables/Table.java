/*
 * Copyright (c) 2024.
 * Vlad421 https://github.com/Vlad421
 */

package my.sdlc.billmanager.helpers.dataBase.tables;

import my.sdlc.billmanager.helpers.dataBase.DBase;
/**
 * @author Vlad421 <a href="https://github.com/Vlad421">...</a>
 */
public abstract class Table {
    /**
     * Abstract class for data base tables
     */

    protected   final String TABLE_NAME;
    protected   final DBase dBase;

    /**
     *
     * @param tableName table name
     * @param dBase data base
     */
    public Table(String tableName,DBase dBase){
        this.TABLE_NAME = tableName;
        this.dBase = dBase;
    }

    abstract void read(DBase db);

    /**
     *
     * @return table name
     */
    public String getTableName() {
        return TABLE_NAME;
    }
}
