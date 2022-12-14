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

import ch.zli.m223.model.User;
import ch.zli.m223.service.UserService;

@Path("/user")
@Tag(name = "user", description = "Handling of User")
public class UserController {

    @Inject
    UserService userService;

    @GET
    @RolesAllowed({"Admin", "Mitglied"})
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Users.", description = "Returns a list of all users.")
    public List<User> indexById() {
        return userService.findAll();
    }


    @GET
    @RolesAllowed({"Admin", "Mitglied"})
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Users.", description = "Returns a list of all users.")
    @Path("/{id}")
    public Response index(Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("There is no user registered to this id").build();
        }
        return Response.ok(user).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new user.", description = "Creates a new user and returns the newly added user.")
    public Response create(User user) {
        try {
            return Response.ok(userService.createUser(user)).build();
        }
        catch (ConstraintViolationException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getConstraintViolations().toString()).build();
        }
    }

    @DELETE
    @RolesAllowed("Admin")
    @Path("/{id}")
    public void delete(Long id) {
    userService.deleteUser(id);
    }

     @PUT
     @RolesAllowed("Admin")
     @Path("/{id}")
      public void update(Long id, User user) {
        user.setId(id);
        userService.update(user);
     }
}
