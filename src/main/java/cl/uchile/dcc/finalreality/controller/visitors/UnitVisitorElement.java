package cl.uchile.dcc.finalreality.controller.visitors;

import cl.uchile.dcc.finalreality.model.units.GameUnit;

/**
 * This represents an element that can be visited by a
 * {@link UnitVisitor unit visitor}. These elements are
 * {@link GameUnit game units}.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public interface UnitVisitorElement {

  /**
   * Indicates to the visitor which type of element
   * is visiting.
   *
   * @param visitor the visitor visiting this element.
   *
   * @return the expected object for this element.
   *
   * @param <T> the type of the element being returned by
   *           the visitor.
   */
  <T> T accept(UnitVisitor<T> visitor);
}
