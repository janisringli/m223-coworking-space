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

import ch.zli.m223.model.Roles;
import ch.zli.m223.service.RolesService;

@Path("/roles")
@Tag(name = "roles", description = "Handling of Roles")
public class RolesController {

    @Inject
    RolesService rolesService;

    @GET
    @RolesAllowed("Admin")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Roles.", description = "Returns a list of all users.")
    public List<Roles> indexById() {
        return rolesService.findAll();
    }

    @GET
    @RolesAllowed("Admin")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index a single Role.", description = "Returns a list of a single role.")
    @Path("/{id}")
    public Response index(Long id) {
        Roles roles = rolesService.getRolesById(id);
        if (roles == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("There are no roles registered to this id").build();
        }
        return Response.ok(roles).build();
    }

    @POST
    @RolesAllowed("Admin")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new role.", description = "Creates a new role and returns the newly added user.")
    public Response create(Roles roles) {
        try {
            return Response.ok(rolesService.createRoles(roles)).build();
        }
        catch (ConstraintViolationException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getConstraintViolations().toString()).build();
        }
    }

    @DELETE
    @RolesAllowed("Admin")
    @Path("/{id}")
    public void delete(Long id) {
    rolesService.deleteRoles(id);
    }

     @PUT
     @RolesAllowed("Admin")
     @Path("/{id}")
      public void update(Long id, Roles roles) {
        roles.setId(id);
        rolesService.update(roles);
     }
}
