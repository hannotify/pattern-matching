package com.github.hannotify.patternmatching.musicstore.effects;

public record Octave(com.github.hannotify.patternmatching.musicstore.effects.Octave.Range range,
                     int numberOfOctaves) implements Effect {

    @Override
    public String description() {
        return String.format("Octave / range=%s, numberOfOctaves=%d", range, numberOfOctaves);
    }

    public enum Range {
        BASSES,
        MIDS,
        TREBLES
    }
}
