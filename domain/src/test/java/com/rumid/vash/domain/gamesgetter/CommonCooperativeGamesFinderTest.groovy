package com.rumid.vash.domain.gamesgetter

import spock.lang.Specification

class CommonCooperativeGamesFinderTest extends Specification {
    CommonCooperativeGamesFinder sut
    GamerGamesProvider gamerGamesProvider

    def setup() {
        gamerGamesProvider = Mock()
        sut = new CommonCooperativeGamesFinder(gamerGamesProvider)
    }

    def "Should return common cooperative games"() {
        given:
            def gamer1 = new Gamer("gamer1", "1", "ab1")
            def gamer2 = new Gamer("gamer1", "2", "ab2")
            def gamers = List.of(gamer1, gamer2)

        when:
            def listOfGames = sut.apply(gamers)
        then:
            (1.._) * gamerGamesProvider.provide(*_)
            gamers.size() * gamerGamesProvider.provide(*_)
            !listOfGames.empty

    }
}
