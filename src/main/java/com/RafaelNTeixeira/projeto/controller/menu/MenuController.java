package com.RafaelNTeixeira.projeto.controller.menu;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.States.GameState;
import com.RafaelNTeixeira.projeto.States.LeaderBoard;
import com.RafaelNTeixeira.projeto.controller.Controller;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;
import com.RafaelNTeixeira.projeto.model.menu.Leader;
import com.RafaelNTeixeira.projeto.model.menu.Menu;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()) game.setState(new GameState(new Arena(100, 60)));
                if(getModel().isSelectedLeaderBoard()) game.setState(new LeaderBoard( new Leader()));
                break;
            case EXIT:
                game.setState(null);
                break;
            case NONE:
                break;
        }
    }
}
