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
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Booking;
import ch.zli.m223.service.BookingService;

@Path("/booking")
@Tag(name = "booking", description = "Handling of booking")
public class BookingController {

    @Inject
    BookingService bookingService;

    @Inject
    JsonWebToken jwt;
    
    @GET
    @RolesAllowed({"Admin", "Mitglied"})
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Bookings.", description = "Returns a list of all bookings.")
    public List<Booking> indexById() {
        return bookingService.findAll();
    }


    @GET
    @RolesAllowed({"Admin", "Mitglied"})
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Users.", description = "Returns a list of all users.")
    @Path("/{id}")
    public Response index(Long id) {
        Booking booking = bookingService.getBookingById(id);
        if (booking == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("There is no Booking registered to this id").build();
        }
        return Response.ok(booking).build();
    }

    @POST
    @RolesAllowed({"Admin", "Mitglied"})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new user.", description = "Creates a new user and returns the newly added user.")
    public Response createBooking(Booking booking) {
        try {
            return Response.ok(bookingService.createBooking(booking)).build();
        }
        catch (ConstraintViolationException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getConstraintViolations().toString()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"Admin", "Mitglied"})
    public void delete(Long id) {
    bookingService.deleteBooking(id);
    }

    @PUT
    @RolesAllowed({"Admin", "Mitglied"})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response update(Long id, Booking booking) {
        if (booking.getUser().getId().toString().equals(jwt.getClaim("id").toString()) || jwt.getGroups().contains("Admin")) {
            booking.setId(id);
            bookingService.update(booking);
            return Response.ok(booking).build();
        }
        return Response.status(Status.UNAUTHORIZED).build();
    }
}
