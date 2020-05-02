package com.rumid.vash.domain.gamesgetter;

@FunctionalInterface
interface GameDetailsProvider {
    GameDetails provide(Game game);
}
