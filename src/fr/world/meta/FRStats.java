package fr.world.meta;

import mindustry.world.meta.Stat;

public class FRStats {

  public static Stat perDamage;
  public static Stat perTime;
  public static Stat minHealthMultiplier;
  public static Stat unitEnergy;
  static {
    FRStats.perDamage = new Stat("perDamage");
    FRStats.perTime = new Stat("perTime");
    FRStats.minHealthMultiplier = new Stat("minHealthMultiplier");
    FRStats.unitEnergy = new Stat("unitEnergy");
  }
}
