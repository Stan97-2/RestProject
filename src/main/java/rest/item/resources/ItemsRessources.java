package rest.item.resources;

import rest.item.dao.ItemDao;
import rest.item.model.Item;
import rest.item.model.Review;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;


@Path("/items")
public class ItemsRessources {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    // Get all items
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Item> getItems() {
        return new ArrayList<>(ItemDao.instance.getModel().values());
    }

    // Get details about a given item
    @GET
    @Path("{itemId}")
    @Produces({MediaType.APPLICATION_JSON})
    public ItemRessource getItem(@PathParam("itemId") String id) {
        return new ItemRessource(uriInfo, request, id);
    }

    // Get all the reviews of a given item
    @GET
    @Path("{itemId}/reviews")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Review> getItemReviews(@PathParam("itemId") String id) {
        return new ArrayList<>(ItemDao.instance.getModel().get(id).getReviews());
    }

    // Search items by user
    @GET
    @Path("user/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Item> getItemsByUser(@PathParam("userId") String userId) {
        return new ArrayList<>(ItemDao.instance.searchingByUser(Integer.parseInt(userId)).values());
    }

    // Search items by category
    @GET
    @Path("category/{category}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Item> getItemsByCategory(@PathParam("category") String category) {
        return new ArrayList<>(ItemDao.instance.searchingByCategory(category).values());
    }

    // Search items by keyword
    @GET
    @Path("keyword/{keyword}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Item> getItemsByKeyword(@PathParam("keyword") String keyword) {
        return new ArrayList<>(ItemDao.instance.searchingByKeyword(keyword).values());
    }

    // Search items by city
    @GET
    @Path("city/{city}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Item> getItemsByCity(@PathParam("city") String city) {
        return new ArrayList<>(ItemDao.instance.searchingByCity(city).values());
    }
}
