package com.github.hannotify.patternmatching.musicstore_ea;

/*
# Guarded patterns DEMO
 In this demo we use jshell to use early-access features of Java SDK which are not supported by IntelliJ.

 1. sdk use java 19.ea.29-open
 2. jshell --enable-preview
 3. Declare (by copying) the objects below
 4. Profit

public enum GuitarType {
    CLASSICAL,
    WESTERN,
    TELECASTER,
    STRATOCASTER,
    LES_PAUL,
    GIBSON_ES335
}

public record Guitar(String name, GuitarType guitarType, boolean inTune) {}
public record Tuner(int pitchInHz) {}

public class TunerApplier {
    static String apply(Tuner effect, Guitar guitar) {
        return switch(effect) {
            case Tuner tu when !guitar.inTune() -> String.format("Tuner active with pitch %d. Muting all signal!", tu.pitchInHz());
            case Tuner tu when guitar.inTune() -> "No tuner active, because Guitar is in tune!";
                default -> throw new IllegalStateException("Unexpected value: " + effect);
        };
    }
}

 TunerApplier.apply(new Tuner(600), new Guitar("Peter", GuitarType.WESTERN, true));

 */