package com.github.hannotify.patternmatching.musicstore.effects;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class EffectLoopTest {
    private EffectLoop effects;

    @BeforeEach
    private void setUp() {
        effects = new EffectLoop("The Edge", new HashSet<>(List.of(
                new Overdrive(8),
                new Delay(420),
                new Delay(100))
        ));
    }

    @Test
    void testIsEmpty() {
        // Arrange
        // Act
        // Assert
        assertThat(effects.isEmpty()).isFalse();
    }

    @Test
    void testDefaultEffects() {
        // Arrange
        // Act
        var defaultEffects = new EffectLoop("Basic effects");

        // Assert
        assertThat(defaultEffects.getEffects()).isEmpty();
    }

    @Test
    void testHasEffect() {
        // Arrange
        // Act
        // Assert
        assertThat(effects.hasEffect(new Overdrive(8))).isTrue();
        assertThat(effects.hasEffect(new Delay(42))).isFalse();
    }


    @Test
    void testEffectAddition() {
        // Arrange
        var octave = new Octave(Octave.Range.BASSES, 2);

        // Act
        effects.addEffect(octave);

        // Assert
        assertThat(effects.hasEffect(octave)).isTrue();
    }

    @Test
    void testDescription() {
        // Arrange
        var expectedDescription = "EffectLoop / name=The Edge, effects=Delay / timeInMs=420ms, Delay / timeInMs=100ms, Overdrive / gain=8";

        // Act
        // Assert
        assertThat(effects.description()).isEqualTo(expectedDescription);
    }

    @AfterEach
    private void tearDown() {
        effects = null;
    }
}