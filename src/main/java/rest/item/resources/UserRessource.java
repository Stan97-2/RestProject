package rest.item.resources;

import rest.item.dao.ItemDao;
import rest.item.model.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserRessource {

    // Add an item to the items list (TO COMPLETE)
    @POST
    @Path("{userId}/add")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public void addItem(@PathParam("userId") String userId,
                        @FormParam("category") String category,
                        @FormParam("name") String name,
                        @FormParam("year") String year) {

        Item item;

        if (category == "movie") {
            item = new Movie(ItemDao.instance.getUsers().get(userId), name, year);
        } else if (category == "book") {
            item = new Book(ItemDao.instance.getUsers().get(userId), name, year);
        } else {
            item = new VideoGame(ItemDao.instance.getUsers().get(userId), name, year);
        }

        ItemDao.instance.getModel().put(String.valueOf(ItemDao.instance.getModel().size()), item);
    }

    // Delete a given item (DONE)
    @DELETE
    @Path("{userId}/delete/{itemId}")
    public void deleteItem(@PathParam("userId") String userId, @PathParam("itemId") String itemId) {
        Item item = ItemDao.instance.getModel().get(itemId);
        if (Integer.parseInt(userId) == item.getOwnerId()) {
            ItemDao.instance.getModel().remove(itemId);
        } else {
            throw new RuntimeException("Not allowed to delete this item");
        }
    }

    // Update details about a specific item
    @PUT
    @Path("{userId}/update/{itemId}")
    public void updateItem(@PathParam("userId") String userId, @PathParam("itemId") String itemId) {
        // TODO
    }

    // Borrow a specific item (DONE)
    @PUT
    @Path("{userId}/borrow/{itemId}")
    public void borrowItem(@PathParam("userId") String userId, @PathParam("itemId") String itemId) {
        Item item = ItemDao.instance.getModel().get(userId);
        if (item == null) {
            throw new RuntimeException("Item with id " + itemId +  " not found");
        }
        item.setBorrowed(true);
    }

    // Buy a specific item (DONE)
    @DELETE
    @Path("{userId}/buy/{itemId}")
    public void buyItem(@PathParam("userId") String userId, @PathParam("itemId") String itemId) {
        Item item = ItemDao.instance.getModel().get(itemId);
        if (Integer.parseInt(userId) != item.getOwnerId()) {
            ItemDao.instance.getModel().remove(itemId);
        } else {
            throw new RuntimeException("You already own this item you can't buy it");
        }
    }

    // Add a review to a specific item
    @POST
    @Path("{userId}/item/{itemId}/review")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public void addReview(@PathParam("userId") String userId,
                          @PathParam("itemId") String itemId,
                          @FormParam("rate") String rate,
                          @FormParam("comment") String comment) {

        Item item = ItemDao.instance.getModel().get(itemId);
        if ((Integer.parseInt(rate) >= 0) && (Integer.parseInt(rate) <= 5)) {
            item.addReview(new Review(Integer.parseInt(userId), item.getId(), Integer.parseInt(rate), comment));
        } else {
            throw new RuntimeException("Rate must be between 0 and 5");
        }

    }
}
