package com.RafaelNTeixeira.projeto.model.menu

import spock.lang.Specification

class PauseTest extends Specification{
    def 'Entry boundaries prev'(){
        given:
        Pause pause = new Pause()

        when:
        pause.previousEntry()

        then:
        pause.isSelected(3)
    }

    def 'Entry boundaries next'(){
        given:
        Pause pause = new Pause()

        when:
        pause.nextEntry()
        pause.nextEntry()
        pause.nextEntry()
        pause.nextEntry()

        then:
        pause.isSelected(0)
    }
}
