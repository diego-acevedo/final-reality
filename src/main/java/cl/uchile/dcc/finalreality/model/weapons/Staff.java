package cl.uchile.dcc.finalreality.model.weapons;

public class Staff extends AbstractWeapon {

  private final int magicDamage;
  public Staff(String name, int damage, int magicDamage, int weight) {
    super(name, damage, weight);
    this.magicDamage = magicDamage;
  }

  int getMagicDamage() {
    return magicDamage;
  }
}
