package fr.content;

import fr.type.FRNomralUnitType;
import mindustry.content.UnitTypes;
import mindustry.type.UnitType;

public class FRUnits {

  public static UnitType test;

  public static void load() {
    FRUnits.test = new FRNomralUnitType("test") {
      {
        this.constructor = UnitTypes.flare.constructor;
        this.controller = UnitTypes.flare.controller;
        this.flying = true;
        this.health = 500;
        this.speed = 2;
      }
    };
  }
}
