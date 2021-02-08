package com.github.hannotify.patternmatching.musicstore.guitars;

import com.github.hannotify.patternmatching.musicstore.hardware.Amplifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class GuitarTest {

    @Test
    void equalsUsesNameAndGuitarTypeOnly() {
        // Arrange
        var bossKatana100 = new Amplifier("BOSS Katana 100");
        var marshallJtm45 = new Amplifier("Marshall JTM-45 'Bluesbreaker'");
        var voxAc30 = new Amplifier("Vox AC30");

        var teleWithVox = new Guitar("Fender Telecaster", GuitarType.TELECASTER, voxAc30);
        var teleWithMarshall = new Guitar("Fender Telecaster", GuitarType.TELECASTER, marshallJtm45);

        var ibanezWithBoss = new Guitar("Ibanez AZ224F", GuitarType.STRATOCASTER, bossKatana100);
        var ibanezWithMarshall = new Guitar("Ibanez AZ224F", GuitarType.STRATOCASTER, marshallJtm45);

        // Act
        // Assert
        assertAll(() -> {
            assertThat(teleWithVox).isEqualTo(teleWithMarshall);
            assertThat(teleWithMarshall).isEqualTo(teleWithVox);

            assertThat(ibanezWithBoss).isEqualTo(ibanezWithMarshall);
            assertThat(ibanezWithMarshall).isEqualTo(ibanezWithBoss);

            assertThat(teleWithMarshall).isNotEqualTo(ibanezWithMarshall);
            assertThat(ibanezWithMarshall).isNotEqualTo(teleWithMarshall);
        });
    }
}