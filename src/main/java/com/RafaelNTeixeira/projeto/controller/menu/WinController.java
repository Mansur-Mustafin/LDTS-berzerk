package com.RafaelNTeixeira.projeto.controller.menu;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.States.AddLeaderState;
import com.RafaelNTeixeira.projeto.States.LeaderBoardState;
import com.RafaelNTeixeira.projeto.States.MenuState;
import com.RafaelNTeixeira.projeto.controller.Controller;
import com.RafaelNTeixeira.projeto.model.menu.AddLeader;
import com.RafaelNTeixeira.projeto.model.menu.Leader;
import com.RafaelNTeixeira.projeto.model.menu.Menu;
import com.RafaelNTeixeira.projeto.model.menu.Win;
import com.RafaelNTeixeira.projeto.model.sounds.Sound;
import com.RafaelNTeixeira.projeto.model.sounds.SoundControl;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class WinController extends Controller<Win> {
    public WinController(Win win){super(win);}

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
                if(getModel().isSelectedMenu()) {
                    SoundControl.getInstance().start(Sound.CHANGETAB);
                    game.setState(new MenuState(new Menu()));
                }
                if(getModel().isSelectedLeaderBoard()) {
                    SoundControl.getInstance().start(Sound.CHANGETAB);
                    game.setState(new LeaderBoardState(new Leader()));
                }
                if(getModel().isSelectedAddToLeaderBoard()) {
                    SoundControl.getInstance().start(Sound.CHANGETAB);
                    game.setState(new AddLeaderState(new AddLeader(getModel().getScore())));
                }
                break;
            case Character:
                if(key.getCharacter() == 'e'){
                    game.setState(null);
                }
                break;
        }
    }
}
