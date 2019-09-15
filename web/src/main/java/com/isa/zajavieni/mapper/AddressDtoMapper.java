package com.isa.zajavieni.mapper;

import com.isa.zajavieni.dto.AddressDto;
import com.isa.zajavieni.entity.Address;

import javax.ejb.Stateless;
import javax.transaction.Transactional;

@Stateless
public class AddressDtoMapper {

    public AddressDto mapAddressToDto(Address address){
        AddressDto addressDto = new AddressDto();
        addressDto.setName(address.getName());
        addressDto.setStreet(address.getStreet());
        addressDto.setZipcode(address.getZipcode());
        addressDto.setCity(address.getCity());

        return addressDto;
    }
}
