package com.github.hannotify.patternmatching.musicstore.effects;

import com.github.hannotify.patternmatching.musicstore.guitars.Guitar;

public record Tuner(int pitchInHz) implements Effect {

    public boolean isInTune(Guitar guitar) {
        return true;
    }

    @Override
    public String description() {
        return String.format("Tuner / pitchInHz=%dHz", pitchInHz);
    }
}
