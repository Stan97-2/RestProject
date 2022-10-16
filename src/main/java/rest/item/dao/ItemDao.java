package rest.item.dao;

import rest.item.model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum ItemDao {

    instance;

    private final Map<String, Item> contentProvider = new HashMap<>();

    private final Map<String, User> userList = new HashMap<>();

    ItemDao() {

        User user1 = new User("Agatha", "Londres");
        User user2 = new User("Jean", "Paris");

        userList.put("1", user1);
        userList.put("2", user2);

        Item item1 = new Book(user1, "2002", "Harry Potter");
        Item item2 = new Item(user2, "2009", "Le Seigneur des Anneaux");

        item1.addTag("magie");
        item2.addTag("aventure");

        contentProvider.put("1", item1);
        contentProvider.put("2", item2);
    }

    public Map<String, Item> getModel() {
        return contentProvider;
    }

    public Map<String, User> getUsers() {
        return userList;
    }

    public Map<String, Item> searchingByCategory(String category) {
        Map<String, Item> content = new HashMap<>();

        if (Objects.equals(category, "movie")) {
            for (Item item: contentProvider.values()) {
                if (item instanceof Movie ) {
                    content.put(String.valueOf(content.size()+1), item);
                }
            }
        } else if (Objects.equals(category, "book")) {
            for (Item item: contentProvider.values()) {
                if (item instanceof Book) {
                    content.put(String.valueOf(content.size()+1), item);
                }
            }

        }  else if (Objects.equals(category, "video-game")) {
            for (Item item: contentProvider.values()) {
                if (item instanceof VideoGame) {
                    content.put(String.valueOf(content.size()+1), item);
                }
            }
        }
        return content;
    }

    public Map<String, Item> searchingByKeyword(String keyword) {
        Map<String, Item> content = new HashMap<>();

        for (Item item: contentProvider.values()) {
            if (item.getTags().contains(keyword)) {
                content.put(String.valueOf(content.size()+1), item);
            }
        }
        return content;
    }

    public Map<String, Item> searchingByCity(String city) {
        Map<String, Item> content = new HashMap<>();

        for (Item item: contentProvider.values()) {
            if (item.getOwner().getCity().equalsIgnoreCase(city)) {
                content.put(String.valueOf(content.size()+1), item);
            }
        }

        return content;
    }

    public Map<String, Item> searchingByUser(int userId) {
        Map<String, Item> content = new HashMap<>();

        for (Item item: contentProvider.values()) {
            if (item.getOwner().getId() == userId) {
                content.put(String.valueOf(content.size()+1), item);
            }
        }
        return content;
    }


}
