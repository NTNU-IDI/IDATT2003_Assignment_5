package edu.ntnu.idi.idatt.utility;

import java.util.List;

/**
 * A utility class for validating objects.
 */
public class Validation {

  /**
   * Ensures an object is not null.
   *
   * @param obj     The object to validate
   * @param message The message that gets logged if validation fails
   * @return The validated object
   * @throws IllegalArgumentException if validation fails
   */
  public static <T> Object ensureNonNull(T obj, String message) {
    if (message == null) {
      throw new IllegalArgumentException("Message must not be null");
    }
    if (obj == null) {
      throw new IllegalArgumentException(message);
    }
    return obj;
  }

  /**
   * Ensures a list is not null nor contains null elements.
   *
   * @param list The list to validate
   * @return The validated list
   * @throws IllegalArgumentException if validation fails
   */
  public static <T> List<T> ensureValidList(List<T> list) {
    ensureNonNull(list, "List must not be null");
    try {
      list.contains(null);
    } catch (NullPointerException e) {
      throw new IllegalArgumentException("List must not be empty");
    }
    return list;
  }

  /**
   * Ensures a number is non-negative.
   *
   * @param num The number to validate
   * @return The validated number
   * @throws IllegalArgumentException if validation fails
   */
  public static Number ensureNonNegative(Number num) {
    ensureNonNull(num, "Number must not be null");
    if (num.doubleValue() < 0) {
      throw new IllegalArgumentException("Number must not be negative");
    }
    return num;
  }
}
