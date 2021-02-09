package com.github.hannotify.patternmatching.musicstore.hardware;

import com.github.hannotify.patternmatching.musicstore.effects.Delay;
import com.github.hannotify.patternmatching.musicstore.effects.Effect;
import com.github.hannotify.patternmatching.musicstore.effects.EffectLoop;
import com.github.hannotify.patternmatching.musicstore.effects.Reverb;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Amplifier {
    private String name;
    private EffectLoop stockEffects;
    private EffectLoop auxEffects;

    public Amplifier(String name) {
        this.name = name;
        stockEffects = new EffectLoop("Stock effects",
                Set.of(new Delay(200), new Reverb("HallReverb", 100))
        );
        auxEffects = new EffectLoop("Aux effects");
    }

    public void addEffect(Effect effect) {
        auxEffects.addEffect(effect);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Amplifier)) {
            return false;
        }

        Amplifier other = (Amplifier) o;

        return Objects.equals(name, other.name) && Objects.equals(stockEffects, other.stockEffects)
                && Objects.equals(auxEffects, other.auxEffects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stockEffects, auxEffects);
    }

    EffectLoop getStockEffects() {
        return stockEffects;
    }

    EffectLoop getAuxEffects() {
        return auxEffects;
    }

    List<Effect> getEffectList() {
        return List.of(stockEffects, auxEffects).stream()
                .flatMap(e -> e.getEffects().stream())
                .collect(Collectors.toList());
    }
}
