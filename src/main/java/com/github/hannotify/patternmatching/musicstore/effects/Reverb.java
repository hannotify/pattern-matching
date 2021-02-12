package com.github.hannotify.patternmatching.musicstore.effects;

import java.util.Objects;

public final class Reverb implements Effect {
    private String name;
    private int roomSize;

    public Reverb(String name, int roomSize) {
        this.name = name;
        this.roomSize = roomSize;
    }

    @Override
    public String description() {
        return String.format("Reverb / name=%s, roomSize=%d", name, roomSize);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Reverb)) {
            return false;
        }

        Reverb reverb = (Reverb) o;
        return roomSize == reverb.roomSize && Objects.equals(name, reverb.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, roomSize);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoomSize(int roomSize) {
        this.roomSize = roomSize;
    }
}

