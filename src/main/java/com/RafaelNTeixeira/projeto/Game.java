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

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final GUILaterna gui;
    private State state;

    public Game() throws IOException, FontFormatException, URISyntaxException {
        this.gui = new GUILaterna(90, 30);
        this.state = new MenuState(new Menu());
    }

    public void setState(State state) {
        this.state = state;
    }

    public void run() throws IOException {
        int frameTime = 1000 / 50;

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
