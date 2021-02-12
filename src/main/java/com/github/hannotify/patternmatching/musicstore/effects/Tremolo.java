package com.github.hannotify.patternmatching.musicstore.effects;

public record Tremolo(int depth, int rate) implements Effect {

    @Override
    public String description() {
        return String.format("Tremolo / depth=%d, rate=%dms", depth, rate);
    }
}
