package rest.item.model;

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


  /* public Owner getOwner(int userId) {
        return
    }
    */
}
