package rest.item.model;

import java.util.ArrayList;
import java.util.List;

public class Item {

    private int id;
    private static int idCount = 1;
    private User owner;
    private String year;
    private String name;
    private boolean isBorrowed;
    private List<String> tags;
    protected List<Review> reviews;

    public Item(User owner, String year, String name) {
        this.id = idCount++;
        this.owner = owner;
        this.year = year;
        this.name = name;
        this.isBorrowed = false;
        tags = new ArrayList<>();
        reviews = new ArrayList<>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }


    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }
}
