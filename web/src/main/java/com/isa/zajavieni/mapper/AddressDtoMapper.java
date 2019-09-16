package com.isa.zajavieni.mapper;

import com.isa.zajavieni.dto.AddressDto;
import com.isa.zajavieni.entity.Address;

import javax.ejb.Stateless;
import java.util.Optional;
import java.util.stream.Stream;

@Stateless
public class AddressDtoMapper {
   private final String noData = "Brak danych";
    public AddressDto mapAddressToDto(Address address) {
        AddressDto addressDto = new AddressDto();
        if(address != null) {
            addressDto.setName(address.getName());
            addressDto.setStreet(address.getStreet());
            addressDto.setZipcode(address.getZipcode());
            addressDto.setCity(address.getCity());
        }
        return addressDto;
    }


}
