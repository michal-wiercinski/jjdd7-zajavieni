package com.isa.zajavieni.service;

import com.isa.zajavieni.cdi.FileReadProcessor;
import java.io.IOException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;

@ApplicationScoped
public class PartService {

  @Inject
  private FileReadProcessor fileUploadProcessor;

  @Inject
  private JsonProcessor jsonProcessor;

  public void servicedEventPart(Part partEventFile) throws IOException {
    String uploadEventFile = fileUploadProcessor.uploadJsonFile(partEventFile);
    jsonProcessor.processEventsJson(uploadEventFile);
  }

  public void servicedPlacePart(Part partPlaceFile) throws IOException {
    String uploadPlaceFile = fileUploadProcessor.uploadJsonFile(partPlaceFile);
    jsonProcessor.processPlaceFile(uploadPlaceFile);
  }

  public void servicedOrganizerPart(Part partOrganierFile) throws IOException {
    String uploadPlaceFile = fileUploadProcessor.uploadJsonFile(partOrganierFile);
    jsonProcessor.processPlaceFile(uploadPlaceFile);
  }
}
