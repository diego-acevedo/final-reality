module cl.uchile.dcc.finalreality {
  requires javafx.controls;
  requires javafx.fxml;


  opens cl.uchile.dcc.finalreality to javafx.fxml;
  exports cl.uchile.dcc.finalreality;
}