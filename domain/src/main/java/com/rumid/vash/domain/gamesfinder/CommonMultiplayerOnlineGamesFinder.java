package com.rumid.vash.domain.gamesfinder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CommonMultiplayerOnlineGamesFinder implements GamesFinder<Gamer> {
    private final GamerGamesProvider gamerGamesProvider;

    public CommonMultiplayerOnlineGamesFinder(GamerGamesProvider gamerGamesProvider) {
        this.gamerGamesProvider = gamerGamesProvider;
    }

    @Override
    public List<Game> findBy(List<Gamer> gamers) {
        return gamers.stream()
            .map(gamerGamesProvider::provide)
            .map(this::onlyMultiplayerAndOnline)
            .reduce(this::getCommonGames)
            .orElse(Collections.emptyList());
    }

    private List<Game> getCommonGames(List<Game> games1, List<Game> games2) {
        return games1.stream()
            .filter(games2::contains)
            .collect(Collectors.toList());
    }

    private List<Game> onlyMultiplayerAndOnline(List<Game> gamerGames) {
        return gamerGames.stream()
            .filter(Game::isMultiplayer)
            .filter(Game::isOnline)
            .collect(Collectors.toList());
    }
}
