package fr.type;

import arc.Core;
import arc.func.Floatp;
import arc.graphics.Color;
import arc.scene.ui.layout.Scl;
import arc.scene.ui.layout.Table;
import fr.entities.abilities.ContiuneDamage;
import fr.world.meta.FRStats;
import mindustry.type.UnitType;
import mindustry.gen.Unit;
import mindustry.ui.Bar;
import mindustry.graphics.Pal;

public class FRNomralUnitType extends UnitType {
  public float unitEnergy, maxUnitEnergy;
  public Floatp unitEnergyTemp;

  public FRNomralUnitType(String name) {
    super(name);
    this.unitEnergy = 200f;
    this.maxUnitEnergy = this.unitEnergy;
    getFloatp();
  }

  public Floatp getFloatp() {
    this.unitEnergyTemp = () -> this.unitEnergy;
    return this.unitEnergyTemp;

  }

  @Override
  public void display(Unit unit, Table table) {
    super.display(unit, table);
    table.table(bars -> {
      bars.defaults().growX().height(20f).pad(4);
      bars.add(new Bar(Core.bundle.get("stat.unitEnergy"), Pal.heal, () -> unitEnergyTemp / maxUnitEnergy)
          .blink(Color.white));
    }).growX();
  }

  @Override
  public void setStats() {
    super.setStats();
    stats.add(FRStats.unitEnergy, unitEnergy);
  }
}
