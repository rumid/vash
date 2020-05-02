package com.rumid.vash.domain.gamesgetter;

import java.util.List;

@FunctionalInterface
interface GamerGamesProvider {
    List<Game> provide(Gamer gamer);
}
