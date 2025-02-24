package edu.ntnu.idi.idatt.views;

import static edu.ntnu.idi.idatt.utility.Validation.ensureNonNull;

import edu.ntnu.idi.idatt.model.Hand;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class DisplayRegion extends Region {

  Label handLabel;

  public DisplayRegion() {
    this.handLabel = new Label();
    this.handLabel.fontProperty().set(new Font("Arial", 25));

    this.setPrefSize(500, 400);
    this.setBorder(new Border(
        new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
            new BorderWidths(2))));

    this.getChildren().add(handLabel);
  }

  public void updateHand(String hand) {
    ensureNonNull(hand, "Hand must not be null");
    this.handLabel.setText(hand);
  }
}
