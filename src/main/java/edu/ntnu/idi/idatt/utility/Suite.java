package edu.ntnu.idi.idatt.utility;

import java.util.Random;

/**
 * An enum to represent the suit of a standard playing card.
 */
public enum Suite {
  Clubs,
  Diamonds,
  Hearts,
  Spades;

  public static Suite getRandomSuite() {
    return values()[new Random().nextInt(values().length)];
  }
}
