package com.github.hannotify.patternmatching.musicstore.effects;

import java.util.Objects;

public class Delay extends Effect {
    private final int timeInMs;

    public Delay(int timeInMs) {
        super(10);
        this.timeInMs = timeInMs;
    }

    @Override
    public String description() {
        return String.format("Delay / timeInMs=%dms", timeInMs);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Delay)) {
            return false;
        }

        Delay delay = (Delay) o;
        return timeInMs == delay.timeInMs;
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeInMs);
    }
}
