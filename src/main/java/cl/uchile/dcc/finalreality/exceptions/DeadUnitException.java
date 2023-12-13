package cl.uchile.dcc.finalreality.exceptions;

/**
 * This exception represents a death unit.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class DeadUnitException extends Exception {

  /**
   * Creates a new {@code DeathUnitException}.
   *
   * @param description a brief description of the error.
   */
  public DeadUnitException(String description) {
    super("This unit is dead. " + description);
  }
}
