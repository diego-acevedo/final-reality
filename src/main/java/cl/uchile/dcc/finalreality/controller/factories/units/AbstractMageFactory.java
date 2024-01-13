package cl.uchile.dcc.finalreality.controller.factories.units;

import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;

public abstract class AbstractMageFactory<T extends MagicUser> extends UnitFactory<T> {

  protected int meanMp;
  protected int sdMp;

  protected AbstractMageFactory(int meanHp, int sdHp, int meanDefense, int sdDefense, int meanMp, int sdMp) {
    super(meanHp, sdHp, meanDefense, sdDefense);
    this.meanMp = meanMp;
    this.sdMp = sdMp;
  }
}
