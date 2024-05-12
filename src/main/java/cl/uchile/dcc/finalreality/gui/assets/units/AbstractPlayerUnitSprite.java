package cl.uchile.dcc.finalreality.gui.assets.units;

import cl.uchile.dcc.finalreality.controller.GameDriver;
import cl.uchile.dcc.finalreality.gui.BattleScreenController;
import cl.uchile.dcc.finalreality.gui.assets.units.states.*;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

public abstract class AbstractPlayerUnitSprite implements UnitSprite, AnimatedSprite {

  private final ImageView sprite = new ImageView(BattleScreenController.PLAYER_SPRITE);
  private final int width = 24 * BattleScreenController.EXPAND_RATIO;
  private final int height = 24 * BattleScreenController.EXPAND_RATIO;
  private int x;
  private final int y;
  private AnimationState state;
  private final PlayerUnit unit;

  protected AbstractPlayerUnitSprite(PlayerUnit unit, int y) {
    this.x = width;
    this.y = y * height;
    this.unit = unit;
    setState(new Standing());
  }

  @Override
  public ImageView getImage() {
    setViewport(sprite);
    return sprite;
  }

  @Override
  public void setViewport(ImageView imageView) {
    state.setX();
    Rectangle2D rectangle = new Rectangle2D(x, y, width, height);
    imageView.setViewport(rectangle);
  }

  @Override
  public void setX(int x) {
    this.x = x * width;
  }

  @Override
  public void setState(AnimationState state) {
    if (unit.isDead()) state = new Dead();
    else if (GameDriver.DRIVER().isGameOver()) state = new Celebrating();
    this.state = state;
    state.setSprite(this);
  }
}
