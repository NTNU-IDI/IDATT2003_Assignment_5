package edu.ntnu.idi.idatt.model;

import static edu.ntnu.idi.idatt.utility.Validation.ensureValidList;

import java.util.List;

/**
 * A list of cards.
 *
 * @param cards The cards in the hand
 */
public record Hand(List<Card> cards) {

  /**
   * Constructs a hand object.
   *
   * @param cards A list of cards that make up the hand
   */
  public Hand(List<Card> cards) {
    this.cards = ensureValidList(cards);
  }

}
