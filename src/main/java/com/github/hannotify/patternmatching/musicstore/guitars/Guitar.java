package com.github.hannotify.patternmatching.musicstore.guitars;

import com.github.hannotify.patternmatching.musicstore.hardware.Amplifier;
import java.util.Objects;

public class Guitar {
    private String name;
    private GuitarType guitarType;
    private Amplifier amplifier;

    public Guitar(String name, GuitarType guitarType, Amplifier amplifier) {
        this.name = name;
        this.guitarType = guitarType;
        this.amplifier = amplifier;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Guitar other) &&
                name.equals(other.name) && guitarType == other.guitarType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, guitarType);
    }
}
