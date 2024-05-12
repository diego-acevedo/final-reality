package cl.uchile.dcc.finalreality.gui.assets.effects;

import cl.uchile.dcc.finalreality.gui.BattleScreenController;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

public abstract class AbstractEffectSprite implements EffectSprite {

  private final ImageView sprite = new ImageView(BattleScreenController.EFFECT_SPRITE);
  private final int width = 16 * BattleScreenController.EXPAND_RATIO;
  private final int height = 8 * BattleScreenController.EXPAND_RATIO;
  private int x;
  private final int y;

  protected AbstractEffectSprite(int x, int y) {
    this.x = x * width;
    this.y = y * height;
  }

  @Override
  public ImageView getImage() {
    return sprite;
  }

  @Override
  public void setViewport(ImageView imageView) {
    long interval = 400;
    long currentTime = System.currentTimeMillis();
    int index = (int) ((currentTime / interval) % 2);
    this.x = index * width;
    Rectangle2D rectangle = new Rectangle2D(x, y, width, height);
    imageView.setViewport(rectangle);
  }
}
