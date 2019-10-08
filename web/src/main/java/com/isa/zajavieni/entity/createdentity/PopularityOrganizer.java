package com.isa.zajavieni.entity.createdentity;

import com.isa.zajavieni.entity.fromapi.Organizer;
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
        name = "PopularityOrganizer.findAll",
        query = "SELECT o FROM PopularityOrganizer o ORDER BY o.quantity DESC"
    ),
    @NamedQuery(
        name = "PopularityOrganizer.incrementQuantity",
        query = "UPDATE PopularityOrganizer o SET o.quantity=o.quantity+1 WHERE o.id=:id"
    )
}
)
@Entity
@Table(name = "organizer_popularity")
public class PopularityOrganizer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @OneToOne(mappedBy = "popularityOrganizer")
  private Organizer organizer;

  @Column(name = "quantity")
  @NotNull
  private Integer quantity = 0;

  public PopularityOrganizer(Organizer organizer,
      @NotNull Integer quantity) {
    this.organizer = organizer;
    this.quantity = quantity;
  }

  public PopularityOrganizer() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Organizer getOrganizer() {
    return organizer;
  }

  public void setOrganizer(Organizer organizer) {
    this.organizer = organizer;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
