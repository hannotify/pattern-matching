package com.github.hannotify.patternmatching.musicstore.hardware;

import com.github.hannotify.patternmatching.musicstore.effects.Effect;
import java.util.ArrayList;
import java.util.List;

public class Amplifier {
    private String name;
    private List<Effect> effects;

    public Amplifier(String name) {
        this.name = name;
        this.effects = new ArrayList<>();
    }

    public void addEffect(Effect effect) {
        effects.add(effect);
    }
}
