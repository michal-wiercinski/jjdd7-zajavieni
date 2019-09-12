package com.isa.zajavieni.mapper;

import com.isa.zajavieni.entity.Attachment;
import com.isa.zajavieni.servlet.LoggerServlet;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class AttachmentListMapper {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  public List<Attachment> mapAttachmentApiToEntity(com.isa.zajavieni.jsonclasses.Event eventApi) {
    logger.info("Map attachmentApi to entity");
    List<Attachment> attachments = new ArrayList<>();
    eventApi.getAttachmentList().forEach(
        attachmentApi -> {
          Attachment attachment = new Attachment();
          attachment.setFileName(attachmentApi.getFileName());
          attachments.add(attachment);
        }
    );
    return attachments;
  }
}
