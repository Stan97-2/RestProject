package rest.item.model;

public class Movie extends Item {

    public Movie(User user, String year, String name) {
        super(user, year, name);
    }

    public String getCategory() {
        return "movie";
    }
}
