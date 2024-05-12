package cl.uchile.dcc.finalreality.gui.assets.units.states;

public class Standing extends AbstractAnimationState {
  @Override
  public void setX() {
    getSprite().setX(0);
  }
}
