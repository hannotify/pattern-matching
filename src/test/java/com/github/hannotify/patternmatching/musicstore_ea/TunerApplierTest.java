package com.github.hannotify.patternmatching.musicstore_ea;

import com.github.hannotify.patternmatching.musicstore.effects.*;
import com.github.hannotify.patternmatching.musicstore.guitars.Guitar;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TunerApplierTest {

    @Test
    void testEffectApplier() {
        TunerApplier.apply(
                new Tuner(600, new Note("A")),
                new com.github.hannotify.patternmatching.musicstore_ea.Guitar("Peter", GuitarType.WESTERN, false)
        );
    }
}