package edu.ntnu.idi.idatt.views;

import static edu.ntnu.idi.idatt.utility.Configuration.HAND_SIZE;
import static edu.ntnu.idi.idatt.utility.TextFormatter.formatCards;
import static edu.ntnu.idi.idatt.utility.TextFormatter.formatHand;
import static edu.ntnu.idi.idatt.utility.Validation.ensureNonNull;

import edu.ntnu.idi.idatt.controllers.HandController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ButtonsRegion extends StackPane {

  DisplayRegion displayRegion;
  InfoRegion infoRegion;
  HandController handController;

  public ButtonsRegion(DisplayRegion displayRegion, InfoRegion infoRegion,
      HandController handController) {
    this.displayRegion = (DisplayRegion) ensureNonNull(displayRegion,
        "displayRegion must not be null");
    this.infoRegion = (InfoRegion) ensureNonNull(infoRegion,
        "infoRegion must not be null");
    this.handController = (HandController) ensureNonNull(handController,
        "handController must not be null");

    this.setPrefSize(300, 600);
    this.setBorder(new Border(
        new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
            new BorderWidths(2))));

    Button dealHand = new Button("Deal Hand");
    Button checkHand = new Button("Check Hand");

    dealHand.setOnAction(e -> {
      dealHand();
    });
    checkHand.setOnAction(e -> {
      checkHand();
    });

    VBox vBox = new VBox(20);
    vBox.setAlignment(Pos.CENTER);
    vBox.getChildren().addAll(dealHand, checkHand);
    this.setAlignment(Pos.CENTER);
    this.getChildren().addAll(vBox);
  }

  private void dealHand() {
    handController.generateHand(HAND_SIZE);
    displayRegion.updateHand(formatHand(handController.getHand()));
  }

  private void checkHand() {
    infoRegion.updateHand(
        String.valueOf(handController.getValue()),
        formatCards(handController.getHearts()),
        handController.isFlush(),
        handController.hasQueenOfSpades());
  }
}