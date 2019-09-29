package com.isa.zajavieni.entity.statisticapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PopularityFavouriteEventResponse {
  @JsonProperty("favouriteEventName")
  private String favouriteEventName;

  @JsonProperty("quantity")
  private Integer quantity;

  public PopularityFavouriteEventResponse() {
  }

  public PopularityFavouriteEventResponse(String favouriteEventName, Integer quantity) {
    this.favouriteEventName = favouriteEventName;
    this.quantity = quantity;
  }

  public String getFavouriteEventName() {
    return favouriteEventName;
  }

  public void setFavouriteEventName(String favouriteEventName) {
    this.favouriteEventName = favouriteEventName;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
