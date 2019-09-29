package com.isa.zajavieni.mapper.dtoMapper;

import com.isa.zajavieni.dto.AttachmentDto;
import com.isa.zajavieni.entity.Attachment;
import javax.ejb.Stateless;

@Stateless
public class AttachmentDtoMapper {

  public AttachmentDto mapAttachmentToDto(Attachment attachment) {
    AttachmentDto attachmentDto = new AttachmentDto();

    if (attachment.getFileName() == null || attachment.getFileName().isEmpty()) {
      attachmentDto.setFileName("/img/plug");
    } else {
      attachmentDto.setFileName(attachment.getFileName());
    }
    return attachmentDto;
  }
}
