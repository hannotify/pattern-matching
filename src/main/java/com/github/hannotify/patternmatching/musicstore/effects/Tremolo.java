package com.github.hannotify.patternmatching.musicstore.effects;

import java.util.Objects;

public class Tremolo implements Effect {
    private final int depth;
    private final int rate;

    public Tremolo(int depth, int rate) {
        this.depth = depth;
        this.rate = rate;
    }

    @Override
    public String description() {
        return String.format("Tremolo / depth=%d, rate=%dms", depth, rate);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tremolo)) {
            return false;
        }

        Tremolo tremolo = (Tremolo) o;
        return depth == tremolo.depth && rate == tremolo.rate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(depth, rate);
    }
}
