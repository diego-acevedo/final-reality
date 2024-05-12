package cl.uchile.dcc.finalreality.gui.assets.units;

import cl.uchile.dcc.finalreality.controller.visitors.UnitVisitor;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.types.*;

import java.util.Random;

public class UnitSpriteSetter implements UnitVisitor<UnitSprite> {

  @Override
  public UnitSprite visitEnemy(Enemy enemy) {
    int[][] values = {
        {4, 5},
        {0, 0},
        {14, 6}
    };
    int[] result = values[(new Random()).nextInt(values.length)];
    return new EnemySprite(enemy, result[0], result[1]);
  }

  @Override
  public UnitSprite visitBlackMage(BlackMage blackMage) {
    return new BlackMageSprite(blackMage);
  }

  @Override
  public UnitSprite visitEngineer(Engineer engineer) {
    return new EngineerSprite(engineer);
  }

  @Override
  public UnitSprite visitKnight(Knight knight) {
    return new KnightSprite(knight);
  }

  @Override
  public UnitSprite visitThief(Thief thief) {
    return new ThiefSprite(thief);
  }

  @Override
  public UnitSprite visitWhiteMage(WhiteMage whiteMage) {
    return new WhiteMageSprite(whiteMage);
  }
}
