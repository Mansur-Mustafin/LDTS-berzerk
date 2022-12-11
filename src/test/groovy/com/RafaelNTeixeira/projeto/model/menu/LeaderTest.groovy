package com.RafaelNTeixeira.projeto.model.menu

import com.RafaelNTeixeira.projeto.Player
import spock.lang.Specification

class LeaderTest extends Specification{

    def 'Getting, selecting and changing entries'(){
        given:
        Leader leader = new Leader()
        String entry = new String("press enter to back menu")

        when:
        String x = leader.getEntry(0)
        boolean f1 = leader.isSelectedEnter()

        then:
        entry == x
        f1
    }

    def 'get n of players'(){
        given:
        Leader leader = new Leader()

        when:
        int x = leader.players.size()

        then:
        x == leader.getNumberOfplayers()

    }

    def 'contains'(){
        given:
        Leader leader = new Leader()
        List<Player> playerList = new ArrayList<>()
        Player player = new Player('Ian', '100')
        Player player1 = new Player('Mansur', '0')
        playerList.add(player)

        when:
        boolean f1 = leader.Contains(playerList, player)
        boolean f2 = leader.Contains(playerList, player1)

        then:
        f1
        !f2
    }

    def 'Index'(){
        given:
        Leader leader = new Leader()
        List<Player> playerList = new ArrayList<>()
        Player player = new Player('Ian', '100')
        Player player1 = new Player('Mansur', '0')
        Player player2 = new Player('Rafael', '0')
        playerList.add(player)
        playerList.add(player1)

        when:
        int index = leader.Index(playerList, player)
        int index1 = leader.Index(playerList, player1)
        int index2 = leader.Index(playerList, player2)


        then:
        index == 0
        index1 == 1
        index2 == -1
    }
}
