package com.RafaelNTeixeira.projeto.controller;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game game, KeyStroke key, long time) throws IOException;
}
