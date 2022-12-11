package com.RafaelNTeixeira.projeto.States;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.controller.Controller;
import com.RafaelNTeixeira.projeto.viewer.menuViewer.Viewer;
import com.github.javaparser.utils.Pair;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public abstract class State<T> {
    private final T model;
    private Controller<T> controller;
    private Viewer<T> viewer;


    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    public void setViewer(Viewer<T> v){
        this.viewer = v;
    }

    public void setController(Controller<T> controller){
        this.controller = controller;
    }

    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void step(Game game, GUI gui, long time) throws IOException {
        KeyStroke key = gui.getNextAction();

        controller.step(game, key, time);
        viewer.draw(gui);
    }
}
