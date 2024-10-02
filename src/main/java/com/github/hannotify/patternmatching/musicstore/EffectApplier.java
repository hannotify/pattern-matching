package com.github.hannotify.patternmatching.musicstore;

import com.github.hannotify.patternmatching.musicstore.effects.*;
import com.github.hannotify.patternmatching.musicstore.guitars.Guitar;

import java.util.stream.Collectors;

public class EffectApplier {
    static String apply(Effect effect, Guitar guitar) {
        return switch(effect) {
            case Delay de      -> String.format("Delay active of %d ms.", de.getTimeInMs());
            case Reverb re     -> String.format("Reverb active of type %s and roomSize %d.", re.getName(), re.getRoomSize());
            case Overdrive ov  -> String.format("Overdrive active with gain %d.", ov.getGain());
            case Tremolo tr    -> String.format("Tremolo active with depth %d and rate %d.", tr.getDepth(), tr.getRate());
            case Tuner tu when !guitar.isInTune() -> String.format("Tuner active with pitch %d. Muting all signal!", tu.getPitchInHz());
            case Tuner _ -> "No need to tune, this guitar is pitch-perfect.";
            case EffectLoop el -> el.getEffects().stream().map(e -> apply(e, guitar)).collect(Collectors.joining(System.lineSeparator()));
            default            -> "Unknown effect active.";
        };
    }
}
