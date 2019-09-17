package com.isa.zajavieni.mapper;

import com.isa.zajavieni.dto.AddressDto;
import com.isa.zajavieni.entity.Address;
import com.isa.zajavieni.servlet.LoggerServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import java.util.Optional;
import java.util.stream.Stream;

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
