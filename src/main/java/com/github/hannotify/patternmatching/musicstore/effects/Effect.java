package com.github.hannotify.patternmatching.musicstore.effects;

public interface Effect {
    default void apply() {
        System.out.format("Effect applied - %s%n", description());
    }

    String description();
}
