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

  /**
   * Initializes the basics elements of the game. It sets
   * an initial state for the game, creates an amount of
   * {@code UNITS_AMOUNT} player units, an amount of
   * {@code UNITS_AMOUNT} of each type of weapon, and an amount of
   * {@code ENEMIES_AMOUNT}. This method is used during the
   * pre-game phase.
   *
   * @throws InvalidStatException if a unit is created with
   * invalid stats.
   */
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
      unit.setController(this);
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
      enemy.setController(this);
      enemies.add(enemy);
      unitsQueue.add(enemy);
    }
  }

  /**
   * Makes a {@code target} receive an attack from
   * an {@code attacker}.
   *
   * @param attacker the unit that attacks.
   * @param target the unit that receives the damage.
   *
   * @throws DeadUnitException if one of the units is dead.
   * @throws NullWeaponException if the attacker is a {@link PlayerUnit player unit}
   *                             and doesn't have a weapon equipped.
   * @throws InvalidTargetUnitException if a {@link PlayerUnit player unit} tries to
   *                                    attack an {@link Enemy enemy} or vice versa.
   */
  public void attack(GameUnit attacker, GameUnit target)
      throws DeadUnitException, NullWeaponException, InvalidTargetUnitException {
    attacker.attack(target);
  }

  /**
   * Makes a {@code mage} cast a {@code spell} to a {@code attacker}.
   *
   * @param mage the mage casting the spell.
   * @param target the unit receiving the spell.
   * @param spell the spell cast.
   *
   * @throws InsufficientMpException if the mage doesn't have enough mp.
   * @throws DeadUnitException if one of the unit is dead.
   * @throws NonMagicWeaponException if the mage's weapon is not magical.
   * @throws NullWeaponException if the mage doesn't have a weapon equipped.
   * @throws InvalidMageTypeException if the spell is not of the same type as the mage.
   * @throws InvalidTargetUnitException if the target can't receive that type of spell.
   */
  public void castSpell(MagicUser mage, GameUnit target, Spell spell)
      throws InsufficientMpException, DeadUnitException,
      NonMagicWeaponException, NullWeaponException,
      InvalidMageTypeException, InvalidTargetUnitException {
    mage.castSpell(spell, target);
  }

  /**
   * Equips a {@code weapon} to a {@code unit}.
   *
   * @param unit the unit receiving the weapon.
   * @param weapon the weapon being equipped.
   *
   * @throws InvalidWeaponException if the unt can't have that type of weapon
   * equipped.
   * @throws OwnershipException if the player doesn't own the weapon.
   */
  public void equip(PlayerUnit unit, Weapon weapon)
      throws InvalidWeaponException, OwnershipException {
    player.equip(unit, weapon);
  }

  /**
   * Triggers a change of state in the game. The change of
   * state is managed by a {@link State state pattern}.
   */
  public void execute() {
    state.execute();
  }

  /**
   * Sets a new output showing the result of an action.
   * In this context, an action is a change of state.
   *
   * @param actionOutput the new output.
   */
  public void setActionOutput(String actionOutput) {
    this.actionOutput = actionOutput;
  }

  /**
   * Returns the enemy's list
   */
  public ArrayList<Enemy> getEnemies() {
    return enemies;
  }

  /**
   * Returns the player.
   */
  public Player getPlayer() {
    return player;
  }

  /**
   * Sets a new state to the controller. If the new state should
   * be automatically executed, it will execute it. Everytime a new
   * state is set, the cursor gets reset.
   *
   * @param state the new state.
   */
  public void setState(State state) {
    this.state = state;
    this.state.setContext(this);
    resetCursor();
    if (state.autoExecute()) execute();
  }

  /**
   * Returns true if all the player units or all the enemies are dead.
   */
  public boolean isGameOver() {
    return gameOver;
  }

  /**
   * Extract the unit at the front of the queue.
   *
   * @return the unt at the front of the queue.
   *
   * @throws InterruptedException if the program is interrupted
   * before a unit can be taken from the queue.
   */
  public GameUnit nextUnit() throws InterruptedException {
    this.currentUnit = unitsQueue.take();
    return currentUnit;
  }

  /**
   * Calculates the value of the cursor based on the current list of options.
   *
   * @param optionsSize the size of the options list.
   *
   * @return the value of the cursor.
   */
  public int getCursor(int optionsSize) {
    int selectPos = this.cursor % optionsSize;
    if (this.cursor % optionsSize < 0) {
      selectPos += optionsSize;
    }
    return selectPos;
  }

  /**
   * Adds a value to the current value of the cursor.
   * This value can be negative to decrease the value of
   * the cursor.
   *
   * @param cursor the amount to increase the cursor
   */
  public void setCursor(int cursor) {
    this.cursor += cursor;
  }

  /**
   * Sets the cursor value to 0.
   */
  public void resetCursor() {
    this.cursor = 0;
  }

  /**
   * Checks if the game is over. If it is, it sets the {@code gameOver}
   * variable to true.
   */
  public void checkGameOver() {
    gameOver = getPlayer().getParty().stream().map(GameUnit::isDead).reduce(true, (a, b) -> a && b)
        || getEnemies().stream().map(GameUnit::isDead).reduce(true, (a, b) -> a && b);
  }

  /**
   * Goes back to a previous state.
   */
  public void goBack() {
    state.goBack();
  }
}
