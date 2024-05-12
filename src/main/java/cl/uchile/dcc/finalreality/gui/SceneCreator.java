package cl.uchile.dcc.finalreality.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class SceneCreator extends Scene {

  public SceneCreator(FXMLLoader loader, String stylesheet) throws Exception {
    super(loader.load(), 1024, 624);
    this.getStylesheets().add(getClass().getResource(stylesheet).toExternalForm());
    GameSceneController controller = loader.getController();
    controller.setUpKeys();
  }
}
