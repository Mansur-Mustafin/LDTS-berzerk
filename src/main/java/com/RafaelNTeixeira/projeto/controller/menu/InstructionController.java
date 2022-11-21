package com.RafaelNTeixeira.projeto.controller.menu;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.States.MenuState;
import com.RafaelNTeixeira.projeto.controller.Controller;
import com.RafaelNTeixeira.projeto.model.menu.Instruction;
import com.RafaelNTeixeira.projeto.model.menu.Menu;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class InstructionController extends Controller<Instruction> {
    public InstructionController(Instruction instruction) {
        super(instruction);
    }

    @Override
    public void step(Game game, KeyStroke key, long time) throws IOException {
        if (key == null) return;

        switch (key.getKeyType()) {
            case Enter:
                if (getModel().isSelectedEnter()) game.setState(new MenuState(new Menu()));
                break;
            case Character:
                if (key.getCharacter() == 'e'){
                    game.setState(null);
                }
                break;
        }
    }
}