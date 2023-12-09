package cl.uchile.dcc.finalreality.model.units;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.types.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractUnitTest {

  public BlackMage blackMage;
  public Engineer engineer;
  public Knight knight;
  public Thief thief;
  public WhiteMage whiteMage;
  public Enemy enemy;
  public BlockingQueue<GameUnit> turnsQueue;

  @BeforeEach
  public void init() throws InvalidStatException {
    turnsQueue = new LinkedBlockingQueue<>();
    blackMage = new BlackMage("BlackMage", 100, 100, 100, turnsQueue);
    engineer = new Engineer("Engineer", 100, 100, turnsQueue);
    knight = new Knight("Knight", 100, 100, turnsQueue);
    thief = new Thief("Thief", 100, 100, turnsQueue);
    whiteMage = new WhiteMage("WhiteMage", 100, 100, 100, turnsQueue);
    enemy = new Enemy("Enemy", 100, 100, 100, turnsQueue);

    turnsQueue.addAll(List.of(blackMage, engineer, knight, thief, whiteMage, enemy));
  }

}