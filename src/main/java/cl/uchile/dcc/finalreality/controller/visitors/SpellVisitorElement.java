package cl.uchile.dcc.finalreality.controller.visitors;

public interface SpellVisitorElement {
  <T> T accept(SpellVisitor<T> visitor);
}
