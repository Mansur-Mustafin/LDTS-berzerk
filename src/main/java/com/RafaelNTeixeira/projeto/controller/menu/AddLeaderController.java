package com.RafaelNTeixeira.projeto.controller.menu;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.States.LeaderBoardState;
import com.RafaelNTeixeira.projeto.controller.Controller;
import com.RafaelNTeixeira.projeto.model.menu.AddLeader;
import com.RafaelNTeixeira.projeto.model.menu.Leader;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

public class AddLeaderController extends Controller<AddLeader> {
    public AddLeaderController(AddLeader lose) {
        super(lose);
    }

    @Override
    public void step(Game game, KeyStroke key, long time) throws IOException {

        if(key == null){
            return;
        }
        if (key.getKeyType() == KeyType.Enter) {
            getModel().addScore();
            game.setState(new LeaderBoardState(new Leader()));
        }
        if(key.getKeyType() == KeyType.Character){
            getModel().addChar(key.getCharacter());
        }
        if(key.getKeyType() == KeyType.Backspace){
            if(getModel().getName().length() == 0){
                return;
            }
            getModel().delChar();
        }
    }
}
