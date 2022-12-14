package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Place;
import ch.zli.m223.service.PlaceService;

@Path("/place")
@Tag(name = "place", description = "Handling of place")
public class PlaceController {

    @Inject
    PlaceService placeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Places.", description = "Returns a list of all Places.")
    public List<Place> indexById() {
        return placeService.findAll();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index one Place.", description = "Returns a list of one place.")
    @Path("/{id}")
    public Response index(Long id) {
        Place place = placeService.getPlaceById(id);
        if (place == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("There is no place registered to this id").build();
        }
        return Response.ok(place).build();
    }

    @POST
    @RolesAllowed({"Admin", "Mitglied"})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new user.", description = "Creates a new place and returns the newly added place.")
    public Response create(Place place) {
        try {
            return Response.ok(placeService.createPlace(place)).build();
        }
        catch (ConstraintViolationException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getConstraintViolations().toString()).build();
        }
    }

    @DELETE
    @RolesAllowed("Admin")
    @Path("/{id}")
    public void delete(Long id) {
    placeService.deletePlace(id);
    }

     @PUT
     @RolesAllowed("Admin")
     @Path("/{id}")
      public void update(Long id, Place place) {
        place.setId(id);
        placeService.update(place);
     }
}
