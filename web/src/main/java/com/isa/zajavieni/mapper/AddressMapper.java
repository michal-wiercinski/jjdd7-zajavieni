package com.isa.zajavieni.mapper;

import com.isa.zajavieni.Entity.Address;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class AddressMapper {
  public List<Address> mapAddressApiToEntity(List<com.isa.zajavieni.jsonclasses.Place> addressApiList) {
    List<Address> addresses = new ArrayList<>();

    addressApiList.forEach(addressesApi -> {
      Address address = new Address();
      address.setId(addressesApi.getPlaceId());
      address.setName(addressesApi.getName());
      address.setStreet(addressesApi.getAddress().getStreet());
      address.setZipcode(addressesApi.getAddress().getZipcode());
      address.setCity(addressesApi.getAddress().getCity());
      addresses.add(address);
    });
    return addresses;
  }
}
