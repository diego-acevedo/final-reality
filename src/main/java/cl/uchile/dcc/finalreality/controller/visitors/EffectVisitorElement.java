package cl.uchile.dcc.finalreality.controller.visitors;

public interface EffectVisitorElement {
  <T> T accept(EffectVisitor<T> visitor);
}
