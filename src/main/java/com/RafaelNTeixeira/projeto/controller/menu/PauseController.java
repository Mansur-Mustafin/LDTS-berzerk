package com.RafaelNTeixeira.projeto.controller.menu;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.States.GameState;
import com.RafaelNTeixeira.projeto.States.MenuState;
import com.RafaelNTeixeira.projeto.controller.Controller;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;
import com.RafaelNTeixeira.projeto.model.menu.Menu;
import com.RafaelNTeixeira.projeto.model.menu.Pause;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class PauseController extends Controller<Pause> {
    public PauseController(Pause pause) {
        super(pause);
    }

    @Override
    public void step(Game game, KeyStroke key, long time) throws IOException {
        if(key == null){
            return;
        }
        switch (key.getKeyType()) {
            case ArrowUp:
                getModel().previousEntry();
                break;
            case ArrowDown:
                getModel().nextEntry();
                break;
            case Enter:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedContinue()) game.setState(game.getOldState());
                if(getModel().isSelectedNewGame()) game.setState(new GameState(new Arena(34, 24, 1)));
                if(getModel().isSelectedGoToMenu()) game.setState(new MenuState(new Menu()));
                break;
            case Character:
                if(key.getCharacter() == 'e'){
                    game.setState(null);
                }
                if(key.getCharacter() == 'q'){
                    game.setState(new MenuState(new Menu()));
                }
                break;
        }
    }
}

