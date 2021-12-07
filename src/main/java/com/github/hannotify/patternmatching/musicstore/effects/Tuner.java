package com.github.hannotify.patternmatching.musicstore.effects;

import com.github.hannotify.patternmatching.musicstore.guitars.Guitar;
import java.util.Objects;

public final class Tuner implements Effect {
    private final int pitchInHz;

    public Tuner(int pitchInHz) {
        this.pitchInHz = pitchInHz;
    }

    public boolean isInTune(Guitar guitar) {
        return guitar.isInTune();
    }

    @Override
    public String description() {
        return String.format("Tuner / pitchInHz=%dHz", pitchInHz);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tuner)) {
            return false;
        }

        Tuner tuner = (Tuner) o;
        return pitchInHz == tuner.pitchInHz;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pitchInHz);
    }

    @Override
    public String toString() {
        return description();
    }

    public int getPitchInHz() {
        return pitchInHz;
    }
}
