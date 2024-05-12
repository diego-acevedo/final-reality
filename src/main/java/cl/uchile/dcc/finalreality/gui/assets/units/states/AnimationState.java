package cl.uchile.dcc.finalreality.gui.assets.units.states;

import cl.uchile.dcc.finalreality.gui.assets.units.AnimatedSprite;
import cl.uchile.dcc.finalreality.gui.assets.units.UnitSprite;
import javafx.scene.image.ImageView;

public interface AnimationState {
  void setX();
  void setSprite(AnimatedSprite sprite);
  AnimatedSprite getSprite();
}
