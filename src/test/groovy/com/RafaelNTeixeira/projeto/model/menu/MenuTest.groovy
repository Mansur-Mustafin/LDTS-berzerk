package com.RafaelNTeixeira.projeto.model.menu

import com.RafaelNTeixeira.projeto.model.menu.Menu
import spock.lang.Specification

class MenuTest extends Specification{

    def 'Menu Creation' () {
        given:
        Menu menu = new Menu()
        String entrytest = "start"

        when:
        String entry = menu.getEntry(0)

        then:
        entry == entrytest
    }

    def 'Switching and getting entries'() {
        given:
        Menu menu = new Menu()
        String entryStart = "start"
        String entryExit = "exit"
        int n = 4

        when:
        int entry_n = menu.getNumberEntries()
        menu.nextEntry()
        boolean f1 = menu.isSelected(1)
        menu.previousEntry()
        boolean f2 = menu.isSelected(0)

        then:
        entry_n == n
        entryStart == menu.getEntry(0)
        entryExit == menu.getEntry(1)
        f1 && f2
    }

    def 'Start and end Selected'() {
        given:
        Menu menu = new Menu()

        when:
        boolean f1 = menu.isSelectedStart()
        boolean f3 = menu.isSelectedExit()
        menu.nextEntry()
        boolean f2 = menu.isSelectedExit()
        boolean f4 = menu.isSelectedStart()

        then:
        f1 && f2
        !f3
        !f4
    }

    def 'Entry boundaries prev'(){
        given:
        Menu menu = new Menu()

        when:
        menu.previousEntry()

        then:
        menu.isSelected(3)
    }

    def 'Entry boundaries next'(){
        given:
        Menu menu = new Menu()

        when:
        menu.nextEntry()
        menu.nextEntry()
        menu.nextEntry()
        menu.nextEntry()

        then:
        menu.isSelected(0)
    }
}
