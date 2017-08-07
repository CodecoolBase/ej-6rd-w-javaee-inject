package hu.codecool.contact.handler;

import hu.codecool.contact.api.ContactManager;
import hu.codecool.contact.model.Contact;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/contacts")
public class ContactHandler {

    @Inject
    private ContactManager contactManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Contact findFirst(@QueryParam("query") String query) {
        return contactManager.findFirst(query);
    }
}
