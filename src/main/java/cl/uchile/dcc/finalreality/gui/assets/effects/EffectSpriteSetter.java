package cl.uchile.dcc.finalreality.gui.assets.effects;

import cl.uchile.dcc.finalreality.controller.visitors.EffectVisitor;
import cl.uchile.dcc.finalreality.model.effects.NullEffect;
import cl.uchile.dcc.finalreality.model.effects.types.Burning;
import cl.uchile.dcc.finalreality.model.effects.types.Paralyzed;
import cl.uchile.dcc.finalreality.model.effects.types.Poisoned;

public class EffectSpriteSetter implements EffectVisitor<EffectSprite> {
  @Override
  public EffectSprite visitBurning(Burning burning) {
    return new BurningSprite();
  }

  @Override
  public EffectSprite visitParalyzed(Paralyzed paralyzed) {
    return new ParalyzedSprite();
  }

  @Override
  public EffectSprite visitPoisoned(Poisoned poisoned) {
    return new PoisonedSprite();
  }

  @Override
  public EffectSprite visitNullEffect(NullEffect effect) {
    return new NullEffectSprite();
  }
}
