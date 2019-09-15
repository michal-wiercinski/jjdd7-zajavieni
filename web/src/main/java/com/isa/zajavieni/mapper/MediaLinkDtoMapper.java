package com.isa.zajavieni.mapper;

import com.isa.zajavieni.dto.MediaLinkDto;
import com.isa.zajavieni.entity.MediaLink;

import javax.ejb.Stateless;

@Stateless
public class MediaLinkDtoMapper {

    public MediaLinkDto mapMediaLinkToDto(MediaLink mediaLink){
        MediaLinkDto mediaLinkDto = new MediaLinkDto();
        mediaLinkDto.setWwwAddress(mediaLink.getWwwAddress());
        mediaLinkDto.setFbSite(mediaLink.getFbSite());
        mediaLinkDto.setWebSiteWithTickets(mediaLink.getWebsiteWithTickets());

        return mediaLinkDto;
    }
}
