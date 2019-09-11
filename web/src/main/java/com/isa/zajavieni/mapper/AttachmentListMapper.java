package com.isa.zajavieni.mapper;

import com.isa.zajavieni.entity.Attachment;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class AttachmentListMapper {

  public List<Attachment> mapAttachmentApiToEntity(com.isa.zajavieni.jsonclasses.Event eventApi){
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
