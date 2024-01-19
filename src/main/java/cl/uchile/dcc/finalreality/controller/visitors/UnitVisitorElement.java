package cl.uchile.dcc.finalreality.controller.visitors;

public interface UnitVisitorElement {

  <T> T accept(UnitVisitor<T> visitor);
}
