package com.rumid.vash.domain.gamesgetter;

import java.util.Objects;

public final class Gamer {
    private final String name;
    private final String id;
    private final String key;

    public Gamer(String name, String id, String key) {
        this.name = name;
        this.id = id;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gamer)) return false;
        Gamer gamer = (Gamer) o;
        return Objects.equals(getName(), gamer.getName()) &&
                Objects.equals(getId(), gamer.getId()) &&
                Objects.equals(getKey(), gamer.getKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId(), getKey());
    }
}
