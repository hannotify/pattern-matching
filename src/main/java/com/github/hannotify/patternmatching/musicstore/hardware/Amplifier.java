package com.github.hannotify.patternmatching.musicstore.hardware;

import com.github.hannotify.patternmatching.musicstore.effects.Delay;
import com.github.hannotify.patternmatching.musicstore.effects.Effect;
import com.github.hannotify.patternmatching.musicstore.effects.EffectLoop;
import com.github.hannotify.patternmatching.musicstore.effects.Reverb;
import java.util.Objects;
import java.util.Set;

public class Amplifier {
    private String name;
    private EffectLoop stockEffects;
    private EffectLoop auxEffects;

    public Amplifier(String name) {
        this.name = name;
        stockEffects = new EffectLoop("Stock effects",
                Set.of(new Delay(200).volume(0), new Reverb("HallReverb", 100).volume(0))
        ).volume(0);
        auxEffects = new EffectLoop("Aux effects").volume(0);
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
}
