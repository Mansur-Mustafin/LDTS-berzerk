package com.RafaelNTeixeira.projeto.States;

import com.RafaelNTeixeira.projeto.controller.Controller;
import com.RafaelNTeixeira.projeto.controller.game.ArenaController;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;
import com.RafaelNTeixeira.projeto.viewer.gameViewer.GameViewer;
import com.RafaelNTeixeira.projeto.viewer.menuViewe.Viewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}