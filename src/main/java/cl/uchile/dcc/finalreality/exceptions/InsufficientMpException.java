package cl.uchile.dcc.finalreality.exceptions;

/**
 * This exception represents an insufficient amount of mp.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class InsufficientMpException extends Exception {

  /**
   * Creates a new {@code InsufficientMpException}.
   *
   * @param description a brief description of the error.
   */
  public InsufficientMpException(String description) {
    super("Not enough mp to cast a spell. " + description);
  }
}
