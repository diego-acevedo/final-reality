package cl.uchile.dcc.finalreality.gui.assets.units;

import cl.uchile.dcc.finalreality.gui.BattleScreenController;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

public class EnemySprite implements UnitSprite {

  private final ImageView sprite = new ImageView(BattleScreenController.ENEMY_SPRITE);
  private final int width = 56 * BattleScreenController.EXPAND_RATIO;
  private final int height = 64 * BattleScreenController.EXPAND_RATIO;
  private int x;
  private final int y;
  private final Enemy unit;

  public EnemySprite(Enemy unit, int x, int y) {
    this.x = x * width;
    this.y = y * height;
    this.unit = unit;
  }

  @Override
  public ImageView getImage() {
    setViewport(sprite);
    return sprite;
  }

  @Override
  public void setViewport(ImageView imageView) {
    if (unit.isDead()) {
      imageView.setOpacity(0);
    }
    Rectangle2D rectangle = new Rectangle2D(x, y, width, height);
    imageView.setViewport(rectangle);
  }
}
