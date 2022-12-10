package com.RafaelNTeixeira.projeto.model.menu

import spock.lang.Specification

class WinTest extends Specification{
    def 'Entry boundaries prev'(){
        given:
        Win win = new Win(10)

        when:
        win.previousEntry()

        then:
        win.isSelected(2)
    }

    def 'Entry boundaries next'(){
        given:
        Win win = new Win(10)

        when:
        win.nextEntry()
        win.nextEntry()
        win.nextEntry()


        then:
        win.isSelected(0)
    }
}
