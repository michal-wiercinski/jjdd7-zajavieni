package com.isa.zajavieni.entity.createdentity;

import com.isa.zajavieni.entity.fromapi.Event;
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
        name = "PopularityEvent.findAll",
        query = "SELECT e FROM PopularityEvent e ORDER BY e.quantity DESC"
    ),
    @NamedQuery(
        name = "PopularityEvent.incrementQuantity",
        query = "UPDATE PopularityEvent e SET e.quantity=e.quantity+1 WHERE e.id=:id"
    )
}
)
@Entity
@Table(name = "event_popularity")
public class PopularityEvent {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @OneToOne(mappedBy = "popularityEvent")
  private Event event;

  @Column(name = "quantity")
  @NotNull
  private Integer quantity = 0;

  public PopularityEvent(Event event,
      @NotNull Integer quantity) {
    this.event = event;
    this.quantity = quantity;
  }

  public PopularityEvent() {
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
