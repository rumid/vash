package com.rumid.vash.domain.gamesfinder;

import java.util.List;

public class CommonMultiplayerOnlineGamesFinder implements GamesFinder<Gamer> {
    private final GamerGamesProvider gamerGamesProvider;

    public CommonMultiplayerOnlineGamesFinder(GamerGamesProvider gamerGamesProvider) {
        this.gamerGamesProvider = gamerGamesProvider;
    }

    @Override
    public List<Game> findBy(List<Gamer> gamers) {
        return null;
    }
}
