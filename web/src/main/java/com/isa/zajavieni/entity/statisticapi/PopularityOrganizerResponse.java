package com.isa.zajavieni.entity.statisticapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PopularityOrganizerResponse {
  @JsonProperty("organizerName")
  private String organizerName;

  @JsonProperty("quantity")
  private Integer quantity;

  public PopularityOrganizerResponse() {
  }

  public PopularityOrganizerResponse(String organizerName, Integer quantity) {
    this.organizerName = organizerName;
    this.quantity = quantity;
  }

  public String getOrganizerName() {
    return organizerName;
  }

  public void setOrganizerName(String organizerName) {
    this.organizerName = organizerName;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
