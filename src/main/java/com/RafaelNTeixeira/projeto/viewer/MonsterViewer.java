package com.RafaelNTeixeira.projeto.viewer;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Enemy;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Monster;

public class MonsterViewer implements ElementViewer<Monster> {
    @Override
    public void draw(Monster monster, GUI gui) {
        gui.drawMonster(monster.getPosition());
    }
}
