package cl.uchile.dcc.finalreality.gui.assets.weapons;

import cl.uchile.dcc.finalreality.controller.visitors.WeaponVisitor;
import cl.uchile.dcc.finalreality.model.weapons.NullWeapon;
import cl.uchile.dcc.finalreality.model.weapons.types.*;
import javafx.scene.image.ImageView;

public class WeaponSpriteSetter implements WeaponVisitor<WeaponSprite> {
  @Override
  public WeaponSprite visitAxe(Axe axe) {
    return new AxeSprite();
  }

  @Override
  public WeaponSprite visitBow(Bow bow) {
    return new BowSprite();
  }

  @Override
  public WeaponSprite visitKnife(Knife knife) {
    return new KnifeSprite();
  }

  @Override
  public WeaponSprite visitStaff(Staff staff) {
    return new StaffSprite();
  }

  @Override
  public WeaponSprite visitSword(Sword sword) {
    return new SwordSprite();
  }

  @Override
  public WeaponSprite visitNullWeapon(NullWeapon weapon) {
    return new NullWeaponSprite();
  }
}
