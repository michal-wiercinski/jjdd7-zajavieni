package com.isa.zajavieni.mapper;

import com.isa.zajavieni.entity.MediaLink;
import com.isa.zajavieni.servlet.LoggerServlet;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class MediaLinkMapper {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  public MediaLink mapMediaLinkApiToEntity(com.isa.zajavieni.jsonclasses.Event eventApi) {
    logger.info("Map mediaLinkApi to entity");
    MediaLink mediaLink = new MediaLink();
    mediaLink.setFbSite(eventApi.getMediaLink().getFbSite());
    mediaLink.setWwwAddress(eventApi.getMediaLink().getWwwAddress());
    mediaLink.setWebsiteWithTickets(eventApi.getMediaLink().getWebsiteWithTickets());
    return mediaLink;
  }
}
