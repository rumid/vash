package com.rumid.vash.domain.gamesgetter;

import java.util.Objects;

public final class Game {
    private final String name;

    public Game(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return Objects.equals(getName(), game.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
