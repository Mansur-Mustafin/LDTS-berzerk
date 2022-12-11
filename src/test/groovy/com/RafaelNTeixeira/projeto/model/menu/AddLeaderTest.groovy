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
        boolean fleader2 = addLeader.isSelectedLeaderBoard()
        addLeader.nextEntry()
        boolean fleader = addLeader.isSelectedLeaderBoard()
        boolean fmenu2 = addLeader.isSelectedMenu()
        boolean f1 = addLeader.isSelected(1)
        String y = addLeader.getEntry(0)
        addLeader.previousEntry()
        String z = addLeader.getEntry(1)

        then:
        f1 && fmenu && fleader
        y == menu
        z == leader
        !fleader2
        !fmenu2
    }

    def 'Entry boundaries prev'(){
        given:
        AddLeader addLeader = new AddLeader(10)

        when:
        addLeader.nextEntry()
        addLeader.previousEntry()

        then:
        addLeader.isSelected(0)
    }

    def 'Entry boundaries prev'(){
        given:
        AddLeader addLeader = new AddLeader(10)

        when:
        addLeader.previousEntry()
        addLeader.nextEntry()


        then:
        addLeader.isSelected(0)
    }
    def 'Entry boundaries prev'(){
        given:
        AddLeader addLeader = new AddLeader(10)

        when:
        addLeader.previousEntry()
        addLeader.previousEntry()

        then:
        addLeader.isSelected(0)
    }

    def 'Entry boundaries prev'(){
        given:
        AddLeader addLeader = new AddLeader(10)

        when:
        addLeader.previousEntry()

        then:
        addLeader.isSelected(1)
    }

    def 'Entry boundaries next'(){
        given:
        AddLeader addLeader = new AddLeader(10)

        when:
        addLeader.nextEntry()
        addLeader.nextEntry()

        then:
        addLeader.isSelected(0)
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
