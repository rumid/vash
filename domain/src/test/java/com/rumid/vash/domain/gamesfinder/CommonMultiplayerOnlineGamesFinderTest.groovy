package com.rumid.vash.domain.gamesfinder

import spock.lang.Specification

class CommonMultiplayerOnlineGamesFinderTest extends Specification {
    CommonMultiplayerOnlineGamesFinder sut
    GamerGamesProvider gamerGamesProvider

    def setup() {
        gamerGamesProvider = Mock()
        sut = new CommonMultiplayerOnlineGamesFinder(gamerGamesProvider)
    }

    def "Should get games for each player"() {
        given:
            def gamer1 = new Gamer("gamer1", "1", "ab1")
            def gamer2 = new Gamer("gamer1", "2", "ab2")
            def gamers = List.of(gamer1, gamer2)
        when:
            sut.findBy(gamers)
        then:
            gamers.size() * gamerGamesProvider.provide(_ as Gamer) >> List.of()
    }

    def "Should return common games"() {
        given:
            def gamer1 = new Gamer("gamer1", "1", "ab1")
            def gamer2 = new Gamer("gamer1", "2", "ab2")
            def gamers = List.of(gamer1, gamer2)
            def commonGame = new Game("common title 1", true, true)
            gamerGamesProvider.provide(_ as Gamer) >>> [List.of(commonGame),
                                                        List.of(commonGame)]
        when:
            def listOfGames = sut.findBy(gamers)
        then:
            !listOfGames.empty
            listOfGames.contains(commonGame)
    }

    def "Should return only multiplayer games"() {
        given:
            def gamer1 = new Gamer("gamer1", "1", "ab1")
            def gamer2 = new Gamer("gamer1", "2", "ab2")
            def gamers = List.of(gamer1, gamer2)
            def commonGame1 = new Game("common title 1", true, true)
            def commonGame2 = new Game("common title 2", false, true)
            gamerGamesProvider.provide(_ as Gamer) >>> [List.of(commonGame1, commonGame2),
                                                        List.of(commonGame1, commonGame2)]
        when:
            def listOfGames = sut.findBy(gamers)
        then:
            !listOfGames.empty
            listOfGames.every { game -> game.multiplayer }
    }

    def "Should return only online games"() {
        given:
            def gamer1 = new Gamer("gamer1", "1", "ab1")
            def gamer2 = new Gamer("gamer1", "2", "ab2")
            def gamers = List.of(gamer1, gamer2)
            def commonGame1 = new Game("common title 1", true, true)
            def commonGame2 = new Game("common title 2", true, false)
            gamerGamesProvider.provide(_ as Gamer) >>> [List.of(commonGame1, commonGame2),
                                                        List.of(commonGame1, commonGame2)]
        when:
            def listOfGames = sut.findBy(gamers)
        then:
            !listOfGames.empty
            listOfGames.every { game -> game.online }
    }

    def "Should not return uncommon games"() {
        given:
            def gamer1 = new Gamer("gamer1", "1", "ab1")
            def gamer2 = new Gamer("gamer1", "2", "ab2")
            def gamers = List.of(gamer1, gamer2)
            def uncommonGame1 = new Game("common title 1", false, false)
            def uncommonGame2 = new Game("common title 2", false, false)
            gamerGamesProvider.provide(_ as Gamer) >>> [List.of(uncommonGame1),
                                                        List.of(uncommonGame2)]
        when:
            def listOfGames = sut.findBy(gamers)
        then:
            listOfGames.empty
    }
}
