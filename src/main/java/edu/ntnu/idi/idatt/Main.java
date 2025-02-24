package edu.ntnu.idi.idatt;

import static edu.ntnu.idi.idatt.utility.Validation.ensureNonNull;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The main class of the application.
 */
public class Main extends Application {

  /**
   * This method initializes the GUI.
   *
   * @param primaryStage Arguments passed from the console
   */
  @Override
  public void start(Stage primaryStage) {
    ensureNonNull(primaryStage, "primaryStage must not be null");
    new AppWindow(primaryStage);
  }

  /**
   * Insertion point of the application.
   *
   * @param args Arguments passed from the console
   */
  public static void main(String[] args) {
    launch(args);
  }
}