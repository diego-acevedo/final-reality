package cl.uchile.dcc.finalreality.gui.assets.units;

import cl.uchile.dcc.finalreality.gui.assets.units.states.AnimationState;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public interface UnitSprite {
  ImageView getImage();

  void setViewport(ImageView imageView);
}
