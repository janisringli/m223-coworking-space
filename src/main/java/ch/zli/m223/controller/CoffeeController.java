package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
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

import ch.zli.m223.model.Coffee;
import ch.zli.m223.service.CoffeeService;

@Path("/coffee")
@Tag(name = "coffee", description = "Handling of Coffee")
public class CoffeeController {

    @Inject
    CoffeeService coffeeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Coffees.", description = "Returns a list of all Coffees.")
    public List<Coffee> indexById() {
        return coffeeService.findAll();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Coffee.", description = "Returns a list of all Coffee.")
    @Path("/{id}")
    public List<Coffee> index(Long id) {
        return List.of(coffeeService.getCoffeeById(id));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a Coffee. Consider getting yourself one aswell", description = "Creates a Coffee. Consider getting yourself one aswell")
    public Coffee create(Coffee coffee) {
       return coffeeService.createCoffee(coffee);
    }

    @DELETE
    @RolesAllowed("Admin")
    @Path("/{id}")
    public void delete(Long id) {
    coffeeService.deleteCoffee(id);
    }

    @PUT
    @RolesAllowed("Admin")
     @Path("/{id}")
      public void update(Long id, Coffee Coffee) {
        Coffee.setId(id);
        coffeeService.update(Coffee);
     }
}
