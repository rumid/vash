package com.rumid.vash.domain.gamesgetter;

import java.util.List;

public interface GamesGetter {
    List<Game> apply(List<Gamer> gamers);
}
