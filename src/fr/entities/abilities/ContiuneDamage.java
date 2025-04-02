package fr.entities.abilities;

import arc.Core;
import arc.scene.ui.layout.Table;
import arc.util.Strings;
import arc.util.Time;
import fr.world.meta.FRStats;
import mindustry.entities.abilities.Ability;
import mindustry.gen.Unit;
import mindustry.world.meta.StatUnit;

public class ContiuneDamage extends Ability {
  public float perDamage = 1f;
  public float perTime = 3600f;
  public float minHealthMultiplier = 0.9f;
  public float timer = 0f;

  public ContiuneDamage(float perDamage, float perTime, float minHealthMultiplier) {
    this.perDamage = perDamage;
    this.perTime = perTime;
    this.minHealthMultiplier = minHealthMultiplier;
  }

  @Override
  public void update(Unit unit) {
    timer += Time.delta;
    if (check(unit)) {
      unit.health -= perDamage;
      timer = 0f;
    } else if (unit.isShooting == true && check(unit)) {
      unit.health -= perDamage * 2;
      timer = 0f;
    }
  }

  public boolean check(Unit unit) {
    return unit.health >= unit.maxHealth * minHealthMultiplier && timer >= perTime;
  }

  @Override
  public void addStats(Table t) {
    t.add(FRStats.perDamage.localized() + "+" + perDamage);
    t.row();
    t.add(FRStats.perTime.localized() + ":" + Strings.autoFixed(perTime / 60f, 2) + " " + "/次");
    t.row();
    t.add(FRStats.minHealthMultiplier.localized() + ":" + (minHealthMultiplier * 100) + "%");
    t.row();
  }

  @Override
  public String localized() {
    return Core.bundle.get("ability.contiuneDamage");
  }
}
