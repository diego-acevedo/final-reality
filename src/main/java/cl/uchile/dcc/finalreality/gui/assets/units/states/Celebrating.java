package cl.uchile.dcc.finalreality.gui.assets.units.states;

public class Celebrating extends AbstractAnimationState {

  @Override
  public void setX() {
    int[] xValues = {0, 7};
    long interval = 400;
    long currentTime = System.currentTimeMillis();
    int index = (int) ((currentTime / interval) % xValues.length);
    getSprite().setX(xValues[index]);
  }
}
