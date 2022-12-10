package com.RafaelNTeixeira.projeto.model.menu

import spock.lang.Specification

class LoseTest extends Specification{

    def 'Entry boundaries prev'(){
        given:
        Lose lose = new Lose(10)

        when:
        lose.previousEntry()

        then:
        lose.isSelected(2)
    }

    def 'Entry boundaries next'(){
        given:
        Lose lose = new Lose(10)

        when:
        lose.nextEntry()
        lose.nextEntry()
        lose.nextEntry()

        then:
        lose.isSelected(0)
    }

}
