package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public abstract class EffectTest<T extends Effect> {

  public Enemy enemy;
  public T effect;

  @BeforeEach
  void setUp() throws InvalidStatException {
    enemy = new Enemy("Enemy", 100, 5, 15, 120, new LinkedBlockingQueue<>());
    effect = setEffect();
  }

  protected abstract T setEffect() throws InvalidStatException;

  public T getEffect() {
    return effect;
  }

  public Enemy getEnemy() {
    return enemy;
  }
}