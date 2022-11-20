package com.RafaelNTeixeira.projeto.controller.menu;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.States.MenuState;
import com.RafaelNTeixeira.projeto.controller.Controller;
import com.RafaelNTeixeira.projeto.model.menu.Leader;
import com.RafaelNTeixeira.projeto.model.menu.Lose;
import com.RafaelNTeixeira.projeto.model.menu.Menu;

import java.io.IOException;

public class LeaderController extends Controller<Leader> {
    public LeaderController(Leader leader) {
        super(leader);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {

            case SELECT:
                if(getModel().isSelectedEnter()) game.setState(new MenuState(new Menu()));
                break;
            case EXIT:
                game.setState(null);
                break;
            case NONE:
                break;
        }
    }
}
