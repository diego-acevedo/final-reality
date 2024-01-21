package cl.uchile.dcc.finalreality.controller.visitors;

import cl.uchile.dcc.finalreality.model.spells.types.*;

/**
 * This represents an element that can visit spells.
 *
 * @param <T> the type of the object the visitor will return.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public interface SpellVisitor<T> {

  /**
   * Visits a {@link Cure cure spell}.
   *
   * @param cure the spell being visited.
   *
   * @return the expected object for a {@link Cure cure spell}.
   */
  T visitCure(Cure cure);

  /**
   * Visits a {@link Fire fire spell}.
   *
   * @param fire the spell being visited.
   *
   * @return the expected object for a {@link Fire fire spell}.
   */
  T visitFire(Fire fire);

  /**
   * Visits a {@link Paralysis paralysis spell}.
   *
   * @param paralysis the spell being visited.
   *
   * @return the expected object for a {@link Paralysis paralysis spell}.
   */
  T visitParalysis(Paralysis paralysis);

  /**
   * Visits a {@link Poison poison spell}.
   *
   * @param poison the spell being visited.
   *
   * @return the expected object for a {@link Poison poison spell}.
   */
  T visitPoison(Poison poison);

  /**
   * Visits a {@link Thunder thunder spell}.
   *
   * @param thunder the spell being visited.
   *
   * @return the expected object for a {@link Thunder thunder spell}.
   */
  T visitThunder(Thunder thunder);
}
