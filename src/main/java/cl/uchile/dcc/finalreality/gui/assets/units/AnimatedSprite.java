package cl.uchile.dcc.finalreality.gui.assets.units;

import cl.uchile.dcc.finalreality.gui.assets.units.states.AnimationState;

public interface AnimatedSprite {

  void setX(int x);

  void setState(AnimationState state);
}
