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

import ch.zli.m223.model.Booking;
import ch.zli.m223.service.BookingService;

@Path("/booking")
@Tag(name = "booking", description = "Handling of booking")
public class BookingController {

    @Inject
    BookingService bookingService;

    @GET
    @RolesAllowed("benutzer")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Bookings.", description = "Returns a list of all bookings.")
    public List<Booking> indexById() {
        return bookingService.findAll();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Users.", description = "Returns a list of all users.")
    @Path("/{id}")
    public List<Booking> index(Long id) {
        return List.of(bookingService.getBookingById(id));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new user.", description = "Creates a new user and returns the newly added user.")
    public Booking create(Booking booking) {
       return bookingService.createBooking(booking);
    }

    @DELETE
    @Path("/{id}")
    public void delete(long id) {
    bookingService.deleteBooking(id);
    }

     @PUT
     @Path("/{id}")
      public void update(Long id, Booking booking) {
        booking.setId(id);
        bookingService.update(booking);
     }
}
