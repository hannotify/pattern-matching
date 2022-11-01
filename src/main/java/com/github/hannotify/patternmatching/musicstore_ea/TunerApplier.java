package com.github.hannotify.patternmatching.musicstore_ea;

public class TunerApplier {
    static String apply(Tuner effect, Guitar guitar) {
        return switch(effect) {
            case Tuner tu when guitar.inTune() -> "No tuner active, because Guitar is in tune!";
            default -> throw new IllegalStateException("Unexpected value: " + effect);
        };
    }
}