package edu.ntnu.idi.idatt.utility;

import static edu.ntnu.idi.idatt.utility.Validation.ensureValidList;
import static edu.ntnu.idi.idatt.utility.Validation.ensureNonNull;

import edu.ntnu.idi.idatt.model.Card;
import edu.ntnu.idi.idatt.model.Hand;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A utility class for formatting text for displaying purposes.
 */
public class TextFormatter {

  /**
   * Formats a playing card to a readable string.
   *
   * @param card The card to format
   * @return A readable string representing the card (or "" if the card is null)
   */
  public static String formatCard(Card card) {
    try {
      ensureNonNull(card, "Card must not be null");
      return card.suite().toString().substring(0, 1) + card.value();
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
    return "";
  }

  /**
   * Formats a list of card to a readable string.
   *
   * @param cards The cards to format
   * @return A readable string representing the list of cards (or "" if the list of cards is null or
   *     empty);
   */
  public static String formatCards(List<Card> cards) {
    try {
      ensureValidList(cards);
      return cards.stream().map(TextFormatter::formatCard).collect(Collectors.joining(", "));
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
    return "";
  }

  /**
   * Formats a hand to a readable string.
   *
   * @param hand The hand to format
   * @return A readable string representing the hand (or "" if the hand is null)
   */
  public static String formatHand(Hand hand) {
    try {
      ensureNonNull(hand, "Hand must not be null");
      return formatCards(hand.cards());
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
    return "";
  }


}
