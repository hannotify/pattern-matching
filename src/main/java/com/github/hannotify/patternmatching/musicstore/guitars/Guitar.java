package com.github.hannotify.patternmatching.musicstore.guitars;

import com.github.hannotify.patternmatching.musicstore.hardware.Amplifier;
import java.util.Objects;

public class Guitar {
    private String name;
    private GuitarType guitarType;
    private Amplifier amplifier;
    private boolean inTune;

    public Guitar(String name, GuitarType guitarType, Amplifier amplifier) {
        this.name = name;
        this.guitarType = guitarType;
        this.amplifier = amplifier;
        this.inTune = true;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Guitar)) {
            return false;
        }

        Guitar other = (Guitar) o;
        return name.equals(other.name) && guitarType == other.guitarType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, guitarType);
    }

    @Override
    public String toString() {
        return String.format("Guitar / %s", name);
    }

    public Guitar outOfTune() {
        this.inTune = false;
        return this;
    }

    public Guitar inTune() {
        this.inTune = true;
        return this;
    }

    public boolean isInTune() {
        return inTune;
    }
}
