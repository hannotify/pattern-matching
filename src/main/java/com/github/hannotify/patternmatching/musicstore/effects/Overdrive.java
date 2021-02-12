package com.github.hannotify.patternmatching.musicstore.effects;

public record Overdrive(int gain) implements Effect {

    @Override
    public String description() {
        return String.format("Overdrive / gain=%d", gain);
    }
}
