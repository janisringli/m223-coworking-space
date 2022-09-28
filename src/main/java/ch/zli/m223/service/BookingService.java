package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import ch.zli.m223.model.Booking;

@ApplicationScoped
public class BookingService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Booking createBooking (@Valid Booking booking) {
        entityManager.persist(booking);
        return booking;
    }

    @Transactional
    public void deleteBooking(Long id) {
        Booking booking =  entityManager.find(Booking.class, id);
        entityManager.remove(booking);
    }

    @Transactional
    public void update(Booking booking){
        entityManager.merge(booking);
    }
    public List<Booking> findAll() {
        var query = entityManager.createQuery("FROM Booking", Booking.class);
        return query.getResultList();
    }
    public Booking getBookingById(Long id){
        return entityManager.find(Booking.class, id);
    }
}
