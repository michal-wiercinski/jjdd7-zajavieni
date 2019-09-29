package com.isa.zajavieni.entity;

import com.isa.zajavieni.entity.Event;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamedQueries({
    @NamedQuery(
        name = "PopularityFavouriteEvent.findAll",
        query = "SELECT e FROM PopularityFavouriteEvent e ORDER BY e.quantity DESC"
    ),
    @NamedQuery(
        name = "PopularityFavouriteEvent.incrementQuantity",
        query = "UPDATE PopularityFavouriteEvent e SET e.quantity=e.quantity+1 WHERE e.id=:id"
    )
}
)
@Entity
@Table(name = "favourite_event_popularity")
public class PopularityFavouriteEvent {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @OneToOne(mappedBy = "popularityFavouriteEvent")
  private Event event;

  @Column(name = "quantity")
  @NotNull
  private Integer quantity = 0;

  public PopularityFavouriteEvent() {
  }

  public PopularityFavouriteEvent(Event event,
      @NotNull Integer quantity) {
    this.event = event;
    this.quantity = quantity;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
