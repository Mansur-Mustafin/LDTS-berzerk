package com.RafaelNTeixeira.projeto;

import com.RafaelNTeixeira.projeto.Graphics.GUILaterna;
import com.RafaelNTeixeira.projeto.States.MenuState;
import com.RafaelNTeixeira.projeto.States.State;
import com.RafaelNTeixeira.projeto.model.menu.Menu;


import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final GUILaterna gui;
    private State state;
    private State oldState;

    protected int Score = 0;

    public Game() throws IOException, FontFormatException, URISyntaxException {
        this.gui = new GUILaterna(34, 24);
        this.state = new MenuState(new Menu());
    }

    public void setOldState(State oldState) {
        this.oldState = oldState;
    }
    public State getState(){
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    public State getOldState(){
        return oldState;
    }

    public void setScore(int Score){
        this.Score = Score;
    }
    public int getScore(){
        return Score;
    }
    public void incrementScore(int x){
        Score += x;
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
