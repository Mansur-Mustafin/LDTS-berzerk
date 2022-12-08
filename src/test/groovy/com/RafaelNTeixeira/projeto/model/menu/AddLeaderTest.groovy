package com.RafaelNTeixeira.projeto.model.menu

import spock.lang.Specification

class AddLeaderTest extends Specification{

    def 'Add Leader creation'() {
        given:
        AddLeader addLeader = new AddLeader(10)

        when:
        int x = addLeader.getNumberEntries()
        int y = addLeader.getScore()

        then:
        x == 2
        y == 10
    }

    def 'Getting, selecting and changing entries'(){
        given:
        AddLeader addLeader = new AddLeader(10)
        String menu = new String("menu")
        String leader = new String("leader board")

        when:
        boolean fmenu = addLeader.isSelectedMenu()
        addLeader.nextEntry()
        boolean fleader = addLeader.isSelectedLeaderBoard()
        boolean f1 = addLeader.isSelected(1)
        String y = addLeader.getEntry(0)
        addLeader.previousEntry()
        String z = addLeader.getEntry(1)

        then:
        f1 && fmenu && fleader
        y == menu
        z == leader
    }

    def 'Deleting char'() {
        given:
        AddLeader addLeader = new AddLeader(10)
        addLeader.setName("Ian")
        String name = new String("Ia")

        when:
        addLeader.delChar()
        String name1 = addLeader.getName()

        then:
        name == name1
    }


}
