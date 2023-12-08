package cl.uchile.dcc.finalreality.exceptions;

public class InvalidStatException extends Exception {
  public InvalidStatException(String description) {
    super("This value cannot be assigned. " + description);
  }
}
