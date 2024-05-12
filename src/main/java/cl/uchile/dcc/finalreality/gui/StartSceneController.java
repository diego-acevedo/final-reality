package cl.uchile.dcc.finalreality.gui;

import cl.uchile.dcc.finalreality.controller.GameDriver;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class StartSceneController implements GameSceneController {

  @FXML
  public VBox title;
  @FXML
  private Label startTitle;

  public final MediaPlayer backgroundMusic = new MediaPlayer(
      new Media(BattleScreenController.class.getResource("sounds/menu.wav").toExternalForm())
  );

  private final int[][] colorValues = {
      {129, 226, 255},
      {179, 129, 255},
      {255, 129, 129},
      {255, 236, 129},
      {129, 255, 131}
  };

  public void initialize() {
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(15), event -> startTitle.setTextFill(getColor())));
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();
  }

  public void startMusic() {
    backgroundMusic.setOnEndOfMedia(() -> backgroundMusic.seek(Duration.ZERO));
    backgroundMusic.play();
  }

  public void stopMusic() {
    backgroundMusic.stop();
  }

  public void setUpKeys() {
    Scene scene = title.getScene();
    scene.setOnKeyPressed(keyEvent -> {
      switch (keyEvent.getCode()) {
        case ENTER -> {
          stopMusic();
          FinalReality.playSound(FinalReality.ENTER_SOUND);
          FadeTransition fade = new FadeTransition(Duration.millis(1000), title);
          fade.setFromValue(1);
          fade.setToValue(0);
          PauseTransition pause = new PauseTransition(Duration.millis(500));
          SequentialTransition transition = new SequentialTransition(
              fade,
              pause
          );
          transition.setOnFinished(actionEvent -> {
            GameDriver.DRIVER().execute();
            FinalReality.BATTLE_CONTROLLER.updateUnitDetails();
          });

          transition.play();
        }
        default -> {}
      }
    });
  }

  private Color getColor() {
    double currentTime = (double) System.currentTimeMillis() / 1000;
    int secondsPerColor = 5;
    int index = ((int) Math.floor(currentTime / secondsPerColor)) % colorValues.length;
    double delta = ((currentTime / secondsPerColor) % colorValues.length) - index;

    int[] v1 = colorValues[index];
    int[] v2 = colorValues[(index + 1) % 5];

    int newR = v1[0] + (int) ((v2[0] - v1[0]) * delta);
    int newG = v1[1] + (int) ((v2[1] - v1[1]) * delta);
    int newB = v1[2] + (int) ((v2[2] - v1[2]) * delta);

    return Color.rgb(newR, newG, newB);
  }
}
