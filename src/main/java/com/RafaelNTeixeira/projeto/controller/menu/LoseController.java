package com.RafaelNTeixeira.projeto.controller.menu;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.States.AddLeaderState;
import com.RafaelNTeixeira.projeto.States.LeaderBoardState;
import com.RafaelNTeixeira.projeto.States.MenuState;
import com.RafaelNTeixeira.projeto.controller.Controller;
import com.RafaelNTeixeira.projeto.model.menu.*;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;


public class LoseController extends Controller<Lose> {
    public LoseController(Lose lose) {
        super(lose);
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
                if(getModel().isSelectedMenu()) game.setState(new MenuState(new Menu()));
                if(getModel().isSelectedLeaderBoard()) game.setState(new LeaderBoardState( new Leader()));
                if(getModel().isSelectedAddToLeaderBoard()) game.setState(new AddLeaderState(new AddLeader()));
                break;
            case Character:
                if(key.getCharacter() == 'e'){
                    game.setState(null);
                }
                break;
        }
    }
}
