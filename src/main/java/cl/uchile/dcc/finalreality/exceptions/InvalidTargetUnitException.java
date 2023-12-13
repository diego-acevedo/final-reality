package cl.uchile.dcc.finalreality.exceptions;

/**
 * This exception represents an invalid target unit.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class InvalidTargetUnitException extends Exception {

  /**
   * Creates a new {@code InvalidTargetUnitException}.
   *
   * @param description a brief description of the error.
   */
  public InvalidTargetUnitException(String description) {
    super("This unit is an invalid target. " + description);
  }
}
