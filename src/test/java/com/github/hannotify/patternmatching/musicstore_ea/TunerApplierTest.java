package com.github.hannotify.patternmatching.musicstore_ea;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TunerApplierTest {

    @Test
    void testEffectApplier_outOfTune() {
        String tunerResult = TunerApplier.apply(
                new Tuner(600, new Note("A")),
                new Guitar("Peter", GuitarType.WESTERN, true)
        );

        assertThat(tunerResult).isEqualTo("No tuner active, because Guitar is in tune!");
    }

    @Test
    void testEffectApplier_inTune() {
        String tunerResult = TunerApplier.apply(
                new Tuner(600, new Note("A")),
                new Guitar("Peter", GuitarType.WESTERN, true)
        );

        assertThat(tunerResult).isEqualTo("Tuner active with pitch 600 on Note A");
    }
}