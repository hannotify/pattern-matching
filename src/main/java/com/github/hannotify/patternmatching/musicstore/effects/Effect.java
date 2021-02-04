package com.github.hannotify.patternmatching.musicstore.effects;

public abstract class Effect {
    private int volume; // 0-10
    private int volumeBeforeMute;

    public Effect(int volume) {
        this.volume = volume;
    }

    public void apply() {
        System.out.format("Effect applied - %s, volume=%d", description(), volume);
    }

    public abstract String description();

    public Effect volume(int volume) {
        this.volume = volume;
        return this;
    }

    public void mute() {
        if (volume > 0) {
            volumeBeforeMute = volume;
            volume(0);
        }
    }

    public void unmute() {
        if (volume != volumeBeforeMute) {
            volume(volumeBeforeMute);
        }
    }

    int getVolume() {
        return volume;
    }
}
