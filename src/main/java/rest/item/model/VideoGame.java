package rest.item.model;

public class VideoGame extends Item {

    public VideoGame(User user, String year, String name) {
        super(user, year, name);
    }

    public String getCategory() {
        return "video-game";
    }
}
