package cl.uchile.dcc.finalreality.exceptions;

/**
 * This exception represents a unit trying to do an action while paralyzed.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class ParalyzedUnitException extends Exception {

  /**
   * Creates a new {@code ParalyzedUnitException}.
   *
   * @param description a brief description of the error.
   */
  public ParalyzedUnitException(String description) {
    super("This unit cannot do an action while paralyzed. " + description);
  }
}
