package com.isa.zajavieni.mapper;

import com.isa.zajavieni.dto.AddressDto;
import com.isa.zajavieni.entity.Address;

import javax.ejb.Stateless;

@Stateless
public class AddressDtoMapper {

    public AddressDto mapAddressToDto(Address address) {
        AddressDto addressDto = new AddressDto();
        String noData = "Brak danych";

        if (address.getName() == null) {
            addressDto.setName(noData);
        } else {
            addressDto.setName(address.getName());
        }

        if (address.getStreet() == null) {
            addressDto.setName(noData);
        } else {
            addressDto.setStreet(address.getStreet());
        }

        if (address.getZipcode() == null) {
            addressDto.setZipcode(noData);
        } else {
            addressDto.setName(address.getZipcode());
        }

        if (address.getCity() == null) {
            addressDto.setCity(noData);
        } else {
            addressDto.setName(address.getCity());
        }

        return addressDto;
    }
}
