package com.rumid.vash.domain.gamesfinder;

import java.util.List;

@FunctionalInterface
interface GamerGamesProvider {
    List<Game> provide(Gamer gamer);
}
