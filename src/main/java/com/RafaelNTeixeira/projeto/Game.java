package com.RafaelNTeixeira.projeto;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;

import java.io.IOException;

public class Game {
    private TerminalScreen screen;

    private Arena arena = new Arena(100, 30);

    public Game() throws IOException {

        try {
            TerminalSize terminalSize = new TerminalSize(arena.getWidth(), arena.getHeight());
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            this.screen = new TerminalScreen(terminal);
            this.screen.setCursorPosition(null); // we don't need a cursor
            this.screen.startScreen(); // screens must be started
            this.screen.doResizeIfNecessary(); // resize screen if necessary
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void draw() throws IOException {
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void run() throws IOException {
        arena.moveMonster(screen, screen.newTextGraphics());
        while(true){
            draw();
            KeyStroke key = screen.readInput();
            if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
                arena.timer_for_Monsters.cancel();
                arena.timer_for_Monsters.purge();
                screen.close();
            }
            if(key.getKeyType() == KeyType.EOF){
                arena.timer_for_Monsters.cancel();
                arena.timer_for_Monsters.purge();
                break;
            }
            arena.processKey(key);
        }
    }
}
