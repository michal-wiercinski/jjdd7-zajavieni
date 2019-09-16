package com.isa.zajavieni.mapper;

import com.isa.zajavieni.dto.AddressDto;
import com.isa.zajavieni.entity.Address;

import javax.ejb.Stateless;
import java.util.Optional;

@Stateless
public class AddressDtoMapper {

    public AddressDto mapAddressToDto(Address address) {
        AddressDto addressDto = new AddressDto();
        String noData = "Brak danych";

        if (Optional.ofNullable(address.getName()).isPresent()) {
            addressDto.setName(noData);
        } else {
            addressDto.setName(address.getName());
        }

        if (Optional.ofNullable(address.getStreet()).isPresent()) {
            addressDto.setStreet(noData);
        } else {
            addressDto.setStreet(address.getStreet());
        }

        if (Optional.ofNullable(address.getZipcode()).isPresent()) {
            addressDto.setZipcode(noData);
        } else {
            addressDto.setZipcode(address.getZipcode());
        }

        if (Optional.ofNullable(address.getCity()).isPresent()) {
            addressDto.setCity(noData);
        } else {
            addressDto.setCity(address.getCity());
        }

        return addressDto;
    }
}
