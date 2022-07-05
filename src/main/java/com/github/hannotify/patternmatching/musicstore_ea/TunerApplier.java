package com.github.hannotify.patternmatching.musicstore_ea;

/*
# Guarded patterns & Deconstruction demo
 In this demo we use jshell to use early-access features of Java SDK which are not supported by IntelliJ.

 1. sdk use java 19.ea.29-open
 2. jshell --enable-preview
 3. Declare (by copying) the objects below

public enum GuitarType {
    CLASSICAL,
    WESTERN,
    TELECASTER,
    STRATOCASTER,
    LES_PAUL,
    GIBSON_ES335
}

public record Guitar(String name, GuitarType guitarType, boolean inTune) {}
public record Note(String note) {}
public record Tuner(int pitchInHz, Note note) {}


// Deconstruction demo with Nesting

public class TunerApplier {
    static String apply(Tuner effect, Guitar guitar) {
        return switch(effect) {
            case Tuner (int pitch, Note(String note)) when !guitar.inTune() -> String.format("Tuner active with pitch %d on Note %s", pitch, note);
            case Tuner tu when guitar.inTune() -> "No tuner active, because Guitar is in tune!";
            default -> throw new IllegalStateException("Unexpected value: " + effect);
        };
    }
}

TunerApplier.apply(new Tuner(600, new Note("A")), new Guitar("Peter", GuitarType.WESTERN, false));

 */