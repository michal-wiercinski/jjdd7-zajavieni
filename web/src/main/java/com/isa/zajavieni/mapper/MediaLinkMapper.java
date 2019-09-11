package com.isa.zajavieni.mapper;

import com.isa.zajavieni.entity.MediaLink;
import javax.ejb.Stateless;

@Stateless
public class MediaLinkMapper {

  public MediaLink mapMediaLinkApiToEntity (com.isa.zajavieni.jsonclasses.Event eventApi){
    MediaLink mediaLink = new MediaLink();
    mediaLink.setFbSite(eventApi.getMediaLink().getFbSite());
    mediaLink.setWwwAddress(eventApi.getMediaLink().getWwwAddress());
    mediaLink.setWebsiteWithTickets(eventApi.getMediaLink().getWebsiteWithTickets());
    return mediaLink;
  }
}
