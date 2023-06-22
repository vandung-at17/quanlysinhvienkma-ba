package com.example.quanlykma.model.request;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

public class MultipartFormDataRequest {
  private Map<String, String> textFields;
  private Map<String, MultipartFile> files;

  public MultipartFormDataRequest() {
    textFields = new HashMap<>();
    files = new HashMap<>();
  }

  public String getString(String fieldName) {
    return textFields.get(fieldName);
  }

  public void setString(String fieldName, String value) {
    textFields.put(fieldName, value);
  }

  public MultipartFile getFile(String fieldName) {
    return files.get(fieldName);
  }

  public void setFile(String fieldName, MultipartFile file) {
    files.put(fieldName, file);
  }
}
