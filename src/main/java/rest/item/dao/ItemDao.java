package rest.item.dao;

import rest.item.model.*;

import java.util.*;

public enum ItemDao {

    instance;

    private final Map<String, Item> contentProvider = new HashMap<>();

    private final Map<String, User> userList = new HashMap<>();

    ItemDao() {

        User user1 = new User("Agatha", "Londres");
        User user2 = new User("Jean", "Paris");

        userList.put("1", user1);
        userList.put("2", user2);

        Item item1 = new Book(user1, "1997", "Harry Potter and the Philosopher's Stone");
        Item item2 = new Book(user2, "1954", "The Lord of the Rings");
        Item item3 = new Movie(user2, "2018", "Avengers Infinity War");
        Item item4 = new Movie(user1, "2009", "Avatar");
        Item item5 = new VideoGame(user1, "2015", "Call of Duty: Black Ops 3");
        Item item6 = new VideoGame(user2, "2013", "The Last of Us");

        item1.setTags(Arrays.asList("magic", "school"));
        item2.setTags(Arrays.asList("magic", "super power"));
        item3.setTags(Arrays.asList("superhero", "super power", "war"));
        item4.setTags(Arrays.asList("future", "space war", "battle"));
        item5.setTags(Arrays.asList("fps", "war", "weapon"));
        item6.setTags(Arrays.asList("survival", "aventure", "apocalypse"));

        contentProvider.put("1", item1);
        contentProvider.put("2", item2);
        contentProvider.put("3", item3);
        contentProvider.put("4", item4);
        contentProvider.put("5", item5);
        contentProvider.put("6", item6);

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
