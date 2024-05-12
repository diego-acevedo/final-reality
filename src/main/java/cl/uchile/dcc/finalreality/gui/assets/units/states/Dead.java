package cl.uchile.dcc.finalreality.gui.assets.units.states;

public class Dead extends AbstractAnimationState {
  @Override
  public void setX() {
    getSprite().setX(10);
  }
}
