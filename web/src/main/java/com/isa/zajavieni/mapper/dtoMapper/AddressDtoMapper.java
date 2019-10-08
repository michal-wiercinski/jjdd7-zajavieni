package com.isa.zajavieni.mapper.dtoMapper;

import com.isa.zajavieni.dto.AddressDto;
import com.isa.zajavieni.entity.Address;
import com.isa.zajavieni.web.servlet.LoggerServlet;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class AddressDtoMapper {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  public AddressDto mapAddressToDto(Address address) {
    AddressDto addressDto = new AddressDto();
    if (address != null) {
      addressDto.setName(address.getName());
      addressDto.setStreet(address.getStreet());
      addressDto.setZipcode(address.getZipcode());
      addressDto.setCity(address.getCity());
      logger.info("Map address entity id: {} to dto", address.getId());
    }

    return addressDto;
  }
}
