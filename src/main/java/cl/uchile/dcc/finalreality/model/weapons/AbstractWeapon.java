package cl.uchile.dcc.finalreality.model.weapons;

public abstract class AbstractWeapon implements Weapon {
  private final String name;
  private final int damage;
  private final int weight;

  protected AbstractWeapon(String name, int damage, int weight) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
  }

  @Override
  public String getWeaponName() {
    return name;
  }

  @Override
  public int getDamage() {
    return damage;
  }

  @Override
  public int getWeight() {
    return weight;
  }
}
