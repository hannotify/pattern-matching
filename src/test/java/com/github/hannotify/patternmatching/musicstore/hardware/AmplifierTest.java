package com.github.hannotify.patternmatching.musicstore.hardware;

import com.github.hannotify.patternmatching.musicstore.effects.Delay;
import com.github.hannotify.patternmatching.musicstore.effects.EffectLoop;
import com.github.hannotify.patternmatching.musicstore.effects.Reverb;
import com.github.hannotify.patternmatching.musicstore.effects.Tremolo;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AmplifierTest {
    @Test
    void constructorAddsTwoEffectLoops() {
        // Arrange
        // Act
        var bossKatana100 = new Amplifier("BOSS Katana 100");

        // Assert
        final EffectLoop stockEffects = bossKatana100.getStockEffects();

        assertThat(stockEffects).isNotNull();
        assertThat(stockEffects.isEmpty()).isFalse();

        final EffectLoop auxEffects = bossKatana100.getAuxEffects();

        assertThat(auxEffects).isNotNull();
        assertThat(auxEffects.isEmpty()).isTrue();
    }

    @Test
    void constructorSetsDefaultStockEffects() {
        // Arrange
        var defaultDelay = new Delay(200);
        var defaultReverb = new Reverb("HallReverb", 100);

        // Act
        var voxAc30 = new Amplifier("Vox AC30");

        // Assert
        final EffectLoop stockEffects = voxAc30.getStockEffects();
        assertThat(stockEffects.hasEffect(defaultDelay)).isTrue();
        assertThat(stockEffects.hasEffect(defaultReverb)).isTrue();
    }

    @Test
    void equals() {
        // Arrange
        var bossKatana100 = new Amplifier("BOSS Katana 100");
        var secondBossKatana100 = new Amplifier("BOSS Katana 100");
        var voxAc30 = new Amplifier("Vox AC30");

        // Act
        // Assert
        assertThat(bossKatana100).isEqualTo(secondBossKatana100);
        assertThat(bossKatana100).isNotEqualTo(voxAc30);
    }

    @Test
    void addEffectUsesAuxEffects() {
        // Arrange
        var marshallJtm45 = new Amplifier("Marshall JTM-45 'Bluesbreaker'");

        // Act
        final Tremolo tremolo = new Tremolo(9, 6);
        marshallJtm45.addEffect(tremolo);
        
        // Assert
        assertThat(marshallJtm45.getAuxEffects().hasEffect(tremolo)).isTrue();
        assertThat(marshallJtm45.getStockEffects().hasEffect(tremolo)).isFalse();
    }

    @Test
    void getEffectList() {
        // Arrange
        var marshallJtm45 = new Amplifier("Marshall JTM-45 'Bluesbreaker'");

        // Act
        // Assert
        var effectList = marshallJtm45.getEffectList();
        assertThat(effectList).contains(
                new Delay(200),
                new Reverb("HallReverb", 100)
        );


        effectList.forEach(e -> {
            e.apply();

            if (e instanceof Delay delay) {
                delay.setTimeInMs(42);
            } else if (e instanceof Reverb reverb) {
                reverb.setName("StadiumReverb");
                reverb.setRoomSize(47_500);
            }

            e.apply();
        });
    }
}
