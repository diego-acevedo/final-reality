package cl.uchile.dcc.finalreality.gui.assets.units.states;

import cl.uchile.dcc.finalreality.gui.assets.units.AnimatedSprite;
import cl.uchile.dcc.finalreality.gui.assets.units.UnitSprite;

public abstract class AbstractAnimationState implements AnimationState {

  protected AnimatedSprite sprite;

  public void setSprite(AnimatedSprite sprite) {
    this.sprite = sprite;
  }

  @Override
  public AnimatedSprite getSprite() {
    return sprite;
  }
}
