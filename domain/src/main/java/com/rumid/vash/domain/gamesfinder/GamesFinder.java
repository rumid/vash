package com.rumid.vash.domain.gamesfinder;

import java.util.List;

@FunctionalInterface
public interface GamesFinder<T> {
    List<Game> findBy(List<T> gamers);
}
