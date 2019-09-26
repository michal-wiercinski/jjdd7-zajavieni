package com.isa.zajavieni.mapper;

import com.isa.zajavieni.dto.MediaLinkDto;
import com.isa.zajavieni.entity.MediaLink;
import javax.ejb.Stateless;

@Stateless
public class MediaLinkDtoMapper {

  public MediaLinkDto mapMediaLinkToDto(MediaLink mediaLink) {
    MediaLinkDto mediaLinkDto = new MediaLinkDto();
    String noData = "brak danych";

    if (mediaLink.getWwwAddress() == null) {
      mediaLinkDto.setWwwAddress(noData);
    } else {
      mediaLinkDto.setWwwAddress(mediaLink.getWwwAddress());
    }

    if (mediaLink.getFbSite() == null) {
      mediaLinkDto.setFbSite(noData);
    } else {
      mediaLinkDto.setFbSite(mediaLink.getFbSite());
    }

    if (mediaLink.getWebsiteWithTickets() == null) {
      mediaLinkDto.setWebSiteWithTickets(noData);
    } else {
      mediaLinkDto.setWebSiteWithTickets(mediaLink.getWebsiteWithTickets());
    }

    return mediaLinkDto;
  }
}
