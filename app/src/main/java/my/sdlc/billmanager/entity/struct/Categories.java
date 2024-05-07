package my.sdlc.billmanager.entity.struct;

import java.util.ArrayList;

import my.sdlc.billmanager.helpers.Constants;

public class Categories {
    protected ArrayList<String> categories;

    Categories(){

        this.categories = new ArrayList<>();
    }

    public void add(String cat){
        this.categories.add(cat);
    }

    public ArrayList<String> getCategories() {
        return categories;
    }
}
