package my.sdlc.billmanager.entity.flow;

import java.math.BigDecimal;
import java.util.Date;

public abstract class Entry {


    private String category;
    private String description;
    private String ID;
    private float amount;
    private String image;
    private Date date;
    private String type;
    private int id;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;

    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }
}
