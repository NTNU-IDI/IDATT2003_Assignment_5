package edu.ntnu.idi.idatt.model;

import edu.ntnu.idi.idatt.utility.Suite;

/**
 * A playing card.
 *
 * @param suite The suite of the playing card
 * @param value The value of the playing card (ace = 1)
 */
public record Card(Suite suite, int value) {

}
