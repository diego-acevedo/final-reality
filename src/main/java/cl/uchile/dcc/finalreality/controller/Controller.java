package cl.uchile.dcc.finalreality.controller;

import cl.uchile.dcc.finalreality.controller.factories.units.PlayerUnitFactory;
import cl.uchile.dcc.finalreality.controller.factories.units.types.*;
import cl.uchile.dcc.finalreality.controller.factories.weapons.WeaponFactory;
import cl.uchile.dcc.finalreality.controller.factories.weapons.types.*;
import cl.uchile.dcc.finalreality.controller.states.PreGame;
import cl.uchile.dcc.finalreality.controller.states.State;
import cl.uchile.dcc.finalreality.exceptions.*;
import cl.uchile.dcc.finalreality.model.player.Player;
import cl.uchile.dcc.finalreality.model.spells.Spell;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * This class manages the flow and logic of the game.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class Controller {

  private final Player player = new Player();
  private final ArrayList<Enemy> enemies = new ArrayList<>();
  private final BlockingQueue<GameUnit> unitsQueue = new LinkedBlockingQueue<>();
  private State state;
  private int cursor = 0;
  private boolean gameOver = false;
  private GameUnit currentUnit;
  public static int UNITS_AMOUNT = 5;
  public static int ENEMIES_AMOUNT = 3;
  public String actionOutput = "";

  public void init() throws InvalidStatException {
    setState(new PreGame());
    Random random = new Random();
    PlayerUnitFactory[] playerUnitFactories = {
        new BlackMageFactory(unitsQueue),
        new EngineerFactory(unitsQueue),
        new KnightFactory(unitsQueue),
        new ThiefFactory(unitsQueue),
        new WhiteMageFactory(unitsQueue)
    };
    for (int i = 0; i < UNITS_AMOUNT; i++) {
      PlayerUnit unit = playerUnitFactories[random.nextInt(0, playerUnitFactories.length)].create();
      player.addUnit(unit);
      unitsQueue.add(unit);
    }
    WeaponFactory[] weaponFactories = {
        new AxeFactory(),
        new BowFactory(),
        new KnifeFactory(),
        new StaffFactory(),
        new SwordFactory()
    };
    for (WeaponFactory weaponFactory : weaponFactories) {
      for (int j = 0; j < UNITS_AMOUNT; j++) {
        player.addWeapon(weaponFactory.create());
      }
    }
    EnemyFactory enemyFactory = new EnemyFactory(unitsQueue);
    for (int i = 0; i < ENEMIES_AMOUNT; i++) {
      Enemy enemy = enemyFactory.create();
      enemies.add(enemy);
      unitsQueue.add(enemy);
    }
  }

  public void attack(GameUnit attacker, GameUnit target)
      throws DeadUnitException, NullWeaponException, InvalidTargetUnitException {
    attacker.attack(target);
  }

  public void castSpell(MagicUser mage, GameUnit target, Spell spell)
      throws InsufficientMpException, DeadUnitException,
      NonMagicWeaponException, NullWeaponException,
      InvalidMageTypeException, InvalidTargetUnitException {
    mage.castSpell(spell, target);
  }

  public void equip(PlayerUnit unit, Weapon weapon)
      throws InvalidWeaponException, OwnershipException {
    player.equip(unit, weapon);
  }

  public void execute() throws NullWeaponException {
    state.execute();
  }

  public void setActionOutput(String actionOutput) {
    this.actionOutput = actionOutput;
  }

  public ArrayList<Enemy> getEnemies() {
    return enemies;
  }

  public BlockingQueue<GameUnit> getUnitsQueue() {
    return unitsQueue;
  }

  public Player getPlayer() {
    return player;
  }

  public void setState(State state) {
    this.state = state;
    this.state.setContext(this);
  }

  public boolean isGameOver() {
    return gameOver;
  }

  public GameUnit getCurrentUnit() {
    return currentUnit;
  }

  public GameUnit nextUnit() throws InterruptedException {
    this.currentUnit = unitsQueue.take();
    return currentUnit;
  }

  public int getCursor(int optionsSize) {
    int selectPos = this.cursor % optionsSize;
    if (this.cursor % optionsSize < 0) {
      selectPos += optionsSize;
    }
    return selectPos;
  }

  public void setCursor(int cursor) {
    this.cursor = cursor;
  }

  public void resetCursor() {
    this.cursor = 0;
  }
}
