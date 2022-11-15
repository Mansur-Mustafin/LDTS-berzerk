package com.RafaelNTeixeira.projeto;

import com.RafaelNTeixeira.projeto.Graphics.GUILaterna;
import com.RafaelNTeixeira.projeto.States.MenuState;
import com.RafaelNTeixeira.projeto.States.State;
import com.RafaelNTeixeira.projeto.model.menu.Menu;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;

import java.io.IOException;

public class Game {
    private GUILaterna gui;
    private State state;

    public Game() throws IOException {
        state = new MenuState(new Menu());
        gui = new GUILaterna(100, 30);
    }

    public void setState(State state) {
        this.state = state;
    }

    public void run() throws IOException {
        int frameTime = 1000 / 120;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
        gui.close();
    }
}
