module cl.uchile.dcc.finalreality {
  requires javafx.controls;
  requires javafx.fxml;
  requires javafx.media;

  exports cl.uchile.dcc.finalreality.gui;
  opens cl.uchile.dcc.finalreality.gui to javafx.fxml, javafx.media, javafx.controls;
}