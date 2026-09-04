package net.kaupenjoe.tutorialmod.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum DodoVariant {
    DEFAULT(0),
    BLUE(1);

    private static final DodoVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(
            DodoVariant::getId)).toArray(DodoVariant[]::new);
    private final int id;

    DodoVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static DodoVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
