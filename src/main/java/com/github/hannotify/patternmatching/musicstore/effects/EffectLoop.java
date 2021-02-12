package com.github.hannotify.patternmatching.musicstore.effects;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public record EffectLoop(String name, Set<Effect> effects) implements Effect {

    public EffectLoop(String name) {
        this(name, new HashSet<>());
    }

    public void addEffect(Effect effect) {
        effects.add(effect);
    }

    public boolean hasEffect(Effect effect) {
        return effects.contains(effect);
    }

    public boolean isEmpty() { return effects.isEmpty(); }

    @Override
    public String description() {
        return String.format("EffectLoop / name=%s, effects=%s", name,
                effects.stream()
                    .map(Effect::description)
                    .collect(Collectors.joining(", ")));
    }

    public Set<Effect> getEffects() {
        return effects;
    }
}
