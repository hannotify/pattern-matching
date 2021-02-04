package com.github.hannotify.patternmatching.musicstore.effects;

import java.util.Objects;

public class Overdrive extends Effect {
    private final int gain;

    public Overdrive(int gain) {
        super(10);
        this.gain = gain;
    }

    @Override
    public String description() {
        return String.format("Overdrive / gain=%d", gain);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Overdrive)) {
            return false;
        }

        Overdrive overdrive = (Overdrive) o;
        return gain == overdrive.gain;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gain);
    }
}
