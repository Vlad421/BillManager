package my.sdlc.billmanager.helpers.dataBase;

public abstract class Table {


    Table() {

    }

    abstract boolean write();

    abstract void read(DBase db);
}
