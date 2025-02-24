package edu.ntnu.idi.idatt.controllers;

import static edu.ntnu.idi.idatt.utility.Suite.Hearts;
import static edu.ntnu.idi.idatt.utility.Suite.Spades;
import static edu.ntnu.idi.idatt.utility.Suite.getRandomSuite;
import static edu.ntnu.idi.idatt.utility.Validation.ensureNonNegative;

import edu.ntnu.idi.idatt.model.Card;
import edu.ntnu.idi.idatt.model.Hand;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class HandController {

  Hand hand;

  public HandController(Hand hand) {

    this.hand = hand;
  }

  public Hand getHand() {
    return hand;
  }

  public List<Card> getCards() {
    return hand.cards();
  }

  public void generateHand(int handSize) {
    ensureNonNegative(handSize);
    List<Card> cards = new ArrayList<>(handSize);
    for (int i = 0; i < handSize; i++) {
      cards.add(new Card(getRandomSuite(), new Random().nextInt(1, 14)));
    }
    hand = new Hand(cards);
  }

  public int getValue() {
    return getCards().stream().mapToInt(Card::value).sum();
  }

  public List<Card> getHearts() {
    return getCards().stream().filter(card -> card.suite().equals(Hearts)).toList();
  }

  public boolean isFlush() {
    int highestSuiteOccurrence = getCards().stream()
        .collect(Collectors.groupingBy(Card::suite))
        .values()
        .stream()
        .mapToInt(List::size)
        .max().orElse(0);

    return highestSuiteOccurrence >= 5;
  }

  public boolean hasQueenOfSpades() {
    return getCards().contains(new Card(Spades, 12));
  }
}
