package com.github.hannotify.patternmatching.musicstore.effects;

import com.github.hannotify.patternmatching.musicstore.guitars.Guitar;
import com.github.hannotify.patternmatching.musicstore.guitars.GuitarType;
import com.github.hannotify.patternmatching.musicstore.hardware.Amplifier;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class EffectTest {
    private Delay delay;
    private Octave octave;
    private Overdrive overdrive;
    private Reverb reverb;
    private Tremolo tremolo;
    private Tuner tuner;
    private Set<Effect> allEffects;

    @BeforeEach
    void setUp() {
        delay = new Delay(420);
        octave = new Octave(Octave.Range.BASSES, 1);
        overdrive = new Overdrive(8);
        reverb = new Reverb("ChurchReverb", 3);
        tremolo = new Tremolo(2, 4);
        tuner = new Tuner(440);

        allEffects = Set.of(delay, octave, overdrive, reverb, tremolo, tuner);
    }

    @Test
    void apply() {
        // Arrange
        var outContent = new ByteArrayOutputStream();
        var originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Act
        octave.apply();

        // Assert
        assertThat(outContent.toString()).isEqualTo(
                String.format("Effect applied - %s%n", octave.description()));

        System.setOut(originalOut);
    }

    @Test
    void description() {
        // Arrange
        // Act
        // Assert
        assertAll(() -> {
            assertThat(delay.description()).isEqualTo("Delay / timeInMs=420ms");
            assertThat(octave.description()).isEqualTo("Octave / range=BASSES, numberOfOctaves=1");
            assertThat(overdrive.description()).isEqualTo("Overdrive / gain=8");
            assertThat(reverb.description()).isEqualTo("Reverb / name=ChurchReverb, roomSize=3");
            assertThat(tremolo.description()).isEqualTo("Tremolo / depth=2, rate=4ms");
            assertThat(tuner.description()).isEqualTo("Tuner / pitchInHz=440Hz");
        });
    }

    @Test
    void tune() {
        // Arrange
        // Act
        // Assert
        assertThat(tuner.isInTune(new Guitar("Fender Strat", GuitarType.STRATOCASTER,
                new Amplifier("Boss Katana 100")))).isTrue();
    }

    @AfterEach
    void tearDown() {
        delay = null;
        octave = null;
        overdrive = null;
        reverb = null;
        tremolo = null;
        tuner = null;
    }
}