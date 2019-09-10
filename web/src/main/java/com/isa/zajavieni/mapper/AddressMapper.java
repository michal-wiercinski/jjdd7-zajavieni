package com.isa.zajavieni.mapper;

import com.isa.zajavieni.Entity.Address;
import com.isa.zajavieni.jsonclasses.Place;
import javax.ejb.Stateless;

@Stateless
public class AddressMapper {

  public Address mapAddressApiToEntity(Place addressApi) {

    Address address = new Address();
    address.setId(addressApi.getPlaceId());
    address.setName(addressApi.getName());
    address.setStreet(addressApi.getAddress().getStreet());
    address.setZipcode(addressApi.getAddress().getZipcode());
    address.setCity(addressApi.getAddress().getCity());

    return address;
  }
}
