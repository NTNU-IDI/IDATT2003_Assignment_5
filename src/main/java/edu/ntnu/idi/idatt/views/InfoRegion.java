package edu.ntnu.idi.idatt.views;

import static edu.ntnu.idi.idatt.utility.Validation.ensureNonNull;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

public class InfoRegion extends Region {

  Label sumLabel;
  Label heartsLabel;
  Label flushLabel;
  Label queenLabel;

  public InfoRegion() {
    this.sumLabel = new Label();
    this.heartsLabel = new Label();
    this.flushLabel = new Label();
    this.queenLabel = new Label();

    this.setPrefSize(500, 200);
    this.setBorder(new Border(
        new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
            new BorderWidths(2))));

    HBox hBox = new HBox();
    hBox.setSpacing(30);
    hBox.setPadding(new Insets(10, 10, 10, 10));

    hBox.getChildren().addAll(sumLabel, heartsLabel, flushLabel, queenLabel);
    this.getChildren().add(hBox);
  }

  public void updateHand(String sum, String hearts, boolean flush, boolean queen) {
    ensureNonNull(sum, "Sum must not be null");
    ensureNonNull(hearts, "Hearts must not be null");
    
    this.sumLabel.setText("Sum of faces: " + sum);
    this.heartsLabel.setText("Cards of hearts: " + hearts);
    this.flushLabel.setText("Flush: " + (flush ? "Yes" : "No"));
    this.queenLabel.setText("Queen: " + (queen ? "Yes" : "No"));
  }
}