package com.github.hannotify.patternmatching.musicstore.effects;

import java.util.Objects;

public class Octave implements Effect {
    private final Range range;
    private final int numberOfOctaves;

    public Octave(Range range, int numberOfOctaves) {
        this.range = range;
        this.numberOfOctaves = numberOfOctaves;
    }

    @Override
    public String description() {
        return String.format("Octave / range=%s, numberOfOctaves=%d", range, numberOfOctaves);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Octave)) {
            return false;
        }

        Octave octave = (Octave) o;
        return range == octave.range && numberOfOctaves == octave.numberOfOctaves;
    }

    @Override
    public int hashCode() {
        return Objects.hash(range, numberOfOctaves);
    }

    public enum Range {
        BASSES,
        MIDS,
        TREBLES
    }
}
