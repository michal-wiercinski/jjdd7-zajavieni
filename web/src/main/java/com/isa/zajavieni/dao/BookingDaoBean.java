package com.isa.zajavieni.dao;

import com.isa.zajavieni.entity.Booking;
import com.isa.zajavieni.entity.User;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class BookingDaoBean {

  Logger logger = LoggerFactory.getLogger(getClass().getName());

  @PersistenceContext
  EntityManager entityManager;

  public void save(Booking booking) {
    entityManager.persist(booking);
  }

  public void deleteById(Long id) {
    Booking booking = findById(id);
    if (booking != null) {
      entityManager.remove(booking);
    }
  }

  /*public Long findIdByEventAndUser(Long eventId, Long userId) {
    Query query = entityManager.createNamedQuery("Booking.findByEventAndUser");
    query.setParameter("event_id", eventId)
        .setParameter("user_id", userId);
    Long bookingId = (Long)query.getSingleResult();
    return bookingId;
  }*/

  public Booking findById(Long id) {
    return entityManager.find(Booking.class, id);
  }

  public List<Booking> findByUserId(Long id) {
    Query query = entityManager.createNamedQuery("Booking.findBookingByUserId");
    query.setParameter("id", id).getResultList();
    return query.getResultList();
  }

  public Optional<Booking> findByEventAndUser(Long eventId, Long userId) {
    Query query = entityManager.createNamedQuery("Booking.findByEventAndUser");
    query.setParameter("event_id", eventId)
        .setParameter("user_id", userId);
    List<Booking> bookings = query.getResultList();
    if (bookings.isEmpty()) {
      logger
          .warn("Booking with id for user: {} and id for event: {} isn't exist.", userId, eventId);
      return Optional.empty();
    }
    return Optional.of(bookings.get(0));
  }
}
