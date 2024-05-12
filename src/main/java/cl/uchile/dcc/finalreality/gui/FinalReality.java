package cl.uchile.dcc.finalreality.gui;

import cl.uchile.dcc.finalreality.controller.GameDriver;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FinalReality extends Application {

  public static Stage PRIMARY_STAGE;
  private static Scene startScene;
  private static Scene battleScene;
  public static BattleScreenController BATTLE_CONTROLLER;
  public static StartSceneController START_CONTROLLER;
  public static final MediaPlayer ENTER_SOUND = new MediaPlayer(
      new Media(BattleScreenController.class.getResource("sounds/ENTER.mp3").toExternalForm())
  );
  public static final MediaPlayer CURSOR_SOUND = new MediaPlayer(
      new Media(BattleScreenController.class.getResource("sounds/CURSOR.mp3").toExternalForm())
  );

  @Override
  public void start(Stage stage) throws Exception {
    PRIMARY_STAGE = stage;
    GameDriver driver = GameDriver.DRIVER();
    FXMLLoader startLoader = new FXMLLoader(FinalReality.class.getResource("start-screen.fxml"));
    startScene = new SceneCreator(startLoader, "css/start-screen.css");
    START_CONTROLLER = startLoader.getController();
    FXMLLoader battleLoader = new FXMLLoader(FinalReality.class.getResource("battle-screen.fxml"));
    battleScene = new SceneCreator(battleLoader, "css/battle-screen.css");
    BATTLE_CONTROLLER = battleLoader.getController();
    stage.setScene(startScene);
    START_CONTROLLER.startMusic();
    stage.show();
  }

  public static void changeToBattleScreen() {
    PRIMARY_STAGE.setScene(battleScene);
    BATTLE_CONTROLLER.startMusic();
    BATTLE_CONTROLLER.updateOptions();
  }

  public static void playSound(MediaPlayer sound) {
    sound.seek(Duration.ZERO);
    sound.play();
  }
}
