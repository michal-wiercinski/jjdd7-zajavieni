package com.isa.zajavieni.cdi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.enterprise.context.ApplicationScoped;
import javax.servlet.http.Part;

@ApplicationScoped
public class FileReadProcessor {

  public String uploadJsonFile(Part filePart) throws IOException {
    InputStream fileInputStream = filePart.getInputStream();
    StringBuilder fileContent = new StringBuilder();
    try (
        Reader reader = new BufferedReader(
            new InputStreamReader(fileInputStream, Charset.forName(StandardCharsets.UTF_8.name()))
        )
    ) {
      int c = 0;
      while ((c = reader.read()) != -1) {
        fileContent.append((char) c);
      }
    }
    return fileContent.toString();
  }
}
