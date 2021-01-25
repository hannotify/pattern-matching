package com.github.hannotify.patternmatching.musicstore.effects;

public abstract class Effect {
    protected int volume; // 0-10
    private int volumeBeforeMute;

    public void apply() {
        System.out.format("Effect applied - %s, volume=%d", description(), volume);
    }

    abstract String description();

    public void mute() {
        if (volume > 0) {
            volumeBeforeMute = volume;
            volume = 0;
        }
    }

    public void unmute() {
        if (volume != volumeBeforeMute) {
            volume = volumeBeforeMute;
        }
    }
}
