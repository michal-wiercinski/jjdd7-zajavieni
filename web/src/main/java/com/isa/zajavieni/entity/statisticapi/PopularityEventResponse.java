package com.isa.zajavieni.entity.statisticapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PopularityEventResponse {
  @JsonProperty("eventName")
  private String eventName;

  @JsonProperty("quantity")
  private Integer quantity;

  public PopularityEventResponse() {
  }

  public PopularityEventResponse(String eventName, Integer quantity) {
    this.eventName = eventName;
    this.quantity = quantity;
  }

  public String getEventName() {
    return eventName;
  }

  public void setEventName(String eventName) {
    this.eventName = eventName;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
