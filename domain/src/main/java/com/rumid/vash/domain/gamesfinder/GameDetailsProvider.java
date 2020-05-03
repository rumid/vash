package com.rumid.vash.domain.gamesfinder;

@FunctionalInterface
interface GameDetailsProvider {
    GameDetails provide(Game game);
}
