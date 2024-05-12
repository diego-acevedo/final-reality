package cl.uchile.dcc.finalreality.gui.assets.weapons;

import javafx.scene.image.ImageView;

public class NullWeaponSprite implements WeaponSprite {
  @Override
  public ImageView getImage() {
    return new ImageView();
  }

  @Override
  public void setViewport(ImageView imageView) {

  }

  @Override
  public void setX(int x) {

  }
}
