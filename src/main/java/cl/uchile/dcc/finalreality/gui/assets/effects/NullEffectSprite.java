package cl.uchile.dcc.finalreality.gui.assets.effects;

import javafx.scene.image.ImageView;

public class NullEffectSprite implements EffectSprite {

  @Override
  public ImageView getImage() {
    return new ImageView();
  }

  @Override
  public void setViewport(ImageView imageView) {

  }
}
