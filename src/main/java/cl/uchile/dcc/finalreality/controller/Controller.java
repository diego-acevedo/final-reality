package cl.uchile.dcc.finalreality.controller;

import cl.uchile.dcc.finalreality.model.player.Player;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;

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
  private final Enemy[] enemies;

  public Controller(int enemyAmount) {
    this.enemies = new Enemy[enemyAmount];
    this.player = new Player();
  }
}
