package rest.item.resources;

import rest.item.dao.ItemDao;
import rest.item.model.Item;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

public class ItemRessource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;

    public ItemRessource(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Item getItem() {
        Item item = ItemDao.instance.getModel().get(id);
        if (item == null) {
            throw new RuntimeException("Get: Item with " + id +  " not found");
        }
        return item;
    }
}
