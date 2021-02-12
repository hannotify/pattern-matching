package com.github.hannotify.patternmatching.musicstore.effects;

public sealed interface Effect permits Delay, EffectLoop, Octave, Overdrive, Reverb, Tremolo, Tuner {
    default void apply() {
        System.out.format("Effect applied - %s%n", description());
    }

    String description();
}
