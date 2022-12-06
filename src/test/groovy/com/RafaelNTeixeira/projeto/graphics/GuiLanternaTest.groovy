package com.RafaelNTeixeira.projeto.graphics

import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.model.game.Position
import com.googlecode.lanterna.SGR
import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.graphics.TextGraphics
import com.googlecode.lanterna.screen.Screen
import com.googlecode.lanterna.terminal.Terminal
import org.mockito.Mock
import spock.lang.Specification

class GuiLanternaTest extends Specification{

    private def screen
    private def position
    private def gui
    private def tg
    private def string

    def setup() {
        screen = Mock(Screen.class)
        position = new Position(10, 10)
        tg = Mock(TextGraphics.class);
        string = new String("#FFFFFF")
        gui = new GUILaterna(screen)
        screen.newTextGraphics() >> tg
    }

    def 'Creation with screen'() {
        when:
        Screen s = gui.screen

        then:
        s == screen
    }

    /*def 'Draw Hero'() {
        when:
        gui.drawHero(position)

        then:
        1*tg.setForegroundColor(_)
        1*tg.enableModifiers(_)
        1*tg.putString(_,_)
    }*/

    def 'Draw Wall'() {
        when:
        gui.drawWall(position)

        then:
        1*tg.setBackgroundColor(_)
        1*tg.setForegroundColor(_)
        1*tg.enableModifiers(_)
        1*tg.putString(_,_)
    }

    def 'Draw Monster'() {
        when:
        gui.drawMonster(position)

        then:
        1*tg.setForegroundColor(_)
        1*tg.enableModifiers(_)
        1*tg.putString(_,_)
    }

    def 'Draw Heart'() {
        when:
        gui.drawHeart(position)

        then:
        1*tg.setForegroundColor(_)
        1*tg.enableModifiers(_)
        1*tg.putString(_,_)
    }

    def 'Draw King'() {
        when:
        gui.drawKing(position)

        then:
        1*tg.setForegroundColor(_)
        1*tg.enableModifiers(_)
        1*tg.putString(_,_)
    }

    def 'Draw Text'() {
        when:
        gui.drawText(position, string, string)

        then:
        1*tg.setForegroundColor(_)
        1*tg.putString(_,_,_)
    }

    def 'Clear'() {
        when:
        gui.clear()

        then:
        1*screen.clear()
    }

    def 'Refresh'() {
        when:
        gui.refresh()

        then:
        1*screen.refresh()
    }

    def 'Close'() {
        when:
        gui.close()

        then:
        1*screen.close()
    }

    def 'New text graphics'() {
        when:
        TextGraphics t = screen.newTextGraphics()

        then:
        t instanceof TextGraphics
    }


}
