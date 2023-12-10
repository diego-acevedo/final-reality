package cl.uchile.dcc.finalreality.exceptions;

public class InvalidWeaponException extends Exception {
  public InvalidWeaponException(String description) {
    super("This weapon cannot be assigned. " + description);
  }
}
