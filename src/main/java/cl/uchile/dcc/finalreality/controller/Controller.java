package cl.uchile.dcc.finalreality.controller;

import cl.uchile.dcc.finalreality.controller.factories.units.PlayerUnitFactory;
import cl.uchile.dcc.finalreality.controller.factories.units.types.*;
import cl.uchile.dcc.finalreality.controller.factories.weapons.WeaponFactory;
import cl.uchile.dcc.finalreality.controller.factories.weapons.types.*;
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

  private final Player player;
  private final ArrayList<Enemy> enemies;
  private final BlockingQueue<GameUnit> unitsQueue;
  public static int UNITS_AMOUNT = 5;
  public static int ENEMIES_AMOUNT = 3;
  public String actionOutput = "";

  public Controller() {
    this.enemies = new ArrayList<>();
    this.player = new Player();
    this.unitsQueue = new LinkedBlockingQueue<>();
  }

  public void init() throws InvalidStatException {
    Random random = new Random();
    PlayerUnitFactory[] playerUnitFactories = {
        new BlackMageFactory(unitsQueue),
        new EngineerFactory(unitsQueue),
        new KnightFactory(unitsQueue),
        new ThiefFactory(unitsQueue),
        new WhiteMageFactory(unitsQueue)
    };
    for (int i = 0; i < UNITS_AMOUNT; i++) {
      player.addUnit(playerUnitFactories[random.nextInt(0, playerUnitFactories.length)].create());
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
      enemies.add(enemyFactory.create());
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

  public void setActionOutput(String actionOutput) {
    this.actionOutput = actionOutput;
  }
}
