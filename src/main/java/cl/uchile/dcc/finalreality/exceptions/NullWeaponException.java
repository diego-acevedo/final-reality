package cl.uchile.dcc.finalreality.exceptions;

public class NullWeaponException extends Exception {
  public NullWeaponException(String description) {
    super("This operation is not defined for a null weapon. " + description);
  }
}
