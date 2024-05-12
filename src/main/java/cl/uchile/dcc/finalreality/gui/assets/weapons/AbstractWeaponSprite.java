package cl.uchile.dcc.finalreality.gui.assets.weapons;

import cl.uchile.dcc.finalreality.gui.BattleScreenController;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

public abstract class AbstractWeaponSprite implements WeaponSprite {

  private final ImageView sprite = new ImageView(BattleScreenController.WEAPON_SPRITE);
  private final int width = 56 * BattleScreenController.EXPAND_RATIO;
  private final int height = 50 * BattleScreenController.EXPAND_RATIO;
  private int x;
  private final int xOffset;
  private final int y;
  private int cnt;

  protected AbstractWeaponSprite(int y, int xOffset) {
    this.x = 0;
    this.y = y * height;
    this.xOffset = xOffset * width * 5;
    this.cnt = -1;
  }
  @Override
  public ImageView getImage() {
    setViewport(sprite);
    return sprite;
  }

  @Override
  public void setViewport(ImageView imageView) {
    setX();
    Rectangle2D rectangle = new Rectangle2D(x + xOffset, y, width, height);
    imageView.setViewport(rectangle);
  }

  @Override
  public void setX(int x) {
    this.x = x * width;
  }

  private void setX() {
    cnt = Math.min(cnt + 1, 4);
    setX(cnt);
  }
}
