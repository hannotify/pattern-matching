package com.github.hannotify.patternmatching.musicstore.effects;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class EffectLoop implements Effect {
    private final String name;
    private final Set<Effect> effects;

    public EffectLoop(String name) {
        this(name, new HashSet<>());
    }

    public EffectLoop(String name, Set<Effect> effects) {
        this.name = name;
        this.effects = effects;
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EffectLoop)) {
            return false;
        }

        EffectLoop other = (EffectLoop) o;
        return Objects.equals(name, other.name) && Objects.equals(effects, other.effects);
    }

    @Override
    public String toString() {
        return description();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, effects);
    }

    public Set<Effect> getEffects() {
        return effects;
    }
}
