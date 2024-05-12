package cl.uchile.dcc.finalreality.controller.visitors;

public interface WeaponVisitorElement {

  <T> T accept(WeaponVisitor<T> visitor);
}
