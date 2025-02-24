package edu.ntnu.idi.idatt;

import static edu.ntnu.idi.idatt.utility.Validation.ensureNonNull;

import edu.ntnu.idi.idatt.controllers.HandController;
import edu.ntnu.idi.idatt.model.Hand;
import edu.ntnu.idi.idatt.views.ButtonsRegion;
import edu.ntnu.idi.idatt.views.DisplayRegion;
import edu.ntnu.idi.idatt.views.InfoRegion;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * This class is responsible for the GUI.
 */
public class AppWindow {

  /**
   * This method is responsible for the GUI.
   *
   * @param primaryStage Arguments passed from the console
   */
  public AppWindow(Stage primaryStage) {
    try {
      ensureNonNull(primaryStage, "primaryStage must not be null");
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
    primaryStage.setTitle("Assignment 5");

    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(10, 10, 10, 10));

    HandController handController = new HandController(new Hand(new ArrayList<>()));

    DisplayRegion displayRegion = new DisplayRegion();
    InfoRegion infoRegion = new InfoRegion();
    ButtonsRegion buttonsRegion = new ButtonsRegion(displayRegion, infoRegion, handController);

    grid.add(displayRegion, 0, 0);
    grid.add(infoRegion, 0, 1, 2, 1);
    grid.add(buttonsRegion, 1, 0);

    Scene scene = new Scene(grid, 800, 600);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
