package rest.item.model;

import rest.item.dao.ItemDao;

import java.security.acl.Owner;
import java.util.List;

public class User {

    private int id;
    private static int idCount = 1;
    private String name;
    private String city;

    // Constructor
    public User(String name, String city) {
        this.id = idCount++;
        this.name = name;
        this.city = city;
    }


    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Methods
    public void deleteItem(int itemId) {
       Item item = ItemDao.instance.getModel().get(itemId);
       if (item.getOwner() == this) {
           ItemDao.instance.getModel().remove(itemId);
       } else if (item == null) {
           throw new RuntimeException("Delete: Todo with " + id +  " not found");
       } else {
           throw new RuntimeException("You are not the owner of this item so you can't delete it");
       }
    }

  /* public Owner getOwner(int userId) {
        return
    }
    */
}