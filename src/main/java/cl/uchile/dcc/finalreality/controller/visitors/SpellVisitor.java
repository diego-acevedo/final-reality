package cl.uchile.dcc.finalreality.controller.visitors;

import cl.uchile.dcc.finalreality.model.spells.types.*;

public interface SpellVisitor<T> {

  T visitCure(Cure cure);
  T visitFire(Fire fire);
  T visitParalysis(Paralysis paralysis);
  T visitPoison(Poison poison);
  T visitThunder(Thunder thunder);
}
