package com.rumid.vash.domain.gamesfinder;

import java.util.Objects;

public final class Game {
    private final String name;
    private final boolean multiplayer;
    private final boolean online;

    public Game(String name, boolean multiplayer, boolean online) {
        this.name = name;
        this.multiplayer = multiplayer;
        this.online = online;
    }

    public String getName() {
        return name;
    }

    public boolean isMultiplayer() {
        return multiplayer;
    }

    public boolean isOnline() {
        return online;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Game game = (Game) o;
        return multiplayer == game.multiplayer &&
            online == game.online &&
            Objects.equals(name, game.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, multiplayer, online);
    }
}
