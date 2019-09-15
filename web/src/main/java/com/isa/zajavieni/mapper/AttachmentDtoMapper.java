package com.isa.zajavieni.mapper;

import com.isa.zajavieni.dto.AttachmentDto;
import com.isa.zajavieni.entity.Attachment;

import javax.ejb.Stateless;

@Stateless
public class AttachmentDtoMapper {

    public AttachmentDto mapAttachmentToDto(Attachment attachment) {
        AttachmentDto attachmentDto = new AttachmentDto();
        attachmentDto.setFileName(attachment.getFileName());

        return attachmentDto;
    }
}
