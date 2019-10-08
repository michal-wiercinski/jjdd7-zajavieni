package com.isa.zajavieni.mapper.entityMapper;

import com.isa.zajavieni.entity.Address;
import com.isa.zajavieni.jsonclasses.Place;
import com.isa.zajavieni.web.servlet.LoggerServlet;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class AddressMapper {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  public Address mapAddressApiToEntity(Place addressApi) {
    logger.info("Map addressApi id: {} to entity", addressApi.getPlaceId());
    Address address = new Address();
    address.setId(addressApi.getPlaceId());
    address.setName(addressApi.getName());
    address.setStreet(addressApi.getAddress().getStreet());
    address.setZipcode(addressApi.getAddress().getZipcode());
    address.setCity(addressApi.getAddress().getCity());
    return address;
  }
}
