package com.RafaelNTeixeira.projeto.model.menu

import spock.lang.Specification

class LeaderTest extends Specification{

    def 'Getting, selecting and changing entries'(){
        given:
        Leader leader = new Leader()
        String entry = new String("Press enter to Back menu")

        when:
        String x = leader.getEntry(0)
        boolean f1 = leader.isSelectedEnter()

        then:
        entry == x
        f1
    }
}
