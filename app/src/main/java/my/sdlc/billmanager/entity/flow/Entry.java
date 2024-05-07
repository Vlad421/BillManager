package my.sdlc.billmanager.entity.flow;

import java.math.BigDecimal;
import java.util.Date;

abstract class Entry {


 private String category;
 private String ID;
 private String amount ;
 private String image;
 private Date date;
 private String type;



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

 public String getAmount() {
  return amount;
 }

 public void setAmount(String amount) {
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
}
