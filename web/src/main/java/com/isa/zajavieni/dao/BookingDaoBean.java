package com.isa.zajavieni.dao;

import com.isa.zajavieni.entity.Booking;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BookingDaoBean {

  @PersistenceContext
  EntityManager entityManager;

  public void saveBooking(Booking booking){
    entityManager.persist(booking);
  }
  public void removeBooking(Booking booking){
    entityManager.remove(booking);
  }

  public Booking findById(Long id){
    return entityManager.find(Booking.class, id);
  }

  public List<Booking> findByUserId(Long id){
    return entityManager.createNamedQuery("Booking.findBookingByUserId")
        .setParameter("id", id).getResultList();
  }

}
