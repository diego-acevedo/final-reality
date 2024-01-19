package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.exceptions.OwnershipException;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SelectWeapon extends AbstractState {

  private final PlayerUnit unit;
  private final ArrayList<Weapon> options;

  public SelectWeapon(PlayerUnit unit) {
    this.unit = unit;
    this.options = getContext().getPlayer().getInventory();
  }

  @Override
  public void execute() {
    int selectPos = getContext().getCursor(options.size());
    Weapon weapon = options.get(selectPos);
    try {
      getContext().equip(unit, weapon);
      getContext().setActionOutput("%s was equipped to %s.".formatted(weapon, unit));
      getContext().setState(new PlayerSelectAction(unit));
    } catch (InvalidWeaponException e) {
      getContext().setActionOutput("%s cannot equip %s.".formatted(unit, weapon));
    } catch (OwnershipException e) {
      getContext().setActionOutput("%s doesn't belong to the player.".formatted(weapon));
    }
  }

  @Override
  public ArrayList<String> getOptions() {
    return this.options.stream().map(Object::toString)
        .collect(Collectors.toCollection(ArrayList::new));
  }
}
