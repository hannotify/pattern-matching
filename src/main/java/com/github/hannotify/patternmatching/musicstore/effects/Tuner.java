package com.github.hannotify.patternmatching.musicstore.effects;

import com.github.hannotify.patternmatching.musicstore.guitars.Guitar;
import java.util.Objects;

public class Tuner extends Effect {
    private final int pitchInHz;

    public Tuner(int pitchInHz) {
        super(0);
        this.pitchInHz = pitchInHz;
    }

    public boolean isInTune(Guitar guitar) {
        return true;
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
}
