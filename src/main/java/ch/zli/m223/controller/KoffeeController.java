package ch.zli.m223.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Koffee;
import ch.zli.m223.service.KoffeeService;

@Path("/koffee")
@Tag(name = "koffee", description = "Handling of Koffee")
public class KoffeeController {

    @Inject
    KoffeeService koffeeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Koffees.", description = "Returns a list of all Koffees.")
    public List<Koffee> indexById() {
        return koffeeService.findAll();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Koffee.", description = "Returns a list of all koffee.")
    @Path("/{id}")
    public List<Koffee> index(Long id) {
        return List.of(koffeeService.getKoffeeById(id));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new user.", description = "Creates a new user and returns the newly added user.")
    public Koffee create(Koffee koffee) {
       return koffeeService.createKoffee(koffee);
    }

    @DELETE
    @Path("/{id}")
    public void delete(long id) {
    KoffeeService.deleteKoffee(id);
    }

     @PUT
     @Path("/{id}")
      public void update(Long id, Koffee koffee) {
        koffee.setId(id);
        koffeeService.update(koffee);
     }
}
