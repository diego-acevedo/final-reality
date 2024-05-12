package cl.uchile.dcc.finalreality.controller.visitors;

import cl.uchile.dcc.finalreality.model.effects.NullEffect;
import cl.uchile.dcc.finalreality.model.effects.types.Burning;
import cl.uchile.dcc.finalreality.model.effects.types.Paralyzed;
import cl.uchile.dcc.finalreality.model.effects.types.Poisoned;

public interface EffectVisitor<T> {
  T visitBurning(Burning burning);
  T visitParalyzed(Paralyzed paralyzed);
  T visitPoisoned(Poisoned poisoned);
  T visitNullEffect(NullEffect effect);
}
