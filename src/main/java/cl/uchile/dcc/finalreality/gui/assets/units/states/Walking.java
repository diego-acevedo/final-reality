package cl.uchile.dcc.finalreality.gui.assets.units.states;

public class Walking extends AbstractAnimationState {

  @Override
  public void setX() {
    int[] xValues = {2, 0, 4, 0};
    long interval = 200;
    long currentTime = System.currentTimeMillis();
    int index = (int) ((currentTime / interval) % xValues.length);
    getSprite().setX(xValues[index]);
  }
}
