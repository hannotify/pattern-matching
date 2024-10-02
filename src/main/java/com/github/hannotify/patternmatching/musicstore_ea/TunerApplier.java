package com.github.hannotify.patternmatching.musicstore_ea;

public class TunerApplier {
    static String apply(Tuner effect, Guitar guitar) {
        return switch(effect) {
            case Tuner _ when guitar.inTune() -> "No tuner active, because Guitar is in tune!";
            case Tuner(int pitch, Note(String note)) -> "Tuner active with pitch %d on Note %s".formatted(pitch, note);
        };
    }
}