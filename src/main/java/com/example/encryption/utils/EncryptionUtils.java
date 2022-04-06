package com.example.encryption.utils;


import java.lang.reflect.Field;
import org.springframework.core.annotation.AnnotationUtils;

public class EncryptionUtils {
  public static boolean isFieldEncrypted(Field field) {
    return AnnotationUtils.findAnnotation(field, Encrypted.class) != null;
  }

  public static int getPropertyIndex(String name, String[] properties) {
    for (int i = 0; i < properties.length; i++) {
      if (name.equals(properties[i])) {
        return i;
      }
    }
    throw new IllegalArgumentException("No property was found for name " + name);
  }
}
