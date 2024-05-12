package cl.uchile.dcc.finalreality.gui.assets.weapons;

import javafx.scene.image.ImageView;

public interface WeaponSprite {

  ImageView getImage();

  void setViewport(ImageView imageView);

  void setX(int x);
}
