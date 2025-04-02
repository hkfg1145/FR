package fr;

import fr.content.FRUnits;
import mindustry.mod.Mod;

public class FRMain extends Mod {
  public FRMain() {

  }

  @Override
  public void loadContent() {
    FRUnits.load();
  }
}
