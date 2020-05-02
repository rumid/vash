package com.rumid.vash.domain.gamesgetter;

import java.util.List;

public class CommonCooperativeGamesFinder implements GamesGetter {
    private final GamerGamesProvider gamerGamesProvider;

    public CommonCooperativeGamesFinder(GamerGamesProvider gamerGamesProvider) {
        this.gamerGamesProvider = gamerGamesProvider;
    }

    @Override
    public List<Game> apply(List<Gamer> gamers) {
        return null;
    }
}
